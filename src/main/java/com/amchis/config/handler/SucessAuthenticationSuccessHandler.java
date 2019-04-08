package com.amchis.config.handler;

import com.amchis.bean.base.BaseApiService;
import com.amchis.common.UserUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SucessAuthenticationSuccessHandler extends BaseApiService implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication auth) throws IOException {
        resp.setContentType("application/json;charset=utf-8");
        //RespBean respBean = RespBean.ok("登录成功!", UserUtils.getCurrentUser());
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(setResultSuccess(UserUtils.getCurrentUser())));
        out.flush();
        out.close();
    }
}
