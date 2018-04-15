package com.b2cshop.modules.app.controller;


import com.b2cshop.common.utils.R;
import com.b2cshop.common.validator.ValidatorUtils;
import com.b2cshop.modules.app.entity.UserEntity;
import com.b2cshop.modules.app.form.RegisterForm;
import com.b2cshop.modules.app.service.UserService;
import com.b2cshop.common.utils.R;
import com.b2cshop.common.validator.ValidatorUtils;
import com.b2cshop.modules.app.entity.UserEntity;
import com.b2cshop.modules.app.form.RegisterForm;
import com.b2cshop.modules.app.service.UserService;
import com.b2cshop.common.utils.R;
import com.b2cshop.common.validator.ValidatorUtils;
import com.b2cshop.modules.app.entity.UserEntity;
import com.b2cshop.modules.app.form.RegisterForm;
import com.b2cshop.modules.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 注册
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
@Api("APP注册接口")
public class AppRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getMobile());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        userService.insert(user);

        return R.ok();
    }
}
