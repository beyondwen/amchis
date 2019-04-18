package com.amchis.config;

import com.amchis.config.filter.CustomAuthenticationFilter;
import com.amchis.config.handler.AuthenticationAccessDeniedHandler;
import com.amchis.config.handler.CustomLogoutSuccessHandler;
import com.amchis.config.handler.FailureAuthenticationFailureHandler;
import com.amchis.config.handler.SucessAuthenticationSuccessHandler;
import com.amchis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;
    @Autowired
    FailureAuthenticationFailureHandler failureAuthenticationFailureHandler;
    @Autowired
    SucessAuthenticationSuccessHandler sucessAuthenticationSuccessHandler;
    @Autowired
    CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html");
        web.ignoring().antMatchers("/static/**");
        web.ignoring().antMatchers("/login_p");
        web.ignoring().antMatchers("/favicon.ico");
        web.ignoring().antMatchers("/image/downloadimg");
        web.ignoring().antMatchers("/officialwebsite/**");
        web.ignoring().antMatchers("/questionnaire/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin().loginPage("/login_p")
                //.loginProcessingUrl("/login")
                //.usernameParameter("username").passwordParameter("password")
                //.failureHandler(failureAuthenticationFailureHandler)
                //.successHandler(sucessAuthenticationSuccessHandler)
                //.permitAll()
                .and()
                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .cors().and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
        //用重写的Filter替换掉原有的UsernamePasswordAuthenticationFilter
        //http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    //注册自定义的UsernamePasswordAuthenticationFilter
    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(sucessAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(failureAuthenticationFailureHandler);
        filter.setFilterProcessesUrl("/login");
        filter.setUsernameParameter("username");
        filter.setPasswordParameter("password");

        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

}
