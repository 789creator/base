package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.base.sys.dao.mapper.*;
import com.base.sys.dao.model.*;
import com.base.sys.rpc.api.service.UpmsApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UpmsApiService实现
 * Created by shuzheng on 2016/01/19.
 */
@Service
@Transactional
public class UpmsApiServiceImpl implements UpmsApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsApiServiceImpl.class);

    @Autowired
    UpmsUserMapper upmsUserMapper;

    @Autowired
    UpmsApiMapper upmsApiMapper;

    @Autowired
    UpmsRolePermissionMapper upmsRolePermissionMapper;

    @Autowired
    UpmsUserPermissionMapper upmsUserPermissionMapper;

    @Autowired
    UpmsSystemMapper upmsSystemMapper;

    @Autowired
    UpmsOrganizationMapper upmsOrganizationMapper;

    @Autowired
    UpmsLogMapper upmsLogMapper;

    /**
     * 根据用户id获取所拥有的权限
     *
     * @param upmsUserId
     * @return
     */
    @Override
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserId(Integer upmsUserId) {
        // 用户不存在或锁定状态
        UpmsUser upmsUser = upmsUserMapper.selectById(upmsUserId);
        if (null == upmsUser || 1 == upmsUser.getLocked()) {
            LOGGER.info("selectUpmsPermissionByUpmsUserId : upmsUserId={}", upmsUserId);
            return null;
        }
        List<UpmsPermission> upmsPermissions = upmsApiMapper.selectUpmsPermissionByUpmsUserId(upmsUserId);
        return upmsPermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     *
     * @param upmsUserId
     * @return
     */
    @Override
    @Cacheable(value = "base-upms-rpc-service-ehcache", key = "'selectUpmsPermissionByUpmsUserId_' + #upmsUserId")
    public List<UpmsPermission> selectUpmsPermissionByUpmsUserIdByCache(Integer upmsUserId) {
        return selectUpmsPermissionByUpmsUserId(upmsUserId);
    }

    /**
     * 根据用户id获取所属的角色
     *
     * @param upmsUserId
     * @return
     */
    @Override
    public List<UpmsRole> selectUpmsRoleByUpmsUserId(Integer upmsUserId) {
        // 用户不存在或锁定状态
        UpmsUser upmsUser = upmsUserMapper.selectById(upmsUserId);
        if (null == upmsUser || 1 == upmsUser.getLocked()) {
            LOGGER.info("selectUpmsRoleByUpmsUserId : upmsUserId={}", upmsUserId);
            return null;
        }
        List<UpmsRole> upmsRoles = upmsApiMapper.selectUpmsRoleByUpmsUserId(upmsUserId);
        return upmsRoles;
    }

    /**
     * 根据用户id获取所属的角色
     *
     * @param upmsUserId
     * @return
     */
    @Override
    @Cacheable(value = "base-upms-rpc-service-ehcache", key = "'selectUpmsRoleByUpmsUserId_' + #upmsUserId")
    public List<UpmsRole> selectUpmsRoleByUpmsUserIdByCache(Integer upmsUserId) {
        return selectUpmsRoleByUpmsUserId(upmsUserId);
    }

    /**
     * 根据角色id获取所拥有的权限
     *
     * @param upmsRoleId
     * @return
     */
    @Override
    public List<UpmsRolePermission> selectUpmsRolePermisstionByUpmsRoleId(Integer upmsRoleId) {
        EntityWrapper<UpmsRolePermission> entityWrapper = new EntityWrapper<>();
        UpmsRolePermission upmsRolePermission = new UpmsRolePermission();
        upmsRolePermission.setRoleId(upmsRoleId);
        entityWrapper.setEntity(upmsRolePermission);
        List<UpmsRolePermission> upmsRolePermissions = upmsRolePermissionMapper.selectList(entityWrapper);
        return upmsRolePermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     *
     * @param upmsUserId
     * @return
     */
    @Override
    public List<UpmsUserPermission> selectUpmsUserPermissionByUpmsUserId(Integer upmsUserId) {
        EntityWrapper<UpmsUserPermission> entityWrapper = new EntityWrapper<UpmsUserPermission>();
        UpmsUserPermission upmsUserPermission = new UpmsUserPermission();
        upmsUserPermission.setUserId(upmsUserId);
        entityWrapper.setEntity(upmsUserPermission);
        List<UpmsUserPermission> upmsUserPermissions = upmsUserPermissionMapper.selectList(entityWrapper);
        return upmsUserPermissions;
    }


    /**
     * 根据username获取UpmsUser
     *
     * @param username
     * @return
     */
    @Override
    public UpmsUser selectUpmsUserByUsername(String username) {
        EntityWrapper<UpmsUser> entityWrapper = new EntityWrapper<UpmsUser>();
        UpmsUser upmsUser = new UpmsUser();
        upmsUser.setUsername(username);
        entityWrapper.setEntity(upmsUser);
        List<UpmsUser> upmsUsers = upmsUserMapper.selectList(entityWrapper);
        if (null != upmsUsers && upmsUsers.size() > 0) {
            return upmsUsers.get(0);
        }
        return null;
    }

    /**
     * 写入操作日志
     *
     * @param record
     * @return
     */
    @Override
    public int insertUpmsLogSelective(UpmsLog record) {
        return upmsLogMapper.insert(record);
    }

}