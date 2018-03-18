package com.base.sys.rpc.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.base.sys.dao.model.UpmsUser;

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
