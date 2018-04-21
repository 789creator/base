package com.base.api.rpc.service;

import com.nxin168.common.domain.ResultBody;
import com.nxin168.domain.member.Member;
import com.nxin168.service.member.dto.CapitalFlowLogDTO;
import com.nxin168.service.member.vo.*;

import java.util.List;

/**
 * Created by xiaohaizi on 2017/6/22.
 */
public interface MemberService {


    /**
     * 发送短信验证码
     *
     * @param smsVO the sms vo
     * @return result body
     */
    ResultBody sendSmsByBizType(SmsVO smsVO);


    /**
     * 登录
     *
     * @param data the data
     * @return result body
     * @throws Exception the exception
     */
    public ResultBody login(LoginVO data) throws Exception;


    /**
     * 登出
     * @param memberId
     * @return
     */
    ResultBody logout(Long memberId, int clientSource);


    /**
     * 用户个人信息
     *
     * @param memberId the member id
     * @return member info
     */
    public ResultBody getMemberInfo(Long memberId);


    /**
     * 根据ID获得用户
     *
     * @param memberId the member id
     * @return member by id
     */
    public Member getMemberById(Long memberId);

    /**
     * 根据ID获得用户
     *
     * @param mobile the member mobile
     * @return member by mobile
     */
    public Member getMemberByMobile(String mobile);

}
