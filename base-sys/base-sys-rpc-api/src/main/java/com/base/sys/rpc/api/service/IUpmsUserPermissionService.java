package com.base.sys.rpc.api.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.service.IService;
import com.base.sys.dao.model.UpmsUserPermission;

/**
 * <p>
 * 用户权限关联表 服务类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
public interface IUpmsUserPermissionService extends IService<UpmsUserPermission> {
    /**
     * 用户权限
     *
     * @param datas
     * @param id
     * @return
     */
    int permission(JSONArray datas, int id);
}
