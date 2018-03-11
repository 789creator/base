package com.base.api.common.rtf.client;

import com.base.api.common.rtf.bean.*;
import com.base.api.common.rtf.config.RtfConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 融托富 接口
 *
 * @author zhj
 * @date 2017/12/11
 */
@Component
public class RtfApiClient {

    /**
     * 个人一键签约
     *
     * @param immediateSignRequest 请求实体封装类
     * @param requestMethod        请求方法
     * @return
     */
    public ImmediateSignResponse immediateSign(ImmediateSignRequest immediateSignRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("immediateSignUrl", immediateSignRequest);
        immediateSignRequest.setService ("reapal.trust.onekeyContract");
        ImmediateSignResponse immediateSignResponse = new ImmediateSignResponse ();
        return RtfHttpClientUtil.execute (url, immediateSignRequest, immediateSignResponse, requestMethod);
    }

    /**
     * 企业一键签约
     *
     * @param companyImmediateSignRequest
     * @param requestMethod
     * @return
     */
    public CompanyImmediateSignResponse companyImmediateSign(CompanyImmediateSignRequest companyImmediateSignRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("companyImmediateSignUrl", companyImmediateSignRequest);
        companyImmediateSignRequest.setService ("reapal.trust.comContractAPI");
        CompanyImmediateSignResponse response = new CompanyImmediateSignResponse ();
        return RtfHttpClientUtil.execute (url, companyImmediateSignRequest, response, requestMethod);
    }

    /**
     * 个人签约查询
     *
     * @param signQueryRequest
     * @param requestMethod
     * @return
     */
    public SignQueryResponse signQuery(SignQueryRequest signQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("signQueryUrl", signQueryRequest);
        signQueryRequest.setService ("reapal.trust.contractQuery");
        SignQueryResponse response = new SignQueryResponse ();
        return RtfHttpClientUtil.execute (url, signQueryRequest, response, requestMethod);
    }

    /**
     * 企业签约查询
     *
     * @param companySignQueryRequest
     * @param requestMethod
     * @return
     */
    public CompanySignQueryResponse companySignQuery(CompanySignQueryRequest companySignQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("signQueryUrl", companySignQueryRequest);
        companySignQueryRequest.setService ("reapal.trust.contractQuery");
        CompanySignQueryResponse response = new CompanySignQueryResponse ();
        return RtfHttpClientUtil.execute (url, companySignQueryRequest, response, requestMethod);
    }

    /**
     * 余额查询
     *
     * @param balanceQueryRequest
     * @param requestMethod
     * @return
     */
    public BalanceQueryResponse balanceQuery(BalanceQueryRequest balanceQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("signQueryUrl", balanceQueryRequest);
        balanceQueryRequest.setService ("reapal.trust.balanceQuery");
        BalanceQueryResponse response = new BalanceQueryResponse ();
        return RtfHttpClientUtil.execute (url, balanceQueryRequest, response, requestMethod);
    }

    /**
     * 签约手机号修改（短信）
     *
     * @param mobileModifyRequest
     * @param requestMethod
     * @return
     */
    public MobileModifyResponse mobileModify(MobileModifyRequest mobileModifyRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("mobileModifyUrl", mobileModifyRequest);
        mobileModifyRequest.setService ("reapal.trust.mobileModifyApplyAPI");
        MobileModifyResponse response = new MobileModifyResponse ();
        return RtfHttpClientUtil.execute (url, mobileModifyRequest, response, requestMethod);
    }

    /**
     * 签约手机号修改（确认）
     *
     * @param mobileModifyConfirmRequest
     * @param requestMethod
     * @return
     */
    public MobileModifyConfirmResponse mobileModifyConfirm(MobileModifyConfirmRequest mobileModifyConfirmRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("mobileModifyConfirmUrl", mobileModifyConfirmRequest);
        mobileModifyConfirmRequest.setService ("reapal.trust.mobileModifyConfirmAPI");
        MobileModifyConfirmResponse response = new MobileModifyConfirmResponse ();
        return RtfHttpClientUtil.execute (url, mobileModifyConfirmRequest, response, requestMethod);
    }

    /**
     * 签约手机号修改（重发短信）
     *
     * @param mobileModifyRepeatRequest
     * @param requestMethod
     * @return
     */
    public MobileModifyRepeatResponse mobileModifyRepeat(MobileModifyRepeatRequest mobileModifyRepeatRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("mobileModifyRepeatUrl", mobileModifyRepeatRequest);
        mobileModifyRepeatRequest.setService ("reapal.trust.mobileModifyRepeatAPI");
        MobileModifyRepeatResponse response = new MobileModifyRepeatResponse ();
        return RtfHttpClientUtil.execute (url, mobileModifyRepeatRequest, response, requestMethod);
    }

    /**
     * 手机号查询
     *
     * @param mobileQueryRequest
     * @param requestMethod
     * @return
     */
    public MobileQueryResponse mobileQuery(MobileQueryRequest mobileQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("mobileQueryUrl", mobileQueryRequest);
        mobileQueryRequest.setService ("reapal.trust.mobileQuery");
        MobileQueryResponse response = new MobileQueryResponse ();
        return RtfHttpClientUtil.execute (url, mobileQueryRequest, response, requestMethod);
    }

    /**
     * 快捷充值签约
     *
     * @param quickRechargeRequest
     * @param requestMethod
     * @return
     */
    public QuickRechargeResponse quickRecharge(QuickRechargeRequest quickRechargeRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("quickRechargeUrl", quickRechargeRequest);
        quickRechargeRequest.setService ("reapal.trust.depositApplyAPI");
        quickRechargeRequest.setVersion ("2.0");
        QuickRechargeResponse response = new QuickRechargeResponse ();
        return RtfHttpClientUtil.execute (url, quickRechargeRequest, response, requestMethod);
    }

    /**
     * 快捷充值确认
     *
     * @param quickRechargeConfirmRequest
     * @param requestMethod
     * @return
     */
    public QuickRechargeConfirmResponse quickRechargeConfirm(QuickRechargeConfirmRequest quickRechargeConfirmRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("quickRechargeConfirmUrl", quickRechargeConfirmRequest);
        quickRechargeConfirmRequest.setService ("reapal.trust.depositConfirmAPI");
        QuickRechargeConfirmResponse response = new QuickRechargeConfirmResponse ();
        return RtfHttpClientUtil.execute (url, quickRechargeConfirmRequest, response, requestMethod);
    }

    /**
     * 快捷充值重发短信
     *
     * @param quickRechargeSmsRequest
     * @param requestMethod
     * @return
     */
    public QuickRechargeSmsResponse quickRechargeSms(QuickRechargeSmsRequest quickRechargeSmsRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("quickRechargeSmsUrl", quickRechargeSmsRequest);
        quickRechargeSmsRequest.setService ("reapal.trust.depositSmsAPI");
        QuickRechargeSmsResponse response = new QuickRechargeSmsResponse ();
        return RtfHttpClientUtil.execute (url, quickRechargeSmsRequest, response, requestMethod);
    }

    /**
     * 充值查询
     *
     * @param rechargeQueryRequest
     * @param requestMethod
     * @return
     */
    public RechargeQueryResponse rechargeQuery(RechargeQueryRequest rechargeQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("rechargeQueryUrl", rechargeQueryRequest);
        rechargeQueryRequest.setService ("reapal.trust.depositQuery");
        RechargeQueryResponse response = new RechargeQueryResponse ();
        return RtfHttpClientUtil.execute (url, rechargeQueryRequest, response, requestMethod);
    }

    /**
     * 银行卡绑定
     *
     * @param bankCardAddRequest
     * @param requestMethod
     * @return
     */
    public BankCardAddResponse bankCardAdd(BankCardAddRequest bankCardAddRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("bankCardAddUrl", bankCardAddRequest);
        bankCardAddRequest.setService ("reapal.trust.bankCardAdd");
        BankCardAddResponse response = new BankCardAddResponse ();
        return RtfHttpClientUtil.execute (url, bankCardAddRequest, response, requestMethod);
    }

    /**
     * 撤销绑卡
     *
     * @param undoBindBankCardRequest
     * @param requestMethod
     * @return
     */
    public UndoBindBankCardResponse undoBindBankCard(UndoBindBankCardRequest undoBindBankCardRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("undoBindBankCardUrl", undoBindBankCardRequest);
        undoBindBankCardRequest.setService ("reapal.trust.undoBindBankCard");
        UndoBindBankCardResponse response = new UndoBindBankCardResponse ();
        return RtfHttpClientUtil.execute (url, undoBindBankCardRequest, response, requestMethod);
    }

    /**
     * 修改绑定
     *
     * @param modifyBindBankCardRequest
     * @param requestMethod
     * @return
     */
    public ModifyBindBankCardResponse modifyBindBankCard(ModifyBindBankCardRequest modifyBindBankCardRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("modifyBindBankCardUrl", modifyBindBankCardRequest);
        modifyBindBankCardRequest.setService ("reapal.trust.modifyBindBankCard");
        ModifyBindBankCardResponse response = new ModifyBindBankCardResponse ();
        return RtfHttpClientUtil.execute (url, modifyBindBankCardRequest, response, requestMethod);
    }

    /**
     * 提现查询
     *
     * @param withdrawQueryRequest
     * @param requestMethod
     * @return
     */
    public WithdrawQueryResponse withdrawQuery(WithdrawQueryRequest withdrawQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("withdrawQueryUrl", withdrawQueryRequest);
        withdrawQueryRequest.setService ("reapal.trust.withdrawQuery");
        WithdrawQueryResponse response = new WithdrawQueryResponse ();
        return RtfHttpClientUtil.execute (url, withdrawQueryRequest, response, requestMethod);
    }

    /**
     * 绑卡查询
     *
     * @param bindCardQueryRequest
     * @param requestMethod
     * @return
     */
    public BindCardQueryResponse bindCardQuery(BindCardQueryRequest bindCardQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("bindCardQueryUrl", bindCardQueryRequest);
        bindCardQueryRequest.setService ("reapal.trust.bindQuery");
        BindCardQueryResponse response = new BindCardQueryResponse ();
        return RtfHttpClientUtil.execute (url, bindCardQueryRequest, response, requestMethod);
    }

    /**
     * 自动提现
     *
     * @param autoWithdrawRequest
     * @param requestMethod
     * @return
     */
    public AutoWithdrawResponse autoWithdraw(AutoWithdrawRequest autoWithdrawRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("autoWithdrawUrl", autoWithdrawRequest);
        autoWithdrawRequest.setService ("reapal.trust.autoWithdraw");
        AutoWithdrawResponse response = new AutoWithdrawResponse ();
        return RtfHttpClientUtil.execute (url, autoWithdrawRequest, response, requestMethod);
    }

    /**
     * 企业分账
     *
     * @param subAccountRequest
     * @param requestMethod
     * @return
     */
    public SubAccountResponse subAccount(SubAccountRequest subAccountRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("subAccountUrl", subAccountRequest);
        subAccountRequest.setService ("reapal.trust.subAccount");
        SubAccountResponse response = new SubAccountResponse ();
        return RtfHttpClientUtil.execute (url, subAccountRequest, response, requestMethod);
    }

    /**
     * 发标
     *
     * @param tenderApplyRequest
     * @param requestMethod
     * @return
     */
    public TenderApplyResponse tenderApply(TenderApplyRequest tenderApplyRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("tenderApplyUrl", tenderApplyRequest);
        tenderApplyRequest.setService ("reapal.trust.tenderApply");
        TenderApplyResponse response = new TenderApplyResponse ();
        return RtfHttpClientUtil.execute (url, tenderApplyRequest, response, requestMethod);
    }

    /**
     * 一键投标（短信）
     *
     * @param oneKeyInvestSmsRequest
     * @param requestMethod
     * @return
     */
    public OneKeyInvestSmsResponse oneKeyInvestSms(OneKeyInvestSmsRequest oneKeyInvestSmsRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyInvestSmsUrl", oneKeyInvestSmsRequest);
        oneKeyInvestSmsRequest.setService ("reapal.trust.onekeyInvestSMS");
        OneKeyInvestSmsResponse response = new OneKeyInvestSmsResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyInvestSmsRequest, response, requestMethod);
    }

    /**
     * 一键投标（确认）
     *
     * @param oneKeyInvestConfirmRequest
     * @param requestMethod
     * @return
     */
    public OneKeyInvestConfirmResponse oneKeyInvestConfirm(OneKeyInvestConfirmRequest oneKeyInvestConfirmRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyInvestConfirmUrl", oneKeyInvestConfirmRequest);
        oneKeyInvestConfirmRequest.setService ("reapal.trust.onekeyInvestConfirm");
        OneKeyInvestConfirmResponse response = new OneKeyInvestConfirmResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyInvestConfirmRequest, response, requestMethod);
    }

    /**
     * 一键投标（重发短信）
     *
     * @param oneKeyInvestSmsAgainRequest
     * @param requestMethod
     * @return
     */
    public OneKeyInvestSmsAgainResponse oneKeyInvestSmsAgain(OneKeyInvestSmsAgainRequest oneKeyInvestSmsAgainRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyInvestSmsAgainUrl", oneKeyInvestSmsAgainRequest);
        oneKeyInvestSmsAgainRequest.setService ("reapal.trust.onekeyInvestSmsAPIAgain");
        OneKeyInvestSmsAgainResponse response = new OneKeyInvestSmsAgainResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyInvestSmsAgainRequest, response, requestMethod);
    }

    /**
     * 一键投标（免密）
     *
     * @param oneKeyInvestRequest
     * @param requestMethod
     * @return
     */
    public OneKeyInvestResponse oneKeyInvest(OneKeyInvestRequest oneKeyInvestRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyInvestUrl", oneKeyInvestRequest);
        oneKeyInvestRequest.setService ("reapal.trust.onekeyInvest");
        OneKeyInvestResponse response = new OneKeyInvestResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyInvestRequest, response, requestMethod);
    }

    /**
     * 单笔投标撤销
     *
     * @param investCancelRequest
     * @param requestMethod
     * @return
     */
    public InvestCancelResponse investCancel(InvestCancelRequest investCancelRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("investCancelUrl", investCancelRequest);
        investCancelRequest.setService ("reapal.trust.tenderAllCancel");
        InvestCancelResponse response = new InvestCancelResponse ();
        return RtfHttpClientUtil.execute (url, investCancelRequest, response, requestMethod);
    }

    /**
     * 满标
     *
     * @param investFinishRequest
     * @param requestMethod
     * @return
     */
    public InvestFinishResponse investFinish(InvestFinishRequest investFinishRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("investFinishUrl", investFinishRequest);
        investFinishRequest.setService ("reapal.trust.tenderFinish");
        InvestFinishResponse response = new InvestFinishResponse ();
        return RtfHttpClientUtil.execute (url, investFinishRequest, response, requestMethod);
    }

    /**
     * 一键还款（短信）
     *
     * @param oneKeyRepaymentSmsRequest
     * @param requestMethod
     * @return
     */
    public OneKeyRepaymentSmsResponse oneKeyRepaymentSms(OneKeyRepaymentSmsRequest oneKeyRepaymentSmsRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyRepaymentSmsUrl", oneKeyRepaymentSmsRequest);
        oneKeyRepaymentSmsRequest.setService ("reapal.trust.onekeyRefundSMS");
        OneKeyRepaymentSmsResponse response = new OneKeyRepaymentSmsResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyRepaymentSmsRequest, response, requestMethod);
    }

    /**
     * 一键还款（确认）
     *
     * @param oneKeyRepaymentConfirmRequest
     * @param requestMethod
     * @return
     */
    public OneKeyRepaymentConfirmResponse oneKeyRepaymentConfirm(OneKeyRepaymentConfirmRequest oneKeyRepaymentConfirmRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyRepaymentConfirmUrl", oneKeyRepaymentConfirmRequest);
        oneKeyRepaymentConfirmRequest.setService ("reapal.trust.onekeyRefundConfirm");
        OneKeyRepaymentConfirmResponse response = new OneKeyRepaymentConfirmResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyRepaymentConfirmRequest, response, requestMethod);
    }

    /**
     * 一键还款（重复短信）
     *
     * @param oneKeyRepaymentSmsAgainRequest
     * @param requestMethod
     * @return
     */
    public OneKeyRepaymentSmsAgainResponse oneKeyRepaymentSmsAgain(OneKeyRepaymentSmsAgainRequest oneKeyRepaymentSmsAgainRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyRepaymentSmsAgainUrl", oneKeyRepaymentSmsAgainRequest);
        oneKeyRepaymentSmsAgainRequest.setService ("reapal.trust.onekeyRefundSMSAPIAgain");
        OneKeyRepaymentSmsAgainResponse response = new OneKeyRepaymentSmsAgainResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyRepaymentSmsAgainRequest, response, requestMethod);
    }

    /**
     * 一键还款（免密）
     *
     * @param oneKeyRepaymentRequest
     * @param requestMethod
     * @return
     */
    public OneKeyRepaymentResponse oneKeyRepayment(OneKeyRepaymentRequest oneKeyRepaymentRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeyRepaymentUrl", oneKeyRepaymentRequest);
        oneKeyRepaymentRequest.setService ("reapal.trust.onekeyRefund");
        OneKeyRepaymentResponse response = new OneKeyRepaymentResponse ();
        return RtfHttpClientUtil.execute (url, oneKeyRepaymentRequest, response, requestMethod);
    }

    /**
     * 流水号查询
     * <p>
     * 调用方法时给sevice设值:
     * 【reapal.trust.tenderFinishSQuery 满标查询】
     * 【reapal.trust.tenderRefundSQuery 还款查询】
     * 【reapal.trust.tenderTransferSQuery 债权转让查询】
     *
     * @param investSnQueryRequest
     * @param requestMethod
     * @return
     */
    public InvestSnQueryResponse investSnQuery(InvestSnQueryRequest investSnQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("investSnQueryUrl", investSnQueryRequest);
        InvestSnQueryResponse response = new InvestSnQueryResponse ();
        return RtfHttpClientUtil.execute (url, investSnQueryRequest, response, requestMethod);
    }

    /**
     * 订单号查询(单笔)
     * <p>
     * 调用方法时给sevice设值:
     * 【reapal.trust.tenderApplySQuery发标单笔查询】
     * 【reapal.trust.tenderInvestSQuery投标单笔查询】
     *
     * @param orderSnQueryRequest
     * @param requestMethod
     * @return
     */
    public OrderSnQueryResponse orderSnQuery(OrderSnQueryRequest orderSnQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("orderSnQueryUrl", orderSnQueryRequest);
        OrderSnQueryResponse response = new OrderSnQueryResponse ();
        return RtfHttpClientUtil.execute (url, orderSnQueryRequest, response, requestMethod);
    }

    /**
     * 订单号查询(批量)
     * <p>
     * 调用方法时给sevice设值:
     * 【reapal.trust.tenderCancelMQuery  投标撤消查询】
     * 【reapal.trust.tenderFinishMQuery     满标查询】
     * 【reapal.trust.tenderRefundMQuery     还款查询】
     * 【reapal.trust.tenderTransferMQuery 债权转让查询】
     *
     * @param orderSnBatchQueryRequest
     * @param requestMethod
     * @return
     */
    public OrderSnBatchQueryResponse orderSnBatchQuery(OrderSnBatchQueryRequest orderSnBatchQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("orderSnBatchQueryUrl", orderSnBatchQueryRequest);
        OrderSnBatchQueryResponse response = new OrderSnBatchQueryResponse ();
        return RtfHttpClientUtil.execute (url, orderSnBatchQueryRequest, response, requestMethod);
    }

    /**
     * 企业分账查询
     *
     * @param subAccountQueryRequest
     * @param requestMethod
     * @return
     */
    public SubAccountQueryResponse subAccountQuery(SubAccountQueryRequest subAccountQueryRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("subAccountQueryUrl", subAccountQueryRequest);
        subAccountQueryRequest.setService ("reapal.trust.subAccountQuery");
        SubAccountQueryResponse response = new SubAccountQueryResponse ();
        return RtfHttpClientUtil.execute (url, subAccountQueryRequest, response, requestMethod);
    }

    /**
     * 一键转让（短信）
     *
     * @param oneKeySignleTransferSmsRequest
     * @param requestMethod
     * @return
     */
    public OneKeySignleTransferSmsResponse oneKeySignleTransferSms(OneKeySignleTransferSmsRequest oneKeySignleTransferSmsRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeySignleTransferSmsUrl", oneKeySignleTransferSmsRequest);
        oneKeySignleTransferSmsRequest.setService ("reapal.trust.onekeySignleTransferSMS");
        OneKeySignleTransferSmsResponse response = new OneKeySignleTransferSmsResponse ();
        return RtfHttpClientUtil.execute (url, oneKeySignleTransferSmsRequest, response, requestMethod);
    }

    /**
     * 一键转让（确认）
     *
     * @param oneKeySignleTransferConfirmRequest
     * @param requestMethod
     * @return
     */
    public OneKeySignleTransferConfirmResponse oneKeySignleTransferConfirm(OneKeySignleTransferConfirmRequest oneKeySignleTransferConfirmRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeySignleTransferConfirmUrl", oneKeySignleTransferConfirmRequest);
        oneKeySignleTransferConfirmRequest.setService ("reapal.trust.onekeySignleTransferConfirm");
        OneKeySignleTransferConfirmResponse response = new OneKeySignleTransferConfirmResponse ();
        return RtfHttpClientUtil.execute (url, oneKeySignleTransferConfirmRequest, response, requestMethod);
    }

    /**
     * 一键转让（重发短信）
     *
     * @param oneKeySignleTransferSmsAgainRequest
     * @param requestMethod
     * @return
     */
    public OneKeySignleTransferSmsAgainResponse oneKeySignleTransferSmsAgain(OneKeySignleTransferSmsAgainRequest oneKeySignleTransferSmsAgainRequest, RequestMethod requestMethod) {
        String url = RtfConfig.getRequestUrl ("oneKeySignleTransferSmsAgainUrl", oneKeySignleTransferSmsAgainRequest);
        oneKeySignleTransferSmsAgainRequest.setService ("reapal.trust.onekeySignleTransferSmsAgain");
        OneKeySignleTransferSmsAgainResponse response = new OneKeySignleTransferSmsAgainResponse ();
        return RtfHttpClientUtil.execute (url, oneKeySignleTransferSmsAgainRequest, response, requestMethod);
    }
}
