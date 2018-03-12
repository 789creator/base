package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsRolePermissionMapper;
import com.base.sys.dao.model.UpmsRolePermission;
import com.base.sys.rpc.api.service.IUpmsRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsRolePermissionServiceImpl extends ServiceImpl<UpmsRolePermissionMapper, UpmsRolePermission> implements IUpmsRolePermissionService {

}
