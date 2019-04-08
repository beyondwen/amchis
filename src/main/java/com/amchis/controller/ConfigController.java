package com.amchis.controller;

import com.amchis.bean.Menu;
import com.amchis.bean.User;
import com.amchis.common.UserUtils;
import com.amchis.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 这是一个只要登录就能访问的Controller
 * 主要用来获取一些配置信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu() {
        return menuService.getMenusByuId();
    }

    @RequestMapping("/user")
    public User currentUser() {
        return UserUtils.getCurrentUser();
    }

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
