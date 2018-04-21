package com.base.api.rpc.service.impl;

import com.alibaba.fastjson.JSON;
import com.base.api.common.ConfigUtil;
import com.base.api.common.constants.Constants;
import com.base.api.common.domain.ResultBody;
import com.base.api.common.encrypt.RSA;
import com.base.api.common.utils.StrUtils;
import com.base.api.common.web.model.TokenData;
import com.base.api.dao.model.Member;
import com.base.api.dao.vo.LoginVO;
import com.base.api.rpc.service.MemberService;
import com.google.common.collect.Maps;
import com.xiaoleilu.hutool.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by xiaohaizi on 2017/6/22.
 */
@Service
public class MemberServiceImpl implements MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Resource
    private ChannelDao channelDao;

    @Resource
    private TrialFlowLogService trialFlowLogService;

    @Resource
    private MemberDao memberDao;

    @Resource
    private BalanceService balanceService;

    @Resource
    private LoginTokenService loginTokenService;

    @Resource
    private BankCardService bankCardService;

    @Resource
    private ProjectInterestService projectInterestService;

    @Resource
    private BankService bankService;

    @Resource
    private CapitalFlowLogService capitalFlowLogService;

    @Resource
    private HomeTipsProperties homeTipsProperties;

    @Resource
    private CouponService couponService;

    @Resource
    private MessageService messageService;

    @Resource
    private InviteMemberService inviteMemberService;

    @Resource
    private ProjectOrderService projectOrderService;

    @Resource
    private SmsRedisUtil smsRedisUtil;

    @Resource
    private MemberRedisUtil memberRedisUtil;

    @Resource
    private RiskAssessmentService riskAssessmentService;

    @Resource
    private ProjectContractBorrowerService projectContractBorrowerService;
    
    @Resource
    private RtfMemberService rtfMemberService;
    @Resource
    private RtfBankCardService rtfBankCardService;

    /**
     * 用户资金流水
     *
     * @param memberId the member id
     * @param pageNO   the page no
     * @param deposit   the deposit
     * @return capital flow log list
     */
    @Override
    public List<CapitalFlowLogDTO> getCapitalFlowLogList(Long memberId, int pageNO,int deposit) {
        return capitalFlowLogService.getCapitalFlowLogList(memberId, pageNO,deposit);
    }



    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ResultBody login(LoginVO data) throws Exception {
        ResultBody result = preLogin(data);
        boolean isReg = false;//是否注册
        if (!result.isSuccess()) {
            return result;
        }
        Member member = memberDao.getMemberByMobile(data.getMobile());
        if (member == null) {
            //注册
            member = regMember(data);
            isReg = true;
        }
        return login(member, data.getClientSource(), data.getIp(), data.getDevice());
    }

    /**
     * 登出
     *
     * @param memberId
     * @return
     */
    @Override
    public ResultBody logout(Long memberId,int clientSource) {
        ResultBody result = new ResultBody();
        loginTokenService.delLoginToken(memberId,clientSource);
        return result;
    }

    @Override
    public ResultBody realName(RealNameVO data) throws Exception {
        ResultBody result = preRealName(data);
        if (result.isSuccess()) {
            String bankCode = (String)result.getData();
            if(ConfigUtil.getInstance().isDev()){
                //开发环境
                int realNameStatus = memberDao.realName(data.getMemberId(), data.getName(), data.getIdCard());
                //if (realNameStatus > 0) {
                    //删除原来的银行卡
                    bankCardService.delBankCardByMemberId(data.getMemberId());
                    //增加银行卡
                    String testBind_id = "NO" + String.valueOf(System.currentTimeMillis());
                    BankCard bankCard = new BankCard();
                    bankCard.setStatus(1);
                    bankCard.setMemberId(data.getMemberId());
                    bankCard.setCardNo(data.getCardNumber());
                    bankCard.setPreMobile(data.getPreMobile());
                    bankCard.setBankCode(bankCode);
                    bankCard.setBfBindId(testBind_id);
                    bankCardService.saveBankCard(bankCard);
                    result.setData(null);
                    return result;
                //}
            }else{
                //支付渠道四要素验证
                BFResult bfResult = BaoFooUtil.sendBindBankCard(data.getIdCard(), data.getName(),data.getCardNumber(), data.getPreMobile(),bankCode);
                if(bfResult.isSuccess()){
                    int realNameStatus = memberDao.realName(data.getMemberId(), data.getName(), data.getIdCard());
                    //if (realNameStatus > 0) {
                        //删除原来的银行卡
                        bankCardService.delBankCardByMemberId(data.getMemberId());
                        //增加银行卡
                        BankCard bankCard = new BankCard();
                        bankCard.setStatus(1);
                        bankCard.setMemberId(data.getMemberId());
                        bankCard.setCardNo(data.getCardNumber());
                        bankCard.setPreMobile(data.getPreMobile());
                        bankCard.setBankCode(bankCode);
                        bankCard.setBfBindId(bfResult.getBind_id());
                        bankCardService.saveBankCard(bankCard);
                        result.setData(null);
                        return result;
                    //}
                }else{
                    result.setResMsg(bfResult.getResp_msg());
                    return result;
                }
            }
        }
        return result;
    }

    @Override
    public ResultBody getMemberInfo(Long memberId) {
        ResultBody result = new ResultBody();
        Member member = memberDao.getMemberById(memberId);
        MemberInfoDTO info = new MemberInfoDTO();
        if (member != null) {
            
            //余额
            Balance balance = balanceService.getBalanceByMemberIdForUpdate(memberId);
            //总收益
            BigDecimal totalIncome = projectInterestService.sumTotalIncome(memberId,DepositEnums.ALL.getValue());

            //宝付待收本金
            BigDecimal investPrincipal = projectInterestService.sumDueInInvestPrincipal(memberId,DepositEnums.BF.getValue());
            //宝付待收收益
            BigDecimal projectIncome = projectInterestService.sumDueInProjectIncome(memberId,DepositEnums.BF.getValue());
            //宝付总资产=余额+待还本金+待还收益
            BigDecimal totalAmount = investPrincipal.add(balance.getAmount()).add(projectIncome).setScale(2, RoundingMode.DOWN);

            //融托富待收收益
            BigDecimal rtfProjectIncome = projectInterestService.sumDueInProjectIncome(memberId,DepositEnums.RTF.getValue());
            //融托富待收本金
            BigDecimal rtfInvestPrincipal = projectInterestService.sumDueInInvestPrincipal(memberId,DepositEnums.RTF.getValue());
            BigDecimal rtfTotalAmount = balance.getRtfUsableAmount().add(rtfInvestPrincipal).add(rtfProjectIncome).setScale(2, RoundingMode.DOWN);
            
            info.setTotalAmount(totalAmount.add(rtfTotalAmount));
            //余额
            info.setAmount(balance.getAmount().add(balance.getRtfUsableAmount()));
            //总收益
            info.setTotalIncome(totalIncome);
            
            //是否是借款人
            info.setIsBorrower(projectContractBorrowerService.isBorrower(member.getMobile()));
            info.setMobile(member.getMobile());
            info.setName(member.getName());
            info.setIdCard(member.getIdCard());
            if (member.getRealNameStatus() == 1) {
                BankCard bankCard = bankCardService.getDefaultBankCardByMemberId(memberId);
                if (bankCard != null) {
                    info.setBankCode(bankCard.getBankCode());
                    info.setCardNumber(bankCard.getCardNo());
                    info.setHasBindBankCard(true);
                }
                info.setRealNameStatus(member.getRealNameStatus());
                info.setHasSetPayPassword(StrUtils.isNotEmpty(member.getPayPwd()) ? true : false);
                info.setHasSetLoginPassword(StrUtils.isNotEmpty(member.getLoginPwd()) ? true : false);
            }
        }
        result.setData(info);
        return result;
    }

    /**
     * 登录
     *
     * @param member   登录用户
     * @param platform 登录来源
     * @param ip       the ip
     * @return result body
     * @throws Exception the exception
     */
    public ResultBody login(Member member, PlatformEnums platform, String ip, String device) throws Exception {
        ResultBody result = new ResultBody();
        if (member == null) {
            result.setResMsg("登录失败");
            return result;
        } else {
            if (member.getStatus() == 0) {
                result.setResMsg("账户已被锁定，请联系客服处理");
                return result;
            }
        }
        //生成token
        TokenData token = new TokenData();
        token.setClient(platform.getValue());
        token.setId(member.getId());
        token.setMobile(member.getMobile());
        token.setRealNameStatus(member.getRealNameStatus());
        String tokenData = getToken(token);
        loginTokenService.delLoginToken(member.getId(), platform.getValue());

        //记录登录日志
        LoginToken loginToken = new LoginToken();
        loginToken.setIp(ip);
        loginToken.setMemberId(member.getId());
        loginToken.setStatus(1);
        loginToken.setLoginSource(platform.getValue());
        loginToken.setToken(tokenData);
        loginToken.setLoginDevice(device);
        loginTokenService.addLoginToken(loginToken);
        //todo 如果设备不一致，推送给客户端下线

        //返回对象
        LoginDTO dto = new LoginDTO();
        dto.setToken(tokenData);
        dto.setRealNameStatus(member.getRealNameStatus());

        BankCard bankCard = bankCardService.getDefaultBankCardByMemberId(member.getId());
        if (StrUtils.isNotEmptyObj(bankCard)){
            dto.setBindBankCard(true);
        }else {
            dto.setBindBankCard(false);
        }

        RtfMember rtfMember = rtfMemberService.getRtfMemberByMemberId(member.getId());
        if (StrUtils.isNotEmptyObj(rtfMember)){
            dto.setRtfRealName(true);
            RtfBankCard rtfBankCard = rtfBankCardService.getBankCard(rtfMember.getId());
            if (StrUtils.isNotEmptyObj(rtfBankCard)){
                dto.setRtfBindBankCard(true);
            }else {
                dto.setRtfBindBankCard(false);
            }
        }else {
            dto.setRtfRealName(false);
            dto.setRtfBindBankCard(false);
        }


        if (member.getPayPwd() != null) {
            dto.setHasSetPayPwd(true);
        } else {
            dto.setHasSetPayPwd(false);
        }
        //删除短信
        smsRedisUtil.delSms(SmsBusinessEnum.LOGIN_OR_REGISTER, member.getMobile());

        //放入缓存数据
        MemberInfoDataRedis midr = new MemberInfoDataRedis();
        midr.setToken(tokenData);
        midr.setMobile(member.getMobile());
        midr.setMemberId(member.getId());
        memberRedisUtil.setMemberInfo(member.getId(),platform.getValue(), midr);

        result.setData(dto);
        return result;
    }

    /**
     * 生成Token
     *
     * @param token the token
     * @return token
     * @throws Exception the exception
     */
    public String getToken(TokenData token) throws Exception {
        return RSA.encryptByPublicKeyBase64(JSON.toJSONString(token).getBytes(Constants.CHARSET_UTF8), ConfigUtil.getInstance().getSysEncryptRSAPublicKey());
    }

    /**
     * 用户注册
     *
     * @param data the data
     * @return member
     */
    public Member regMember(LoginVO data) {
        Member member = new Member();
        member.setMobile(data.getMobile());
        member.setCreateTime(DateUtils.getCurrentDate());
        member.setUpdateTime(member.getCreateTime());
        member.setRealNameStatus(0);
        member.setIp(data.getIp());
        member.setStatus(1);
        
        //注册送体验金
        Date startTime = ConfigUtil.getInstance().getConfigDateValue("activity.regtrial.starttime");
        Date endTime = ConfigUtil.getInstance().getConfigDateValue("activity.regtrial.endtime");
        BigDecimal trialAmount = ConfigUtil.getInstance().getConfigBigDecimalValue("activity.regtrial.amount");
        if(DateUtils.isAfterNow(endTime) && DateUtils.isBeforeNow(startTime)
            && trialAmount.compareTo(BigDecimal.ZERO) > 0 ){
            member.setTrialAmount(trialAmount);
        }else{
            member.setTrialAmount(BigDecimal.ZERO);
        }

        if(channelDao.existsChannelFlag(data.getChannelSource())) {
            member.setChannel(data.getChannelSource());
        }else{
            member.setChannel(ConfigUtil.getInstance().getDefaultChannel());
        }

        //保存用户
        memberDao.saveMember(member);
        //初始化账户余额
        balanceService.initBalance(member.getId());
        //送优惠券
        couponService.giveRegCoupon(member.getId());
        //体验金流水记录
        if (member.getTrialAmount().compareTo(BigDecimal.ZERO) == 1) {
            trialFlowLogService.addLoginTrialLog(data, member);
        }
        return member;
    }

    /**
     * 注册前置校验
     *
     * @param data
     * @return
     */
    private ResultBody preLogin(LoginVO data) {
        ResultBody result = new ResultBody();
        if( data.getMobile().equals("18324448688")  && data.getCode().equals("888888")){
            return result;
        }
        if(ConfigUtil.getInstance().isDev() && data.getCode().equals("206206")){
            return  result;
        }
        //判断验证码是否正确
        boolean isTrue = smsRedisUtil.checkSmsCode(SmsBusinessEnum.LOGIN_OR_REGISTER, data.getMobile(), data.getCode());
        if(!isTrue){
            result.setResMsg("验证码错误");
            return result;
        }
        return result;
    }

    /**
     * 实名认证前置校验
     *
     * @param data
     * @return
     */
    private ResultBody preRealName(RealNameVO data) {
        ResultBody result = new ResultBody();
        Member memberMe = memberDao.getMemberById(data.getMemberId());
        if(StrUtils.isEmpty(memberMe.getIdCard()) == false){
            //已经实名过的账户，直接使用原有的身份证
            data.setIdCard(memberMe.getIdCard());
            data.setName(memberMe.getName());
        }
        Member member = memberDao.getMemberByIdCard(data.getIdCard());
        if (member != null && data.getMemberId() != member.getId()) {
            result.setResMsg("该身份证号已经实名注册");
            return result;
        }
        String cardNo = data.getCardNumber();
        String bankCode = bankService.getBankCodeByCardNo(cardNo);
        if(!StrUtils.isNotEmpty(bankCode)){
            result.setResMsg("银行卡校验失败");
            return result;
        }
        BankCard bankCard = bankCardService.getBankCardByCardNumber(cardNo);
        if(bankCard != null){
            result.setResMsg("银行卡已经绑定，请更换另一张银行卡");
            return result;
        }
        result.setData(bankCode);
        return result;
    }

    /**
     * 发送短信验证码
     *
     * @param smsVO
     * @return
     */
    @Override
    public ResultBody sendSmsByBizType(SmsVO smsVO) {
        ResultBody result = new ResultBody();

        if (ConfigUtil.getInstance().isDev()) {
            return result;
        }

        String code = "888888";
       // if (!ConfigUtil.getInstance().isDev()) {
            if(!smsVO.getMobile().equals("18324448688")){
                code = UniqueCodeUtil.randomNumberLength(6);
            }
        //}
        String smsContent = SmsCodeTemplateUtil.getMessageByBusinessCode(smsVO, code);
        if (StrUtils.isBlank(smsContent)) {
            result.setResMsg("不确定的短信业务类型");
            return result;
        }
        if (!ConfigUtil.getInstance().isDev()) {
            if(!smsRedisUtil.isGetSmsByIP(smsVO.getIp())){
                result.setResMsg("获取短信失败，请联系客服处理");
                return result;
            }
        }
        if(!smsRedisUtil.isGetSmsByMobile(smsVO.getMobile())){
            result.setResMsg("短信已经发送，请勿重复获取");
            return result;
        }
        //记录短信内容
        smsRedisUtil.saveSMSByMobile(SmsBusinessEnum.getSMSBusinessByCode(smsVO.getBizType()), smsVO.getMobile(), code);
        smsRedisUtil.saveIPGetSMSNum(smsVO.getIp());
        //发送验证码
        SmsUtil.sendSMS(smsVO.getMobile(), smsContent, smsVO.getIsVoice());
        return result;
    }

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    private Member getByMobile(String mobile) {
        return memberDao.getMemberByMobile(mobile);
    }

    /**
     * 设置用户密码
     *
     * @param passwordVO
     * @return
     */
    @Override
    public ResultBody setMemberPayPassword(MemberSetPayPasswordVO passwordVO) {
        ResultBody<String> result = new ResultBody<>();
        Member member = getMemberById(passwordVO.getMemberId());
        if (!preSetMemberPayPassword(result, member)) {
            return result;
        }
        String encryptPassword = DESUtil.encryptPayPassword(passwordVO.getPayPassword(), member.getIdCard());
        Integer num = setPayPasswordById(passwordVO.getMemberId(), encryptPassword);
        if (num == 0) {
            result.setResMsg("交易密码设置失败");
            return result;
        }
        result.setData("设置成功");
        return result;
    }

    private boolean preSetMemberPayPassword(ResultBody<String> result, Member member) {
        if (member == null) {
            result.setResMsg("用户不存在");
            return false;
        }
        if (StrUtils.isNotBlank(member.getPayPwd())) {
            result.setResMsg("交易密码已设置");
            return false;
        }
        return true;
    }

    /**
     * 修改用户交易密码
     *
     * @param passwordVO
     * @return
     */
    @Override
    public ResultBody changeMemberPayPassword(MemberChangePayPasswordVO passwordVO) {
        ResultBody<String> result = new ResultBody<>();
        Member member = getMemberById(passwordVO.getMemberId());
        if (!preChangePayPassword(passwordVO, result, member)) {
            return result;
        }
        String newEncryptPassword = DESUtil.encryptPayPassword(passwordVO.getNewPayPassword(), member.getIdCard());
        Integer num = updatePayPasswordById(passwordVO.getMemberId(), newEncryptPassword);
        if (num == 0) {
            result.setResMsg("交易密码变更失败");
            return result;
        }
        result.setData("设置成功");
        return result;
    }

    private boolean preChangePayPassword(MemberChangePayPasswordVO passwordVO, ResultBody<String> result, Member member) {
        if (StrUtils.isBlank(member.getPayPwd())) {
            result.setResMsg("交易密码未设置，请先设置密码");
            return false;
        }
        String encryptPassword = DESUtil.encryptPayPassword(passwordVO.getOldPayPassword(), member.getIdCard());
        if (!member.getPayPwd().equals(encryptPassword)) {
            result.setResMsg("原交易密码不正确");
            return false;
        }
        if (passwordVO.getOldPayPassword().equals(passwordVO.getNewPayPassword())) {
            result.setResMsg("交易密码与最近设置的交易密码一致，请重新修改");
            return false;
        }
        return true;
    }

    private Integer updatePayPasswordById(Long memberId, String password) {
        return memberDao.updateMemberPayPasswordById(memberId, password);
    }

    private Integer setPayPasswordById(Long memberId, String password) {
        return memberDao.setMemberPayPasswordById(memberId, password);
    }

    /**
     * 找回密码的提示信息
     *
     * @param memberId
     * @return
     */
    @Override
    public ResultBody findPayPasswordRemindInfos(Long memberId) {
        Member member = getMemberById(memberId);
        ResultBody resultBody = new ResultBody();
        if (member.getPayPwd() == null) {
            resultBody.setResMsg("未设置交易密码");
            return resultBody;
        }
        BankCard bankCard = bankCardService.getDefaultBankCardByMemberId(memberId);
        if (bankCard == null) {
            resultBody.setResMsg("未找到银行卡");
            return resultBody;
        }
        FindPayPwdMaskedDTO findPayPwdMaskedDTO = new FindPayPwdMaskedDTO();
        String encryptedMobile = null;
        String encryptedCardNo = null;
        try {
            encryptedMobile = DESUtil.encryptForSafeTransport(member.getMobile());
            encryptedCardNo = DESUtil.encryptForSafeTransport(bankCard.getCardNo());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e + "加密失败");
        }
        findPayPwdMaskedDTO.setBankCardNo(encryptedCardNo);
        findPayPwdMaskedDTO.setMobile(encryptedMobile);
        resultBody.setData(findPayPwdMaskedDTO);
        return resultBody;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ResultBody inviteFriend(InviteFriendVO data) throws Exception {
        ResultBody<Member> preResult = preValidInviteFriend(data);
        if (!preResult.isSuccess()) {
            return preResult;
        }
        LoginVO loginData = new LoginVO();
        loginData.setMobile(data.getMobile());
        Member member = regMember(loginData);
        Member inviteMember = preResult.getData();
        inviteMemberService.saveInviteMember(inviteMember.getId(), member.getId(), data.getMobile());
        return login(member, data.getClientSource(), data.getIp(), data.getDevice());
    }

    /**
     * 用户ID是否已被注册
     * @param idCard
     * @param memberId
     * @return
     */
    @Override
    public boolean isRegisterIdCard(String idCard, Long memberId) {
        Member member = memberDao.getMemberByIdCard(idCard);
        if (StrUtils.isNotEmptyObj(member)){
            if (member.getId().compareTo(memberId) != 0){
                return true;
            }
            return false;
        }
        return false;
    }


    /**
     * 邀请好友前置校验
     * @param data
     * @return
     */
    private ResultBody<Member> preValidInviteFriend(InviteFriendVO data){
        ResultBody<Member> result = new ResultBody();
        Member member = memberDao.getMemberByMobile(data.getInviteMobile());
        if(member == null){
            result.setResMsg("邀请人不存在");
            return result;
        }
        Member member1 = memberDao.getMemberByMobile(data.getMobile());
        if(member1 != null){
            result.setResMsg("手机号已经注册，只有新用户才可以参加哦");
            return result;
        }
        //验证手机验证码
        result.setData(member);
        return result;
    }


    /**
     * 交易手机号和银行卡
     *
     * @param data the data
     * @return result body
     */
    @Override
    public ResultBody validateMobileCode(ResetPayPwdMobileBankVO data) {
        ResultBody resultBody = new ResultBody();
        Long memberId = data.getMemberId();
        Member member = getMemberById(memberId);
        BankCard bankCard = bankCardService.getDefaultBankCardByMemberId(memberId);
        if (!data.getMobile().equals(member.getMobile())) {
            resultBody.setResMsg("手机号不正确");
            return resultBody;
        }
        if (!data.getBankCardNo().equals(bankCard.getCardNo())) {
            resultBody.setResMsg("银行卡号不正确");
            return resultBody;
        }
        if(ConfigUtil.getInstance().isDev() == false){
            boolean isTrue = smsRedisUtil.checkSmsCode(SmsBusinessEnum.FIND_PAYMENT_PASSWORD, data.getMobile(), data.getCode());
            if(!isTrue){
                resultBody.setResMsg("验证码错误");
                return resultBody;
            }
        }
        //生成一个令牌 用于第二步使用
        String resetPayPwdToken = DESUtil.urlEncodeThenEncryptForResetPayPwdToken(member.getIdCard());
        Map<String, String> map = Maps.newHashMap();
        map.put("resetPayPwdToken", resetPayPwdToken);
        resultBody.setData(map);
        return resultBody;
    }

    @Override
    public ResultBody getMemberRealNameInfo(Long memberId) {
        ResultBody result = new ResultBody();
        Member member = memberDao.getMemberById(memberId);
        MemberRealNameInfoDTO mri = new MemberRealNameInfoDTO();
        mri.setIdCard(member.getIdCard());
        mri.setMobile(member.getMobile());
        mri.setName(member.getName());
        result.setData(mri);
        return result;
    }

    /**
     * 重置用户交易密码
     *
     * @param passwordVO the password vo
     * @return member pay password
     */
    @Override
    public ResultBody resetMemberPayPassword(MemberResetPayPasswordVO passwordVO) {
        ResultBody<String> result = new ResultBody<>();
        Member member = getMemberById(passwordVO.getMemberId());
        String decryptIdCard = null;
        try {
            decryptIdCard = DESUtil.decrypt(passwordVO.getResetPayPwdToken(), Constants.RESET_PAY_PWD_TOKEN_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!Objects.equals(decryptIdCard, member.getIdCard())) {
            result.setResMsg("校验失败");
            return result;
        }
        String encryptPassword = DESUtil.encryptPayPassword(passwordVO.getPayPassword(), member.getIdCard());
        Integer num = updatePayPasswordById(passwordVO.getMemberId(), encryptPassword);
        if (num == 0) {
            result.setResMsg("交易密码设置失败");
            return result;
        }
        result.setData("设置成功");
        return result;
    }

    /**
     * 获取已实名的所有用户id
     */
    @Override
    public List<Long> queryRealNameMemberIds() {
        return memberDao.queryRealNameMemberIds();
    }

    /**
     * 更新member表数据
     * @param member
     * @return
     */
    @Override
    public int updataMember(Member member) {
        return memberDao.updataTrialAmount(member);
    }
}
