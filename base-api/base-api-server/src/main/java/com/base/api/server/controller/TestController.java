package com.base.api.server.controller;


import com.base.api.rpc.service.IUpmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUpmsUserService upmsUserService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return upmsUserService.test();
    }

}

