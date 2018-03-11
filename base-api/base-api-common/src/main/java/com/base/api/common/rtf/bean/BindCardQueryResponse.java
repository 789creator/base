package com.base.api.common.rtf.bean;

/**
 * 绑卡查询 响应
 *
 * @author zhj
 * @date 2017/12/12
 */
public class BindCardQueryResponse extends RtfBaseResponse {

    /**
     * 用户协议号
     */
    private String contracts;
    /**
     * 银行卡信息
     * 充值或提现银行卡信息
     * ｛bankName|bankCode|bankCard|type|isSafety|IsRequiredField|accountProvince|accountCity|branch|subbranch｝
     * 对应：
     * ｛银行名称|银行代码|银行卡后四位|业务类型A：充值和提现；D：充值；W：提现|绑卡类别0:普通卡；1安全卡|分支行信息0：省市分支行信息为系统默认信息；1：用户自己所填信息|开户行所在省|开户行所在市|开户行分行|开户行支行｝
     */
    private String bankCards;
    /**
     * 处理时间
     */
    private String processTime;

    public String getContracts() {
        return contracts;
    }

    public void setContracts(String contracts) {
        this.contracts = contracts;
    }

    public String getBankCards() {
        return bankCards;
    }

    public void setBankCards(String bankCards) {
        this.bankCards = bankCards;
    }

    public String getProcessTime() {
        return processTime;
    }

    public void setProcessTime(String processTime) {
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "BindCardQueryResponse{" +
                "contracts='" + contracts + '\'' +
                ", bankCards='" + bankCards + '\'' +
                ", processTime='" + processTime + '\'' +
                '}';
    }
}
