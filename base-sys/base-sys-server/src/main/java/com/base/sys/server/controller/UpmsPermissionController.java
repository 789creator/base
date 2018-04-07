package com.base.sys.server.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.common.constant.JsonResult;
import com.base.sys.dao.model.UpmsPermission;
import com.base.sys.dao.model.UpmsSystem;
import com.base.sys.rpc.api.service.IUpmsPermissionService;
import com.base.sys.rpc.api.service.IUpmsSystemService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
 * 权限 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/sys/upmsPermission")
public class UpmsPermissionController {

    @Autowired
    private IUpmsPermissionService upmsPermissionService;
    @Autowired
    private IUpmsSystemService upmsSystemService;

    @ApiOperation(value = "用户权限列表")
    @RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object user(@PathVariable("id") int id, HttpServletRequest request) {
        return upmsPermissionService.getTreeByUserId(id, NumberUtils.toInt(request.getParameter("type")));
    }

    @ApiOperation(value = "角色权限列表")
    @RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/role/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object role(@PathVariable("id") int id) {
        return upmsPermissionService.getTreeByRoleId(id);
    }

    @ApiOperation(value = "权限首页")
    @RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/permission/index";
    }

    @ApiOperation(value = "权限列表")
    @RequiresPermissions("upms:permission:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, defaultValue = "0", value = "type") int type,
            @RequestParam(required = false, defaultValue = "0", value = "systemId") int systemId,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        EntityWrapper<UpmsPermission> wrapper = new EntityWrapper<UpmsPermission>();
        UpmsPermission upmsPermission = new UpmsPermission();
        if (0 != type) {
            upmsPermission.setType(type);
        }
        if (0 != systemId) {
            upmsPermission.setSystemId(systemId);
        }
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            wrapper.orderBy(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            wrapper.or().like("name", "%" + search + "%");
        }
        wrapper.setEntity(upmsPermission);
        Page<UpmsPermission> page = upmsPermissionService.selectPage(new Page<UpmsPermission>(offset, limit), wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", page.getRecords());
        result.put("total", page.getTotal());
        return result;
    }

    @ApiOperation(value = "新增权限")
    @RequiresPermissions("upms:permission:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        EntityWrapper<UpmsSystem> wrapper = new EntityWrapper<>();
        UpmsSystem upmsSystem = new UpmsSystem();
        upmsSystem.setStatus(1);
        wrapper.setEntity(upmsSystem);
        List<UpmsSystem> upmsSystems = upmsSystemService.selectList(wrapper);
        modelMap.put("upmsSystems", upmsSystems);
        return "/permission/create";
    }

    @ApiOperation(value = "新增权限")
    @RequiresPermissions("upms:permission:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsPermission upmsPermission) {
        //todo 验证upmsPermission
        long time = System.currentTimeMillis();
        upmsPermission.setCtime(time);
        upmsPermission.setOrders(time);
        upmsPermissionService.insert(upmsPermission);
        return new JsonResult();
    }

    @ApiOperation(value = "删除权限")
    @RequiresPermissions("upms:permission:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        for (int i = 0; i < split.length; i++) {
            upmsPermissionService.deleteById(Integer.valueOf(split[i]));
        }
        return new JsonResult();
    }

    @ApiOperation(value = "修改权限")
    @RequiresPermissions("upms:permission:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        EntityWrapper<UpmsSystem> wrapper = new EntityWrapper<>();
        UpmsSystem upmsSystem = new UpmsSystem();
        upmsSystem.setStatus(1);
        wrapper.setEntity(upmsSystem);
        List<UpmsSystem> upmsSystems = upmsSystemService.selectList(wrapper);
        UpmsPermission permission = upmsPermissionService.selectById(id);
        modelMap.put("permission", permission);
        modelMap.put("upmsSystems", upmsSystems);
        return "/permission/update";
    }

    @ApiOperation(value = "修改权限")
    @RequiresPermissions("upms:permission:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsPermission upmsPermission) {
        //todo 校验upmsPermission
        upmsPermission.setPermissionId(id);
        upmsPermissionService.updateById(upmsPermission);
        return new JsonResult();
    }

}

