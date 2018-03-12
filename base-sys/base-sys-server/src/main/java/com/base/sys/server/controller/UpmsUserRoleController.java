package com.base.sys.server.controller;


import com.base.sys.rpc.api.service.IUpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户角色关联表 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/sys/upmsUserRole")
public class UpmsUserRoleController {

    @Autowired
    private IUpmsUserService upmsUserService;

    @RequestMapping("/test")
    public String test(Model model, HttpServletRequest request) {
        model.addAttribute("user",upmsUserService.selectById(1));
        return "test";
    }
}

