package com.amchis.controller;

import com.amchis.bean.base.BaseApiService;
import com.amchis.bean.base.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegLoginController extends BaseApiService {
    @RequestMapping("/login_p")
    public BaseResponse login() {
        return setResultError("尚未登录，请登录!");
    }
    /*@GetMapping("/employee/advanced/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String basicHello() {
        return "basicHello";
    }*/
}
