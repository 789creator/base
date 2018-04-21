package com.base.api.server.controller;

import com.base.api.common.domain.ResultBody;
import com.base.api.common.web.controller.BaseController;
import com.base.api.dao.vo.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * 登录注册
 * @author z
 */
@RestController
public class LoginController  extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger (LoginController.class);


    @Resource
    private MemberService memberService;



    /**
     * 用户注册登录
     *
     * @param data
     * @param bindingResult
     * @param req
     * @return
     */
    @RequestMapping("/login")
    public ResultBody login(@Valid LoginVO data, BindingResult bindingResult, HttpServletRequest req) throws Exception {
        ResultBody result = new ResultBody();
        validateResult (result, bindingResult);
        if (!result.isSuccess ()) {
            return result;
        }
        data.setDevice (getRequestDevice (req));
        data.setDeviceId (getRequestDeviceId (req));
        data.setIp (getRequestClientIP (req));
        data.setPushId (getRequestPushId (req));
        data.setClientSource (getRequestClientSource (req));
        data.setChannelSource (getRequestChannelSource (req));
        return memberService.login (data);
    }

    /**
     * 获取验证码
     *
     * @param data
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/getSMS", method = RequestMethod.POST)
    public ResultBody getSMS(@Valid SmsVO data, BindingResult bindingResult, HttpServletRequest req) {
        ResultBody result = new ResultBody ();
        validateResult (result, bindingResult);
        if (!result.isSuccess ()) {
            return result;
        }
        data.setIp (getRequestClientIP (req));
        result = memberService.sendSmsByBizType (data);
        return result;
    }

    /**
     * 首页
     *
     * @param req
     * @return
     */
    @RequestMapping("/pcIndex")
    @TokenAnnotation
    public ResultBody index(HttpServletRequest req) {
        ResultBody<PcIndexDTO> resultBody = new ResultBody<> ();
        PcIndexDTO pcIndexDTO = indexPageService.getPcIndexPage (getMemberId (req));
        resultBody.setData (pcIndexDTO);
        return resultBody;
    }

    /**
     * 首页
     *
     * @param request
     * @return
     */
    @RequestMapping("/index")
    @TokenAnnotation
    public ResultBody pcIndex(HttpServletRequest request) {
        ResultBody<IndexDTO> resultBody = new ResultBody<> ();
        IndexDTO indexDTO = indexPageService.getIndexPage (getMemberId (request));
        resultBody.setData (indexDTO);
        return resultBody;
    }

    /**
     * 公告
     *
     * @param req
     * @return
     */
    @RequestMapping("/notice")
    @TokenAnnotation
    public ResultBody notice(HttpServletRequest req) {
        ResultBody resultBody = new ResultBody<> ();
        IndexDTO indexDTO = indexPageService.getNotice ();
        List<NoticeDTO> noticeDTO = noticeService.getIndexNoticeList (10);
        resultBody.setData (noticeDTO);
        return resultBody;
    }

    /**
     * 活动首页
     *
     * @param req
     * @return
     */
    @RequestMapping("/activity")
    @TokenAnnotation
    public ResultBody activity(HttpServletRequest req) {
        ResultBody result = new ResultBody ();
        int pageNo = ServletRequestUtils.getIntParameter (req, "pageNo", 1);
        List<ActivityDTO> activityList = activityService.getActivityList (getMemberId (req), pageNo);
        result.setData (activityList);
        return result;
    }

    /**
     * 资产首页
     *
     * @param req
     * @return 
     <pre>
     {
        "action": "",
        "data": {
            "amount": 398973.54,
            "capitalTips": "01月15日还款14,115.03元",
            "couponIsExpired": false,
            "couponTips": "7,538元红包可用",
            "helpCenterTips": "常见问题都在这里",
            "investTips": "待收本息748,924.43元",
            "inviteFriendTips": "拿2%返现奖励",
            "personalConfigTips": "绑卡、设置密码",
            "plusTips": "加息让收益更可观",
            "riskTestTips": "",
            "rtfTenderAmount": 0, //融托富在投金额
            "rtfTotalAmount": 0,  //融托富总金额
            "rtfUsableAmount": 0,   //融托富可用余额
            "totalAmount": 1147897.97,
            "totalIncome": 24288.31,
            "trialAmount": "888611.00元可用"
        },
        "resCode": 1,
        "resMsg": ""
     }
     </pre>
     */
    @RequestMapping("/home")
    @TokenAnnotation
    public ResultBody home(HttpServletRequest req) {
        return memberService.getMemberHome (getMemberId (req));
    }


    /**
     * 保存风险偏好
     *
     * @param req
     * @return
     */
    @RequestMapping("/saveRiskAssessment")
    @TokenAnnotation
    public ResultBody saveRiskAssessment(HttpServletRequest req) {
        int riskType = ServletRequestUtils.getIntParameter (req, "riskType", 0);
        return riskAssessmentService.saveOrUpdateRiskAssessmentByMemberId (getMemberId (req), riskType);
    }

    /**
     * 根据订单号获取合同数据
     *
     * @param req
     * @return
     */
    @RequestMapping("/getContractInfoByOrderNo")
    @TokenAnnotation
    public ResultBody getContractInfoByOrderNo(HttpServletRequest req) {
        String orderNo = ServletRequestUtils.getStringParameter (req, "orderNo", null);
        return projectContractBorrowerService.getBorrowerInfoByOrderNo (orderNo, getMemberId (req));
    }

    /**
     * 支持的银行卡列表
     *
     * @param req
     * @return
     */
    @RequestMapping("/getBankList")
    public ResultBody getBankList(HttpServletRequest req) {
        return bankService.getAllBankList ();
    }


    /**
     * 退出登录
     *
     * @param req
     * @return
     */
    @RequestMapping("/logout")
    @MemberAuthAnnotation
    public ResultBody logout(HttpServletRequest req) {
        return memberService.logout (getMemberId (req), getRequestClientSource (req).getValue ());
    }


    @RequestMapping("/notice/list")
    public ResultBody getNoticeList(HttpServletRequest request) {
        ResultBody resultBody = new ResultBody ();
        Integer pageNo = ServletRequestUtils.getIntParameter (request, "pageNo", 1);
        List<NoticeDTO> notices = noticeService.getNoticeListWithPage (pageNo);
        resultBody.setData (notices);
        return resultBody;
    }


    /**
     * 邀请好友
     *
     * @param req
     * @return
     */
    @RequestMapping("/inviteFriend")
    public ResultBody inviteFriend(@Valid InviteFriendVO data, BindingResult bindingResult, HttpServletRequest req) throws Exception {
        ResultBody result = new ResultBody ();
        validateResult (result, bindingResult);
        if (!result.isSuccess ()) {
            return result;
        }
        data.setClientSource (getRequestClientSource (req));
        data.setIp (getRequestClientIP (req));
        return memberService.inviteFriend (data);
    }

    /**
     * 配置中心
     *
     * @param req
     * @return
     */
    @RequestMapping("/config")
    public ResultBody config(HttpServletRequest req) {
        return configService.config ();
    }

    /**
     * reload配置
     *
     * @param req
     * @return
     */
    @RequestMapping("/reloadConfig")
    public ResultBody reloadConfig(HttpServletRequest req) {
        ResultBody ret = new ResultBody();
        String reload = ServletRequestUtils.getStringParameter (req, "reload", "false");
        HashMap map = configService.relaodConfig("true".equals(reload));
//        ret.setData(map);
        System.out.println("reloadConfig:" + ConfigUtil.confString());
        return ret;
    }
    /**
     * 显示配置
     *
     * @param req
     * @return
     */
    @RequestMapping("/showConfig")
    public ResultBody showConfig(HttpServletRequest req) {
        ResultBody ret = new ResultBody();
        //ret.setData(ConfigUtil.getMap());
        System.out.println("showConfig:" + ConfigUtil.confString());
        return ret;
    }
    /**
     * 设备激活
     *
     * @param req
     * @return
     */
    @RequestMapping("/regDevice")
    public ResultBody regDevice(HttpServletRequest req) {
        return new ResultBody ();
    }


    /**
     * 宝付支付回调接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/BFReturnRecharge")
    public String BFReturnRecharge(HttpServletRequest request) {

        return tradeService.BFReturnRecharge (request);
    }

}
