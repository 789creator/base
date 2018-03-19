package com.base.sys.rpc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsRolePermissionMapper;
import com.base.sys.dao.model.UpmsRolePermission;
import com.base.sys.rpc.api.service.IUpmsRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private UpmsRolePermissionMapper upmsRolePermissionMapper;

    @Override
    public int rolePermission(JSONArray datas, int id) {
        List<Integer> deleteIds = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            JSONObject json = datas.getJSONObject(i);
            if (!json.getBoolean("checked")) {
                deleteIds.add(json.getIntValue("id"));
            } else {
                // 新增权限
                UpmsRolePermission upmsRolePermission = new UpmsRolePermission();
                upmsRolePermission.setRoleId(id);
                upmsRolePermission.setPermissionId(json.getIntValue("id"));
                upmsRolePermissionMapper.insert(upmsRolePermission);
            }
        }
        // 删除权限
        if (deleteIds.size() > 0) {
            EntityWrapper<UpmsRolePermission> wrapper = new EntityWrapper<>();
            UpmsRolePermission p = new UpmsRolePermission();
            p.setRoleId(id);
            wrapper.setEntity(p);
            wrapper.in("permission_id",deleteIds);
            upmsRolePermissionMapper.delete(wrapper);
        }
        return datas.size();
    }
}
