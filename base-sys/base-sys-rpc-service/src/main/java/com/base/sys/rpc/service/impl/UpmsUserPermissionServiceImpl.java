package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsUserPermissionMapper;
import com.base.sys.dao.model.UpmsUserPermission;
import com.base.sys.rpc.api.service.IUpmsUserPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限关联表 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsUserPermissionServiceImpl extends ServiceImpl<UpmsUserPermissionMapper, UpmsUserPermission> implements IUpmsUserPermissionService {

}
