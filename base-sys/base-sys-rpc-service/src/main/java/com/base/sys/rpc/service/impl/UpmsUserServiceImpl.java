package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsUserMapper;
import com.base.sys.dao.model.UpmsUser;
import com.base.sys.rpc.api.service.IUpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsUserServiceImpl extends ServiceImpl<UpmsUserMapper, UpmsUser> implements IUpmsUserService {

    @Autowired
    private UpmsUserMapper upmsUserMapper;
    @Override
    public UpmsUser createUser(UpmsUser upmsUser) {
        EntityWrapper<UpmsUser> wrapper = new EntityWrapper<>();
        UpmsUser u = new UpmsUser();
        u.setUsername(upmsUser.getUsername());
        wrapper.setEntity(u);
        long count = upmsUserMapper.selectCount(wrapper);
        if (count > 0) {
            return null;
        }
        upmsUserMapper.insert(upmsUser);
        return upmsUser;
    }
}
