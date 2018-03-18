package com.base.sys.rpc.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.base.sys.dao.model.UpmsUserOrganization;

/**
 * <p>
 * 用户组织关联表 服务类
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
public interface IUpmsUserOrganizationService extends IService<UpmsUserOrganization> {

    /**
     * 用户组织
     *
     * @param organizationIds
     * @param id
     * @return
     */
    int organization(String[] organizationIds, int id);
}
