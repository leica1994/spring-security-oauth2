package com.leica.config.security;

import com.leica.config.security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * SpringSecurity配置
 *
 * @author leica
 * @since 2019/6/6 11:10
 */
@Configuration
@EnableWebSecurity //开启WebSecurity功能
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)//开启方法级别的保护
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * 配置认证管理器{@link AuthenticationManagerBuilder}
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*        //在内存中,创建admin账户
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER")
                .and()
                .withUser("leica")
                .password("{noop}123")
                .roles("ADMIN");*/
        auth.userDetailsService(userDetailsService());
    }

    /**
     * 配置http访问 {@link HttpSecurity}
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()// 以/css/**和/index资源不需要验证,外界请求可以直接访问这些资源
                .antMatchers("/user/**", "/blogs/**").hasRole("USER")// 以/user/**的资源需要验证,并需要角色"USER"
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")//登录地址为/login 登录失败地址为/login-error
                .and()
                .exceptionHandling().accessDeniedPage("/401");//异常处理,访问拒绝后跳转401页面
        http.logout().logoutSuccessUrl("/login");//用户注销登录之后,重定向到登录页面
    }
}
