package com.callor.readbook.config

import com.callor.readbook.service.MemberLoginService
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@SpringBootConfiguration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
            "/static/**",
            "/static/css/**",
            "/static/js/**",
            "/static/images/**"
        )

        web.ignoring().requestMatchers(
            PathRequest.toStaticResources().atCommonLocations()
        )
    }

    override fun configure(http: HttpSecurity) {
        http
            // 인증, 인가를 허용하겠다.
            // client로부터 전달된 Request가 인가된 요청인가를 확인하겠다
            .authorizeRequests()
            // member/mypage라는 요청에 인증을 받도록 한다.
            .antMatchers("/member/login").permitAll()
            .antMatchers("/member/mypage").authenticated()
            .antMatchers("/member/**").permitAll()
            .antMatchers("/read/**").authenticated()
            .antMatchers("/**").permitAll()

            .and().formLogin()
            .loginPage("/member/login").permitAll()
            .loginProcessingUrl("/login")

        http.logout()
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(MemberLoginService())
            .passwordEncoder(CustomPasswordEncoder())
    }
}

class CustomPasswordEncoder : PasswordEncoder {
    override fun encode(plan: CharSequence?): String {
        return plan.toString()
    }

    override fun matches(plan: CharSequence?, crypt: String?): Boolean {
        return plan == crypt
//        return true
    }
}