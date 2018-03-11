package com.base.api.common.rtf.bean;

import java.util.List;

/**
 * 一键还款（短信） 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class OneKeyRepaymentSmsRequest extends RtfBaseRequest {

    /**
     * 还款订单号
     */
    private String orderNo;
    /**
     * 标的号
     */
    private String tenderNo;
    /**
     * 借款方协议号
     */
    private String debitContracts;
    /**
     * 借款方分账(分账明细格式:JSON数组（单笔订单不要超过100笔分账）)
     * [
     * {"serialNo":"TRD20161129031434962127400000","payeeContracts":"R100000000007744","amount":"100","remark":"平台手续费"},
     * {"serialNo":"TRD20161129031434962127400001","payeeContracts":"RB140728DNVC5N0Q","amount":"1000","remark":"还款"}
     * ]
     */
    private List<RtfDebitDetailVO> debitDetails;
    /**
     * 投资方分账(分账明细格式:JSON数组（单笔订单不要超过100笔分账）)
     * [
     * {
     * "serialNo": "TFI201503127633",
     * "investContracts": "RB141201K76OUYXG",
     * "payeeContracts": "RB150303PRQZPCYI",
     * "amount": "1000",
     * "remark": "A投标1000"
     * }，{
     * "serialNo": "TFI201503127634",
     * "investContracts": "RB141201K76LKMG",
     * "payeeContracts": "RB150303PRQZPCYI",
     * "amount": "2000",
     * "remark": "B投标2000"
     * }
     * ],
     */
    private List<RtfInvestDetailVO> investDetails;
    /**
     * 担保方分账
     * [
     * {"serialNo":"TRd20161129-_456400000","payerContracts":"RB160725P4F6RJFN","amount":"100","remark":"担保方垫付"},
     * {"serialNo":"TRd20161129-_456400001","payerContracts":"RB140728DNVC5N01","amount":"1000","remark":"担保方垫付"}
     * ]
     */
    private List<RtfDefrayDetailVO> defrayDetails;
    /**
     * 设备通道
     */
    private String busway;
    /**
     * 备注
     */
    private String remark;
    /**
     * 申请时间（商户业务处理时间、格式为YYYY-MM-DD HH:mm:ss）
     */
    private String applyTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTenderNo() {
        return tenderNo;
    }

    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    public String getDebitContracts() {
        return debitContracts;
    }

    public void setDebitContracts(String debitContracts) {
        this.debitContracts = debitContracts;
    }

    public List<RtfDebitDetailVO> getDebitDetails() {
        return debitDetails;
    }

    public void setDebitDetails(List<RtfDebitDetailVO> debitDetails) {
        this.debitDetails = debitDetails;
    }

    public List<RtfInvestDetailVO> getInvestDetails() {
        return investDetails;
    }

    public void setInvestDetails(List<RtfInvestDetailVO> investDetails) {
        this.investDetails = investDetails;
    }

    public List<RtfDefrayDetailVO> getDefrayDetails() {
        return defrayDetails;
    }

    public void setDefrayDetails(List<RtfDefrayDetailVO> defrayDetails) {
        this.defrayDetails = defrayDetails;
    }

    public String getBusway() {
        return busway;
    }

    public void setBusway(String busway) {
        this.busway = busway;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
