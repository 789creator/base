package com.base.sys.server.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.base.common.constant.JsonResult;
import com.base.common.util.StringUtil;
import com.base.sys.dao.model.UpmsLog;
import com.base.sys.rpc.api.service.IUpmsLogService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 操作日志 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/sys/upmsLog")
public class UpmsLogController {
    @Autowired
    private IUpmsLogService upmsLogService;

    @ApiOperation(value = "日志首页")
    @RequiresPermissions("upms:log:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/log/index";
    }

    @ApiOperation(value = "日志列表")
    @RequiresPermissions("upms:log:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value = "sort") String sort,
            @RequestParam(required = false, value = "order") String order) {
        EntityWrapper<UpmsLog> wrapper = new EntityWrapper<>();
        UpmsLog upmsLog = new UpmsLog();
        wrapper.setEntity(upmsLog);
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            wrapper.orderBy(StringUtil.humpToLine(sort) + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            wrapper.or().like("description","%" + search + "%");
        }
        Page<UpmsLog> page = upmsLogService.selectPage(new Page<UpmsLog>(offset,limit),wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", page.getRecords());
        result.put("total", page.getTotal());
        return result;
    }

    @ApiOperation(value = "删除日志")
    @RequiresPermissions("upms:log:delete")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("ids") String ids) {
        String[] split = ids.split("-");
        for (int i=0;i<split.length;i++){
            upmsLogService.deleteById(Integer.valueOf(split[i]));
        }
        return new JsonResult();
    }

}

