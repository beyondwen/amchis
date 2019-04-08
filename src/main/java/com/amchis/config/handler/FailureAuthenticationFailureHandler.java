package com.amchis.config.handler;

import com.amchis.bean.base.BaseApiService;
import com.amchis.bean.base.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class FailureAuthenticationFailureHandler extends BaseApiService implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        AuthenticationException e) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        BaseResponse baseResponse = null;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            baseResponse = setResultError("账户名或者密码输入错误!");
        } else if (e instanceof LockedException) {
            baseResponse = setResultError("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            baseResponse = setResultError("密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            baseResponse = setResultError("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            baseResponse = setResultError("账户被禁用，请联系管理员!");
        } else {
            baseResponse = setResultError("登录失败!");
        }
        resp.setStatus(401);
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(baseResponse));
        out.flush();
        out.close();
    }
}
