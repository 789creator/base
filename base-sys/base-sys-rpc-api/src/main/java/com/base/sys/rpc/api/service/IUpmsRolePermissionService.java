package com.base.sys.rpc.api.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.service.IService;
import com.base.sys.dao.model.UpmsRolePermission;

/**
 * <p>
 * 角色权限关联表 服务类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
public interface IUpmsRolePermissionService extends IService<UpmsRolePermission> {

    int rolePermission(JSONArray datas, int id);
}
