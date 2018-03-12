package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsSystemMapper;
import com.base.sys.dao.model.UpmsSystem;
import com.base.sys.rpc.api.service.IUpmsSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsSystemServiceImpl extends ServiceImpl<UpmsSystemMapper, UpmsSystem> implements IUpmsSystemService {

    @Autowired
    private UpmsSystemMapper upmsSystemMapper;

    @Override
    public UpmsSystem selectUpmsSystemByName(String name) {
        UpmsSystem system = new UpmsSystem();
        system.setName(name);
        UpmsSystem upmsSystem = upmsSystemMapper.selectOne(system);
        return upmsSystem;
    }
}
