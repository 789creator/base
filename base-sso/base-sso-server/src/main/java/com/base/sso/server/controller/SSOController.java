package com.base.sso.server.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.base.common.constant.JsonResult;
import com.base.common.constant.JsonResultConstant;
import com.base.common.constant.UpmsResult;
import com.base.common.constant.UpmsResultConstant;
import com.base.common.util.PropertiesFileUtil;
import com.base.common.util.RedisUtil;
import com.base.sso.core.model.UpmsSystem;
import com.base.sso.core.service.IUpmsSystemService;
import com.base.sso.core.shiro.session.UpmsSession;
import com.base.sso.core.shiro.session.UpmsSessionDao;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * 单点登录管理
 * @author z
 */
@Controller
@RequestMapping("/sso")
public class SSOController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SSOController.class);
    // 全局会话key
    private final static String BASE_UPMS_SERVER_SESSION_ID = "base-upms-server-session-id";
    // 全局会话key列表
    private final static String BASE_UPMS_SERVER_SESSION_IDS = "base-upms-server-session-ids";
    // code key
    private final static String BASE_UPMS_SERVER_CODE = "base-upms-server-code";

    @Autowired
    IUpmsSystemService upmsSystemService;


    @Autowired
    UpmsSessionDao upmsSessionDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws Exception {
        String appid = request.getParameter("appid");
        String backurl = request.getParameter("backurl");
        Subject subject = SecurityUtils.getSubject();
        System.out.print(subject.isAuthenticated());
        if (StringUtils.isBlank(appid)) {
            throw new RuntimeException("无效访问！");
        }
        // 判断请求认证系统是否注册
        EntityWrapper<UpmsSystem> entityWrapper = new EntityWrapper<>();
        UpmsSystem upmsSystem = new UpmsSystem();
        upmsSystem.setName(appid);
        entityWrapper.setEntity(upmsSystem);
        int count = upmsSystemService.selectCount(entityWrapper);
        if (0 == count) {
            throw new RuntimeException(String.format("未注册的系统:%s", appid));
        }
        return "redirect:/sso/login?backurl=" + URLEncoder.encode(backurl, "utf-8");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String serverSessionId = session.getId().toString();
        // 判断是否已登录，如果已登录，则回跳
        String code = RedisUtil.get(BASE_UPMS_SERVER_SESSION_ID + "_" + serverSessionId);
        // code校验值
        if (StringUtils.isNotBlank(code)) {
            // 回跳
            String backurl = request.getParameter("backurl");
            String username = (String) subject.getPrincipal();
            if (StringUtils.isBlank(backurl)) {
                backurl = "/";
            } else {
                if (backurl.contains("?")) {
                    backurl += "&upms_code=" + code + "&upms_username=" + username;
                } else {
                    backurl += "?upms_code=" + code + "&upms_username=" + username;
                }
            }
            LOGGER.debug("认证中心帐号通过，带code回跳：{}", backurl);
            return "redirect:" + backurl;
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        if (StringUtils.isBlank(username)) {
            return new JsonResult(JsonResultConstant.FAILED,"帐号不能为空！");
        }
        if (StringUtils.isBlank(password)) {
            return new JsonResult(JsonResultConstant.FAILED,"密码不能为空！");
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String sessionId = session.getId().toString();
        // 判断是否已登录，如果已登录，则回跳，防止重复登录
        String hasCode = RedisUtil.get(BASE_UPMS_SERVER_SESSION_ID + "_" + sessionId);
        // code校验值
        if (StringUtils.isBlank(hasCode)) {
            // 使用shiro认证
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            try {
                if (BooleanUtils.toBoolean(rememberMe)) {
                    usernamePasswordToken.setRememberMe(true);
                } else {
                    usernamePasswordToken.setRememberMe(false);
                }
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                return new JsonResult(JsonResultConstant.FAILED,"帐号不存在！");
            } catch (IncorrectCredentialsException e) {
                return new JsonResult(JsonResultConstant.FAILED,"密码错误！");
            } catch (LockedAccountException e) {
                return new JsonResult(JsonResultConstant.FAILED,"帐号已锁定！");
            }
            // 更新session状态
            upmsSessionDao.updateStatus(sessionId, UpmsSession.OnlineStatus.on_line);
            // 全局会话sessionId列表，供会话管理
            RedisUtil.lpush(BASE_UPMS_SERVER_SESSION_IDS, sessionId.toString());
            // 默认验证帐号密码正确，创建code
            String code = UUID.randomUUID().toString();
            // 全局会话的code
            RedisUtil.set(BASE_UPMS_SERVER_SESSION_ID + "_" + sessionId, code, (int) subject.getSession().getTimeout() / 1000);
            // code校验值
            RedisUtil.set(BASE_UPMS_SERVER_CODE + "_" + code, code, (int) subject.getSession().getTimeout() / 1000);
        }
        // 回跳登录前地址
        String backurl = request.getParameter("backurl");
        if (StringUtils.isBlank(backurl)) {
            UpmsSystem upmsSystem = upmsSystemService.selectUpmsSystemByName(PropertiesFileUtil.getInstance().get("app.name"));
            backurl = null == upmsSystem ? "/" : upmsSystem.getBasepath();
            return new JsonResult(JsonResultConstant.SUCCESS,backurl);
        } else {
            return new JsonResult(JsonResultConstant.SUCCESS,backurl);
        }
    }

    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @ResponseBody
    public Object code(HttpServletRequest request) {
        String codeParam = request.getParameter("code");
        String code = RedisUtil.get(BASE_UPMS_SERVER_CODE + "_" + codeParam);
        if (StringUtils.isBlank(codeParam) || !codeParam.equals(code)) {
            new UpmsResult(UpmsResultConstant.FAILED, "无效code");
        }
        return new UpmsResult(UpmsResultConstant.SUCCESS, code);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        // shiro退出登录
        SecurityUtils.getSubject().logout();
        // 跳回原地址
        String redirectUrl = request.getHeader("Referer");
        if (null == redirectUrl) {
            redirectUrl = "/";
        }
        return "redirect:" + redirectUrl;
    }

}