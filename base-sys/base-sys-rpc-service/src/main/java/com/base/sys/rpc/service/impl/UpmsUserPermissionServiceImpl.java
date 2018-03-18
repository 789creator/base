package com.base.sys.rpc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsUserPermissionMapper;
import com.base.sys.dao.model.UpmsUserPermission;
import com.base.sys.rpc.api.service.IUpmsUserPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UpmsUserPermissionMapper upmsUserPermissionMapper;
    @Override
    public int permission(JSONArray datas, int id) {
        for (int i = 0; i < datas.size(); i ++) {
            JSONObject json = datas.getJSONObject(i);
            if (json.getBoolean("checked")) {
                // 新增权限
                UpmsUserPermission upmsUserPermission = new UpmsUserPermission();
                upmsUserPermission.setUserId(id);
                upmsUserPermission.setPermissionId(json.getIntValue("id"));
                upmsUserPermission.setType(json.getInteger("type"));
                upmsUserPermissionMapper.insert(upmsUserPermission);
            } else {
                // 删除权限
                EntityWrapper<UpmsUserPermission> wrapper = new EntityWrapper<>();
                UpmsUserPermission upmsUserPermission = new UpmsUserPermission();
                upmsUserPermission.setPermissionId(json.getInteger("id"));
                upmsUserPermission.setType(json.getInteger("type"));
                wrapper.setEntity(upmsUserPermission);
                upmsUserPermissionMapper.delete(wrapper);
            }
        }
        return datas.size();
    }
}
