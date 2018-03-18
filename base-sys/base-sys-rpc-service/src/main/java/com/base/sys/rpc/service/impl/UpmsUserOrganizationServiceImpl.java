package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsUserOrganizationMapper;
import com.base.sys.dao.model.UpmsUserOrganization;
import com.base.sys.rpc.api.service.IUpmsUserOrganizationService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组织关联表 服务实现类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Service
public class UpmsUserOrganizationServiceImpl extends ServiceImpl<UpmsUserOrganizationMapper, UpmsUserOrganization> implements IUpmsUserOrganizationService {

    @Autowired
    private UpmsUserOrganizationMapper upmsUserOrganizationMapper;
    @Override
    public int organization(String[] organizationIds, int id) {
        int result = 0;
        // 删除旧记录
        EntityWrapper<UpmsUserOrganization> wrapper = new EntityWrapper<>();
        UpmsUserOrganization o = new UpmsUserOrganization();
        o.setUserId(id);
        wrapper.setEntity(o);
        upmsUserOrganizationMapper.delete(wrapper);
        // 增加新记录
        if (null != organizationIds) {
            for (String organizationId : organizationIds) {
                if (StringUtils.isBlank(organizationId)) {
                    continue;
                }
                UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
                upmsUserOrganization.setUserId(id);
                upmsUserOrganization.setOrganizationId(NumberUtils.toInt(organizationId));
                result = upmsUserOrganizationMapper.insert(upmsUserOrganization);
            }
        }
        return result;
    }
}
