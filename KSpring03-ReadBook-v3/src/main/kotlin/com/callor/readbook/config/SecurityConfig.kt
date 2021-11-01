package com.callor.readbook.config

import com.callor.readbook.service.MemberLoginService
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


// 프로젝트 설정을 위한 Class
@SpringBootConfiguration
// 프로젝트에 Spring Security 설정을 추가한다
// Spring Security를 Customizing 하겠다
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

//    val logger = LoggerFactory.getLogger(SecurityConfig::class.java)

//    @Autowired
//    lateinit var memberService: MemberLoginService

    /*
    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()
    }
    */
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

            .antMatchers("/home/**").permitAll()
            .antMatchers("/home/merry").authenticated()

            .antMatchers("/**").permitAll()

// 단독으로 사용되는 method 함수들은 http.함수() 형식으로 사용
//        http.httpBasic()

            .and().formLogin()
            // Spring Security에서 기본적으로 적용되어있는 login form이 아닌 내가 만든 login 페이지로 가겠다!!
            // Security 기본 form 화면을 보이는 대신 내가 만든 MemberController의 login으로 redirect하라
            .loginPage("/member/login").permitAll()
            .loginProcessingUrl("/login")
            .usernameParameter("userid")
            .passwordParameter("password")

        http.logout()
            // logoutRequestMatcher에게 logout이 요청이 되면 "/"으로 이동하라
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
    }

    /*
    {noop}
    Spring Security에서 제공하는 password 정책

    아직 암호화를 구현하지 않은 상태에서 테스트를 하기 위해서 실행하는 코드
     */
    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth
//            .inMemoryAuthentication()
//
//            // 아래와 같은 ID, PASSWORD를 입력했을 때
//            .withUser("hello")
////            .password("12345")
//            .password("{noop}12345")
//
//            // USER, ADMIN이라는 권한을 부여한다.
//            .roles("USER", "ADMIN")

        // security 야 UserDetailService 인터페이스를 상속받은
        // MemberLoginService 클래스의 객체를 너에게 건네주니
        // 회원 정보 인증을 할 때 사용하라
        // MemberLoginService.loadUserByUserName() 함수를 실행하여 사용자 정보를 나에게 달라
//        auth.userDetailsService(memberService)
        auth.userDetailsService(MemberLoginService())
            // auth 에 담긴 사용자정보를 password 항목을 찾아서
            // CustomPasswordEncoder() 에게 보내서 비밀번호가 맞는지 검사하라
            .passwordEncoder(CustomPasswordEncoder())
    }
}

class CustomPasswordEncoder : PasswordEncoder {
    override fun encode(plan: CharSequence?): String {
        return plan.toString()
    }

    override fun matches(plan: CharSequence?, crypt: String?): Boolean {
//        return plan == crypt
//        logger().
        return true
    }
}