package com.base.sys.server.controller;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.common.constant.JsonResult;
import com.base.common.constant.JsonResultConstant;
import com.base.common.util.MD5Util;
import com.base.sys.dao.model.*;
import com.base.sys.rpc.api.service.*;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/sys/upmsUser")
public class UpmsUserController {
    @Autowired
    private IUpmsUserService upmsUserService;

    @Autowired
    private IUpmsRoleService upmsRoleService;

    @Autowired
    private IUpmsOrganizationService upmsOrganizationService;

    @Autowired
    private IUpmsUserOrganizationService upmsUserOrganizationService;

    @Autowired
    private IUpmsUserRoleService upmsUserRoleService;

    @Autowired
    private IUpmsUserPermissionService upmsUserPermissionService;

    @ApiOperation(value = "用户首页")
    @RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/user/index";
    }

    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    public String organization(@PathVariable("id") int id, ModelMap modelMap) {
        EntityWrapper<UpmsOrganization> wrapper = new EntityWrapper<>();
        // 所有组织
        List<UpmsOrganization> upmsOrganizations = upmsOrganizationService.selectList(wrapper);
        // 用户拥有组织
        EntityWrapper<UpmsUserOrganization> wp = new EntityWrapper<>();
        UpmsUserOrganization upmsUserOrganization = new UpmsUserOrganization();
        upmsUserOrganization.setUserId(id);
        wp.setEntity(upmsUserOrganization);
        List<UpmsUserOrganization> upmsUserOrganizations = upmsUserOrganizationService.selectList(wp);
        modelMap.put("upmsOrganizations", upmsOrganizations);
        modelMap.put("upmsUserOrganizations", upmsUserOrganizations);
        return "/user/organization";
    }

    @ApiOperation(value = "用户组织")
    @RequiresPermissions("upms:user:organization")
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object organization(@PathVariable("id") int id, HttpServletRequest request) {
        String[] organizationIds = request.getParameterValues("organizationId");
        upmsUserOrganizationService.organization(organizationIds, id);
        JsonResult result = new JsonResult();
        return result;
    }

    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String role(@PathVariable("id") int id, ModelMap modelMap) {
        // 所有角色
        EntityWrapper<UpmsRole> wp = new EntityWrapper<>();
        List<UpmsRole> upmsRoles = upmsRoleService.selectList(wp);
        // 用户拥有角色
        EntityWrapper<UpmsUserRole> wrapper = new EntityWrapper<>();
        UpmsUserRole upmsUserRole = new UpmsUserRole();
        upmsUserRole.setUserId(id);
        wrapper.setEntity(upmsUserRole);
        List<UpmsUserRole> upmsUserRoles = upmsUserRoleService.selectList(wrapper);
        modelMap.put("upmsRoles", upmsRoles);
        modelMap.put("upmsUserRoles", upmsUserRoles);
        return "/user/role";
    }

    @ApiOperation(value = "用户角色")
    @RequiresPermissions("upms:user:role")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object role(@PathVariable("id") int id, HttpServletRequest request) {
        String[] roleIds = request.getParameterValues("roleId");
        upmsUserRoleService.role(roleIds, id);
        JsonResult result = new JsonResult();
        return result;
    }

    @ApiOperation(value = "用户权限")
    @RequiresPermissions("upms:user:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public String permission(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectById(id);
        modelMap.put("user", user);
        return "/user/permission";
    }

    @ApiOperation(value = "用户权限")
    @RequiresPermissions("upms:user:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object permission(@PathVariable("id") int id, HttpServletRequest request) {
        JSONArray datas = JSONArray.parseArray(request.getParameter("datas"));
        upmsUserPermissionService.permission(datas, id);
        JsonResult result = new JsonResult();
        return result;
    }

    @ApiOperation(value = "用户列表")
    @RequiresPermissions("upms:user:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        EntityWrapper<UpmsUser> wrapper = new EntityWrapper<>();
        UpmsUser upmsUser = new UpmsUser();
        wrapper.setEntity(upmsUser);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            wrapper.orderBy(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            wrapper.or().like("realname", "%"+search+"%");
        }
        Page page = upmsUserService.selectPage(new Page(offset, limit), wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", page.getRecords());
        result.put("total", page.getTotal());
        return result;
    }

    @ApiOperation(value = "新增用户")
    @RequiresPermissions("upms:user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/user/create";
    }

    @ApiOperation(value = "新增用户")
    @RequiresPermissions("upms:user:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsUser upmsUser) {
        // todo 校验upmsUser
        long time = System.currentTimeMillis();
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        upmsUser.setSalt(salt);
        upmsUser.setPassword(MD5Util.md5(upmsUser.getPassword() + upmsUser.getSalt()));
        upmsUser.setCtime(time);
        upmsUser = upmsUserService.createUser(upmsUser);
        if (null == upmsUser) {
            return new JsonResult(JsonResultConstant.FAILED, "帐号名已存在！");
        }
        return new JsonResult();
    }

    @ApiOperation(value = "删除用户")
    @RequiresPermissions("upms:user:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        for (String id : split) {
            upmsUserService.deleteById(Integer.valueOf(id));
        }
        return new JsonResult();
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsUser user = upmsUserService.selectById(id);
        modelMap.put("user", user);
        return "/user/update";
    }

    @ApiOperation(value = "修改用户")
    @RequiresPermissions("upms:user:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsUser upmsUser) {
        //todo 校验upmsUser
        // 不允许直接改密码
        upmsUser.setPassword(null);
        upmsUser.setUserId(id);
        upmsUserService.updateById(upmsUser);
        return new JsonResult();
    }
}

