package com.base.sys.rpc.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.base.sys.dao.mapper.UpmsUserOrganizationMapper;
import com.base.sys.dao.model.UpmsUserOrganization;
import com.base.sys.rpc.api.service.IUpmsUserOrganizationService;
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

}
