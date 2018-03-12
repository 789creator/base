package com.base.sys.server.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.base.sys.dao.model.GenTable;
import com.base.sys.rpc.api.service.IGenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 代码生成表 前端控制器
 * </p>
 *
 * @author zhj
 * @since 2018-03-11
 */
@Controller
@RequestMapping("/genTable")
public class GenTableController {

    @Autowired
    private IGenTableService genTableService;

    /**
     * 分页 PAGE
     */
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("page", genTableService.selectPage(new Page<GenTable>(0, 12)));
        model.addAttribute("test","1213213");
        return "index";
    }
}

