package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@SpringBootConfiguration
// spring Security 를 Custom 하겠다 라는 선언
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    // security의 코드를 만들려면 굉장히 힘들기 때문에 갖고와서 사용하기

    // HttpSecurity?로 작성되어있던 ?를 제거하고 null오류가 발생해도 일단은 값을 받는걸로 하기로 함
    override fun configure(http: HttpSecurity) {

        // http 시큐리티를 통해서 넘어온 결과를 내가 처리하겠다?
        http.authorizeRequests()
            .mvcMatchers("/**") // "/**" 모든 요청이라는 뜻
            .anonymous() // 누구나

            // 여기까지 기본값, 시큐리티를 거치지 않고 우회해서 테스트를 할 수 있게 함
            .mvcMatchers("/admin") // 인증을 받아야 함
            .fullyAuthenticated()


    }
}