package com.base.sys.rpc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsPermissionMapper;
import com.base.sys.dao.mapper.UpmsSystemMapper;
import com.base.sys.dao.mapper.UpmsUserPermissionMapper;
import com.base.sys.dao.model.UpmsPermission;
import com.base.sys.dao.model.UpmsRolePermission;
import com.base.sys.dao.model.UpmsSystem;
import com.base.sys.dao.model.UpmsUserPermission;
import com.base.sys.rpc.api.service.IUpmsPermissionService;
import com.base.sys.rpc.api.service.UpmsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsPermissionServiceImpl extends ServiceImpl<UpmsPermissionMapper, UpmsPermission> implements IUpmsPermissionService {

    @Autowired
    private UpmsUserPermissionMapper upmsUserPermissionMapper;
    @Autowired
    private UpmsSystemMapper upmsSystemMapper;
    @Autowired
    private UpmsPermissionMapper upmsPermissionMapper;
    @Autowired
    private UpmsApiService upmsApiService;
    @Override
    public JSONArray getTreeByUserId(int usereId, int type) {
        // 角色权限
        EntityWrapper<UpmsUserPermission> wrapper = new EntityWrapper<>();
        UpmsUserPermission p = new UpmsUserPermission();
        p.setUserId(usereId);
        p.setType(type);
        wrapper.setEntity(p);
        List<UpmsUserPermission> upmsUserPermissions = upmsUserPermissionMapper.selectList(wrapper);

        JSONArray systems = new JSONArray();
        // 系统
        EntityWrapper<UpmsSystem> wp = new EntityWrapper<>();
        UpmsSystem s = new UpmsSystem();
        s.setStatus(1);
        wp.setEntity(s);
        wp.orderBy("orders asc");
        List<UpmsSystem> upmsSystems = upmsSystemMapper.selectList(wp);
        for (UpmsSystem upmsSystem : upmsSystems) {
            JSONObject node = new JSONObject();
            node.put("id", upmsSystem.getSystemId());
            node.put("name", upmsSystem.getTitle());
            node.put("nocheck", true);
            node.put("open", true);
            systems.add(node);
        }

        if (systems.size() > 0) {
            for (Object system: systems) {
                EntityWrapper<UpmsPermission> upmsPermissionEntityWrapper = new EntityWrapper<>();
                UpmsPermission permission = new UpmsPermission();
                permission.setStatus(1);
                permission.setSystemId(((JSONObject) system).getIntValue("id"));
                upmsPermissionEntityWrapper.setEntity(permission);
                upmsPermissionEntityWrapper.orderBy("orders asc");
                List<UpmsPermission> upmsPermissions = upmsPermissionMapper.selectList(upmsPermissionEntityWrapper);
                if (upmsPermissions.size() == 0) {
                    continue;
                }
                // 目录
                JSONArray folders = new JSONArray();
                for (UpmsPermission upmsPermission: upmsPermissions) {
                    if (upmsPermission.getPid().intValue() != 0 || upmsPermission.getType() != 1) {
                        continue;
                    }
                    JSONObject node = new JSONObject();
                    node.put("id", upmsPermission.getPermissionId());
                    node.put("name", upmsPermission.getName());
                    node.put("open", true);
                    for (UpmsUserPermission upmsUserPermission : upmsUserPermissions) {
                        if (upmsUserPermission.getPermissionId().intValue() == upmsPermission.getPermissionId().intValue()) {
                            node.put("checked", true);
                        }
                    }
                    folders.add(node);
                    // 菜单
                    JSONArray menus = new JSONArray();
                    for (Object folder : folders) {
                        for (UpmsPermission upmsPermission2: upmsPermissions) {
                            if (upmsPermission2.getPid().intValue() != ((JSONObject) folder).getIntValue("id") || upmsPermission2.getType() != 2) {
                                continue;
                            }
                            JSONObject node2 = new JSONObject();
                            node2.put("id", upmsPermission2.getPermissionId());
                            node2.put("name", upmsPermission2.getName());
                            node2.put("open", true);
                            for (UpmsUserPermission upmsUserPermission : upmsUserPermissions) {
                                if (upmsUserPermission.getPermissionId().intValue() == upmsPermission2.getPermissionId().intValue()) {
                                    node2.put("checked", true);
                                }
                            }
                            menus.add(node2);
                            // 按钮
                            JSONArray buttons = new JSONArray();
                            for (Object menu : menus) {
                                for (UpmsPermission upmsPermission3: upmsPermissions) {
                                    if (upmsPermission3.getPid().intValue() != ((JSONObject) menu).getIntValue("id") || upmsPermission3.getType() != 3) {
                                        continue;
                                    }
                                    JSONObject node3 = new JSONObject();
                                    node3.put("id", upmsPermission3.getPermissionId());
                                    node3.put("name", upmsPermission3.getName());
                                    node3.put("open", true);
                                    for (UpmsUserPermission upmsUserPermission : upmsUserPermissions) {
                                        if (upmsUserPermission.getPermissionId().intValue() == upmsPermission3.getPermissionId().intValue()) {
                                            node3.put("checked", true);
                                        }
                                    }
                                    buttons.add(node3);
                                }
                                if (buttons.size() > 0) {
                                    ((JSONObject) menu).put("children", buttons);
                                    buttons = new JSONArray();
                                }
                            }
                        }
                        if (menus.size() > 0) {
                            ((JSONObject) folder).put("children", menus);
                            menus = new JSONArray();
                        }
                    }
                }
                if (folders.size() > 0) {
                    ((JSONObject) system).put("children", folders);
                }
            }
        }
        return systems;
    }

    @Override
    public JSONArray getTreeByRoleId(int roleId) {
        // 角色已有权限
        List<UpmsRolePermission> rolePermissions = upmsApiService.selectUpmsRolePermisstionByUpmsRoleId(roleId);

        JSONArray systems = new JSONArray();
        // 系统
        EntityWrapper<UpmsSystem> wrapper1 = new EntityWrapper<>();
        UpmsSystem s = new UpmsSystem();
        s.setStatus(1);
        wrapper1.setEntity(s);
        wrapper1.orderBy("orders asc");
        List<UpmsSystem> upmsSystems = upmsSystemMapper.selectList(wrapper1);
        for (UpmsSystem upmsSystem : upmsSystems) {
            JSONObject node = new JSONObject();
            node.put("id", upmsSystem.getSystemId());
            node.put("name", upmsSystem.getTitle());
            node.put("nocheck", true);
            node.put("open", true);
            systems.add(node);
        }

        if (systems.size() > 0) {
            for (Object system: systems) {
                EntityWrapper<UpmsPermission> wrapper2 = new EntityWrapper<>();
                UpmsPermission permission = new UpmsPermission();
                permission.setStatus(1);
                permission.setSystemId(((JSONObject) system).getIntValue("id"));
                wrapper2.setEntity(permission);
                List<UpmsPermission> upmsPermissions = upmsPermissionMapper.selectList(wrapper2);
                if (upmsPermissions.size() == 0) {
                    continue;
                }
                // 目录
                JSONArray folders = new JSONArray();
                for (UpmsPermission upmsPermission: upmsPermissions) {
                    if (upmsPermission.getPid().intValue() != 0 || upmsPermission.getType() != 1) {
                        continue;
                    }
                    JSONObject node = new JSONObject();
                    node.put("id", upmsPermission.getPermissionId());
                    node.put("name", upmsPermission.getName());
                    node.put("open", true);
                    for (UpmsRolePermission rolePermission : rolePermissions) {
                        if (rolePermission.getPermissionId().intValue() == upmsPermission.getPermissionId().intValue()) {
                            node.put("checked", true);
                        }
                    }
                    folders.add(node);
                    // 菜单
                    JSONArray menus = new JSONArray();
                    for (Object folder : folders) {
                        for (UpmsPermission upmsPermission2: upmsPermissions) {
                            if (upmsPermission2.getPid().intValue() != ((JSONObject) folder).getIntValue("id") || upmsPermission2.getType() != 2) {
                                continue;
                            }
                            JSONObject node2 = new JSONObject();
                            node2.put("id", upmsPermission2.getPermissionId());
                            node2.put("name", upmsPermission2.getName());
                            node2.put("open", true);
                            for (UpmsRolePermission rolePermission : rolePermissions) {
                                if (rolePermission.getPermissionId().intValue() == upmsPermission2.getPermissionId().intValue()) {
                                    node2.put("checked", true);
                                }
                            }
                            menus.add(node2);
                            // 按钮
                            JSONArray buttons = new JSONArray();
                            for (Object menu : menus) {
                                for (UpmsPermission upmsPermission3: upmsPermissions) {
                                    if (upmsPermission3.getPid().intValue() != ((JSONObject) menu).getIntValue("id") || upmsPermission3.getType() != 3) {
                                        continue;
                                    }
                                    JSONObject node3 = new JSONObject();
                                    node3.put("id", upmsPermission3.getPermissionId());
                                    node3.put("name", upmsPermission3.getName());
                                    node3.put("open", true);
                                    for (UpmsRolePermission rolePermission : rolePermissions) {
                                        if (rolePermission.getPermissionId().intValue() == upmsPermission3.getPermissionId().intValue()) {
                                            node3.put("checked", true);
                                        }
                                    }
                                    buttons.add(node3);
                                }
                                if (buttons.size() > 0) {
                                    ((JSONObject) menu).put("children", buttons);
                                    buttons = new JSONArray();
                                }
                            }
                        }
                        if (menus.size() > 0) {
                            ((JSONObject) folder).put("children", menus);
                            menus = new JSONArray();
                        }
                    }
                }
                if (folders.size() > 0) {
                    ((JSONObject) system).put("children", folders);
                }
            }
        }
        return systems;
    }
}
