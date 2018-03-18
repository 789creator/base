package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsUserRoleMapper;
import com.base.sys.dao.model.UpmsUserRole;
import com.base.sys.rpc.api.service.IUpmsUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UpmsUserRoleMapper upmsUserRoleMapper;
    @Override
    public int role(String[] roleIds, int id) {
        int result = 0;
        // 删除旧记录
        EntityWrapper<UpmsUserRole> wrapper = new EntityWrapper<>();
        UpmsUserRole r = new UpmsUserRole();
        r.setUserId(id);
        wrapper.setEntity(r);
        upmsUserRoleMapper.delete(wrapper);
        // 增加新记录
        if (null != roleIds) {
            for (String roleId : roleIds) {
                if (StringUtils.isBlank(roleId)) {
                    continue;
                }
                UpmsUserRole upmsUserRole = new UpmsUserRole();
                upmsUserRole.setUserId(id);
                upmsUserRole.setRoleId(NumberUtils.toInt(roleId));
                result = upmsUserRoleMapper.insert(upmsUserRole);
            }
        }
        return result;
    }
}
