package com.base.sys.server.controller;

import com.base.common.constant.JsonResult;
import com.base.common.constant.JsonResultConstant;
import com.base.sys.client.shiro.session.UpmsSessionDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 会话管理controller
 */
@Controller
@Api(value = "会话管理", description = "会话管理")
@RequestMapping("/sys/upmsSession")
public class UpmsSessionController  {


    @Autowired
    private UpmsSessionDao sessionDAO;

    @ApiOperation(value = "会话首页")
    @RequiresPermissions("upms:session:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/session/index";
    }

    @ApiOperation(value = "会话列表")
    @RequiresPermissions("upms:session:read")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit) {
        return sessionDAO.getActiveSessions(offset, limit);
    }

    @ApiOperation(value = "强制退出")
    @RequiresPermissions("upms:session:forceout")
    @RequestMapping(value = "/forceout/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public Object forceout(@PathVariable("ids") String ids) {
        int count = sessionDAO.forceout(ids);
        return new JsonResult(JsonResultConstant.SUCCESS, count);
    }

}