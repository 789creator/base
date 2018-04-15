package com.base.api.rpc.service;

import com.baomidou.mybatisplus.service.IService;
import com.base.api.dao.model.UpmsUser;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
public interface IUpmsUserService extends IService<UpmsUser> {

    UpmsUser createUser(UpmsUser upmsUser);
}
