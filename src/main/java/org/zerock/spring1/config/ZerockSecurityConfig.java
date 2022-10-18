package org.zerock.spring1.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.zerock.spring1.security.CustomUserDetailsService;

@EnableWebSecurity
@Log4j2
@ComponentScan(basePackages = {"org.zerock.spring1.security"})
public class ZerockSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //
        log.info("----------------------------------SecurityFilterChain--");
        log.info("----------------------------------SecurityFilterChain--");
        log.info("----------------------------------SecurityFilterChain--");
        log.info("----------------------------------SecurityFilterChain--");

        //인증 관리
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        //메모리에 있는것으로 권한을 사용하겠다는 설정
        //강제로 사용자의 정보 및 권한을 설정
//        authenticationManagerBuilder.inMemoryAuthentication().withUser("user1").password("1111").roles("USER");
//        authenticationManagerBuilder.inMemoryAuthentication().withUser("user1").password("$2a$10$K6hoLBPGEMFllEC7UoY3M..o6rc3HAcJABL3SxiO.kfcsr0M7WfK6").roles("USER");
//        authenticationManagerBuilder.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("1111")).roles("USER");


        //사용자의 권한을 userDetailsService을 사용하도록 변경
        //CustomUserDetailsService 주입
//        authenticationManagerBuilder.userDetailsService(new CustomUserDetailsService());
        //CustomUserDetailsService 에서 PasswordEncoder 가 필요해서 의존 주입을 받아야 하기 때문에 설정을 핸다
//        authenticationManagerBuilder.userDetailsService(new CustomUserDetailsService(passwordEncoder()));
        //ComponentScan을 통해서 자동으로 탐색 가능하게 설정하여 주석처리함

        //해당 인증 권한을 사용하기 위해서는 반드시 작성해야한다
        http.authenticationManager(authenticationManagerBuilder.build());


        http.authorizeRequests().antMatchers("/secu/all").permitAll();
        //role은 권한의 집합이다
        //role 단어가 들어가있으면 'ROLE_'를 생략하고, 권한은 기본적으로 'ROLE_' 가 붙는다
        http.authorizeRequests().antMatchers("/secu/auth").hasRole("USER");


        //기본적으로 로그인 페이지를 제공해준다
        //하지만 우리가 쓸일은 없음
        http.formLogin();
        
        //csrf 토큰을 사용하지 않게 설정
        http.csrf().disable();

        //checkbox 생기고 cookie를 만들어준다
        //userDetailsService 를 만들어줘야 한다
//        http.rememberMe();

        return http.build();
    }

}
