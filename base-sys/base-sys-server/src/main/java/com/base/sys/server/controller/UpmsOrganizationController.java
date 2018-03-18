package com.base.sys.server.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.common.constant.JsonResult;
import com.base.sys.dao.model.UpmsOrganization;
import com.base.sys.rpc.api.service.IUpmsOrganizationService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 组织 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/sys/upmsOrganization")
public class UpmsOrganizationController {
    @Autowired
    private IUpmsOrganizationService upmsOrganizationService;

    @ApiOperation(value = "组织首页")
    @RequiresPermissions("upms:organization:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/organization/index";
    }

    @ApiOperation(value = "组织列表")
    @RequiresPermissions("upms:organization:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        EntityWrapper<UpmsOrganization> wrapper = new EntityWrapper<>();
        UpmsOrganization upmsOrganization = new UpmsOrganization();
        wrapper.setEntity(upmsOrganization);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            wrapper.orderBy(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            wrapper.or().like("title", search);
        }
        Page page = upmsOrganizationService.selectPage(new Page(offset, limit), wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", page.getRecords());
        result.put("total", page.getTotal());
        return result;
    }

    @ApiOperation(value = "新增组织")
    @RequiresPermissions("upms:organization:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/organization/create";
    }

    @ApiOperation(value = "新增组织")
    @RequiresPermissions("upms:organization:create")
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(UpmsOrganization upmsOrganization) {
       //TODO 校验upmsOrganization
        long time = System.currentTimeMillis();
        upmsOrganization.setCtime(time);
        upmsOrganizationService.insert(upmsOrganization);
        JsonResult result = new JsonResult();
        return result;
    }

    @ApiOperation(value = "删除组织")
    @RequiresPermissions("upms:organization:delete")
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        for (String s : split) {
            upmsOrganizationService.deleteById(Integer.valueOf(s));
        }
        JsonResult result = new JsonResult();
        return result;
    }

    @ApiOperation(value = "修改组织")
    @RequiresPermissions("upms:organization:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsOrganization organization = upmsOrganizationService.selectById(id);
        modelMap.put("organization", organization);
        return "/organization/update";
    }

    @ApiOperation(value = "修改组织")
    @RequiresPermissions("upms:organization:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsOrganization upmsOrganization) {
        //TODO 校验upmsOrganization
        upmsOrganization.setOrganizationId(id);
        upmsOrganizationService.updateById(upmsOrganization);
        JsonResult result = new JsonResult();
        return result;
    }

}

