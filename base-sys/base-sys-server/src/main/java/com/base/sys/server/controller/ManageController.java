package com.base.sys.server.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.base.sys.dao.model.UpmsPermission;
import com.base.sys.dao.model.UpmsSystem;
import com.base.sys.dao.model.UpmsUser;
import com.base.sys.rpc.api.service.IUpmsSystemService;
import com.base.sys.rpc.api.service.UpmsApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 后台controller
 */
@Controller
@RequestMapping("/sys")
@Api(value = "后台管理", description = "后台管理")
public class ManageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManageController.class);

    @Autowired
    private IUpmsSystemService upmsSystemService;

    @Autowired
    private UpmsApiService upmsApiService;

    @ApiOperation(value = "后台首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
//		// 已注册系统
        UpmsSystem upmsSystem = new UpmsSystem();
        upmsSystem.setStatus(1);
        EntityWrapper<UpmsSystem> wrapper = new EntityWrapper<>(upmsSystem);
        List<UpmsSystem> upmsSystems = upmsSystemService.selectList(wrapper);
        modelMap.put("upmsSystems", upmsSystems);
        // 当前登录用户权限
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
        List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(upmsUser.getUserId());
        // todo 从shrio中拿，或者缓存中
        modelMap.put("upmsPermissions", upmsPermissions);
        return "index";
    }

}