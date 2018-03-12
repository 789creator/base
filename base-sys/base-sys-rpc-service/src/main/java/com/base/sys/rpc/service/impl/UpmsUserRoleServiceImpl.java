package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsUserRoleMapper;
import com.base.sys.dao.model.UpmsUserRole;
import com.base.sys.rpc.api.service.IUpmsUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsUserRoleServiceImpl extends ServiceImpl<UpmsUserRoleMapper, UpmsUserRole> implements IUpmsUserRoleService {

}
