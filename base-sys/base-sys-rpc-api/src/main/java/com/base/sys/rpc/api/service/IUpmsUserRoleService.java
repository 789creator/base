package com.base.sys.rpc.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.base.sys.dao.model.UpmsUserRole;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
public interface IUpmsUserRoleService extends IService<UpmsUserRole> {

    /**
     * 用户角色
     * @param roleIds
     * @param id
     * @return
     */
    int role(String[] roleIds, int id);
}
