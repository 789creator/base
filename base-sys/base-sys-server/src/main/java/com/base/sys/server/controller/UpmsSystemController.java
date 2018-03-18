package com.base.sys.server.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.common.constant.JsonResult;
import com.base.sys.dao.model.UpmsSystem;
import com.base.sys.rpc.api.service.IUpmsSystemService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/sys/upmsSystem")
public class UpmsSystemController {

    @Autowired
    private IUpmsSystemService upmsSystemService;

    @ApiOperation(value = "系统首页")
    @RequiresPermissions("upms:system:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/system/index";
    }

    @ApiOperation(value = "系统列表")
    @RequiresPermissions("upms:system:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {

        EntityWrapper<UpmsSystem> wrapper = new EntityWrapper<>();
        UpmsSystem upmsSystem = new UpmsSystem();
        wrapper.setEntity(upmsSystem);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            wrapper.orderBy(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            wrapper.or().like("title", search);
        }
        Page page = upmsSystemService.selectPage(new Page(offset, limit), wrapper);
//        List<UpmsSystem> rows = upmsSystemService.selectList(wrapper);
//        long total = upmsSystemService.selectCount(wrapper);
//        JsonResult result = new JsonResult();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", page.getTotal());
        map.put("rows", page.getRecords());
//        result.setData(page);
        return map;
    }

    @ApiOperation(value = "新增系统")
    @RequiresPermissions("upms:system:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/system/create";
    }

    @ApiOperation(value = "新增系统")
    @RequiresPermissions("upms:system:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(UpmsSystem upmsSystem) {
        //todo 校验数据
        long time = System.currentTimeMillis();
        upmsSystem.setCtime(time);
        upmsSystem.setOrders(time);
        upmsSystemService.insert(upmsSystem);
        JsonResult result = new JsonResult();
        return result;
    }

    @ApiOperation(value = "删除系统")
    @RequiresPermissions("upms:system:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        for (String s : split) {
            upmsSystemService.deleteById(Integer.valueOf(s));
        }
        JsonResult result = new JsonResult();
        return result;
    }

    @ApiOperation(value = "修改系统")
    @RequiresPermissions("upms:system:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, ModelMap modelMap) {
        UpmsSystem system = upmsSystemService.selectById(id);
        modelMap.put("system", system);
        return "/system/update";
    }

    @ApiOperation(value = "修改系统")
    @RequiresPermissions("upms:system:update")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object update(@PathVariable("id") int id, UpmsSystem upmsSystem) {
        upmsSystem.setSystemId(id);
        upmsSystemService.updateById(upmsSystem);
        JsonResult result = new JsonResult();
        return result;
    }

}

