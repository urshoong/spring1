package org.zerock.spring1.mapper;

import com.sun.tools.javac.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.spring1.dto.Member;

import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {org.zerock.spring1.config.RootConfig.class})
@Log4j2
public class MemberMapperTests {

    @Autowired(required = false)
    MemberMapper memberMapper;

    PasswordEncoder encoder;

    @BeforeEach
    public void ready(){
        encoder = new BCryptPasswordEncoder();
        log.info(encoder);
    }

    @Test
    public void testSelectOnt(){
        log.info(memberMapper.selectOne("m91"));
    }

    /*
    @Test
    public void testInserts(){
        log.info("testIinserts..........");

        IntStream.rangeClosed(1, 100).forEach(i -> {

            Member member = Member.builder()
                    .mid("m"+i)
                    .mpw(encoder.encode("1111"))
                    .mname("사용자"+i)
                    .build();

            if(i <= 80){
                member.setAuthList(List.of("USER"));
            }else if(i <= 90){
                member.setAuthList(List.of("USER", "MANAGER"));
            }else{
                member.setAuthList(List.of("USER", "MANAGER", "ADMIN"));
            }

            log.info(member);
            log.info("--------------------------------------------------");

            memberMapper.insert(member);

            member.getAuthList().forEach(authStr -> {
                memberMapper.insertAuth(member.getMid(), authStr);
            });

        });//end loop

    }
    */

}
