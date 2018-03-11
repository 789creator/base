package com.base.api.common.rtf.bean;

import java.util.List;

/**
 * 满标 请求
 *
 * @author zhj
 * @date 2017/12/12
 */
public class InvestFinishRequest extends RtfBaseRequest {

    /**
     * 满标订单号
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
     * {
     * "serialNo": "TFI201503127781",
     * "payeeContracts": "R100000000006904",
     * "amount": "10",
     * "remark": "借款方向平台方缴纳10元手续费"
     * }
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
