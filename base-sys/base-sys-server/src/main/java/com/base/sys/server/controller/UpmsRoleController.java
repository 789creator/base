package com.base.sys.server.controller;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.common.constant.JsonResult;
import com.base.common.constant.JsonResultConstant;
import com.base.sys.dao.model.UpmsRole;
import com.base.sys.rpc.api.service.IUpmsRolePermissionService;
import com.base.sys.rpc.api.service.IUpmsRoleService;
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

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/sys/upmsRole")
public class UpmsRoleController {
    @Autowired
    private IUpmsRoleService upmsRoleService;

    @Autowired
    private IUpmsRolePermissionService upmsRolePermissionService;

    @ApiOperation(value = "角色首页")
    @RequiresPermissions("upms:role:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/role/index";
    }

    @ApiOperation(value = "角色权限")
    @RequiresPermissions("upms:role:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public String permission(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsRole role = upmsRoleService.selectById(id);
        modelMap.put("role", role);
        return "/role/permission";
    }

    @ApiOperation(value = "角色权限")
    @RequiresPermissions("upms:role:permission")
    @RequestMapping(value = "/permission/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object permission(@PathVariable("id") int id, HttpServletRequest request) {
        JSONArray datas = JSONArray.parseArray(request.getParameter("datas"));
        int result = upmsRolePermissionService.rolePermission(datas, id);
        return new JsonResult(JsonResultConstant.SUCCESS, result);
    }

    @ApiOperation(value = "角色列表")
    @RequiresPermissions("upms:role:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {

        EntityWrapper<UpmsRole> wrapper = new EntityWrapper<>();
        UpmsRole upmsRole = new UpmsRole();
        wrapper.setEntity(upmsRole);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            wrapper.orderBy(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            wrapper.or().like("title", "%" + search + "%");
        }
        Page<UpmsRole> page = upmsRoleService.selectPage(new Page<UpmsRole>(offset, limit), wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", page.getRecords());
        result.put("total", page.getTotal());
        return result;
    }

    @ApiOperation(value = "新增角色")
    @RequiresPermissions("upms:role:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/role/create";
    }

    @ApiOperation(value = "新增角色")
    @RequiresPermissions("upms:role:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsRole upmsRole) {
        //todo 校验upmsRole
        long time = System.currentTimeMillis();
        upmsRole.setCtime(time);
        upmsRole.setOrders(time);
        upmsRoleService.insert(upmsRole);
        return new JsonResult();
    }

    @ApiOperation(value = "删除角色")
    @RequiresPermissions("upms:role:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        for (String id : split) {
            upmsRoleService.deleteById(Integer.valueOf(id));
        }
        //todo 删除角色对应的权限
        return new JsonResult();
    }

    @ApiOperation(value = "修改角色")
    @RequiresPermissions("upms:role:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsRole role = upmsRoleService.selectById(id);
        modelMap.put("role", role);
        return "/role/update";
    }

    @ApiOperation(value = "修改角色")
    @RequiresPermissions("upms:role:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsRole upmsRole) {
        //todo 校验upmsRole
        upmsRole.setRoleId(id);
        upmsRoleService.updateById(upmsRole);
        return new JsonResult();
    }
}

