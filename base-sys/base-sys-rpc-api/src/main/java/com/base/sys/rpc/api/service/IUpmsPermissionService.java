package com.base.sys.rpc.api.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.service.IService;
import com.base.sys.dao.model.UpmsPermission;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
public interface IUpmsPermissionService extends IService<UpmsPermission> {

    JSONArray getTreeByUserId(int usereId, int type);

    JSONArray getTreeByRoleId(int roleId);
}
