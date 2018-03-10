package com.muyus.muyucloud.config;

import com.muyus.muyucloud.service.auth.AdminUserDetailService;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

/**
 * SecurityConfig
 *
 * @author: WangHui
 * @email: muyu@muyus.com
 * @date: 2018/3/2
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AdminUserDetailService adminUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/backend/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/backend/login")
                .defaultSuccessUrl("/backend")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) {
        //解决静态资源被拦截的问题
//        web.ignoring().antMatchers("/oss/**");
//        web.ignoring().antMatchers("/favicon.ico");
//        web.ignoring().antMatchers("/main.css");
//        web.ignoring().antMatchers("/swagger-ui.html");
//        web.ignoring().antMatchers("/webjars/**");
//        web.ignoring().antMatchers("/swagger-resources/**");
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(adminUserDetailService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public SpringTemplateEngine templateEngine(SpringResourceTemplateResolver springResourceTemplateResolver, SpringSecurityDialect sec) {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(springResourceTemplateResolver);
        templateEngine.addDialect(sec);
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

}
