package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/member/mypage").authenticated()
            .antMatchers("/**").permitAll()
            .mvcMatchers("/**").anonymous()
//        pop up login 창 띄우기
//        http.httpBasic()
        http.formLogin().loginPage("/member/login").permitAll()
    }
}