package org.zerock.spring1.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.spring1.dto.Member;
import org.zerock.spring1.mapper.MemberMapper;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("===================================================");
        log.info(memberMapper);
        log.info(passwordEncoder);
        log.info("===================================================");
        log.info("---------------------------------loadUserByUsername");
        log.info(username);
        log.info("---------------------------------loadUserByUsername");

        Member member = memberMapper.selectOne(username);

        log.info(member);

        return member;

        /*
        UserDetails user = User.builder()
                .username(username)
                .password(passwordEncoder.encode("111"))//passwordEncoder가 필요하다 -> 회원의 DB 정보 가져오는 코드 구현 시 이슈가 있음
                .authorities("ROLE_USER")
                .build();

        //return null ->  사용자의 인증 정보가 넘어가지 않는다 -> 로그인이 안된다
        return user;
        */
    }
}
