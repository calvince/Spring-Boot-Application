package com.moshtel.firstbootproject.configs;

import com.moshtel.firstbootproject.services.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    AppUserDetailService appUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailService);
    }

    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
        web.ignoring().antMatchers("resource/static/**","/css","scss","/js","/images");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf()
                .ignoringAntMatchers("/register/**")//ToDO to remove, just for testing purpose
                .and().authorizeRequests()
                .antMatchers("/books/**")
                .authenticated()
                .antMatchers("/login","/register/**","/reset-password").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/home")
                .loginPage("/login").defaultSuccessUrl("/home")
        ;

    }
}
