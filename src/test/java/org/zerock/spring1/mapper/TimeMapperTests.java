package org.zerock.spring1.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {org.zerock.spring1.config.RootConfig.class})
@Log4j2
public class TimeMapperTests {

    @Autowired(required = false)
    TimeMapper timeMapper;

    @Test
    public void testTime(){
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime());
    }

    @Test
    public void testTime2(){
        log.info(timeMapper.getClass().getName());
        log.info(timeMapper.getTime2());
    }

    @Test
    public void testCrypt(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String str = "1111";

        //$2a$10$QC4J5/dl14gEjsnW5blxpeOz1aFi3qwYO.DstlZvemMw.qTja01iy
        //$2a$10$K6hoLBPGEMFllEC7UoY3M..o6rc3HAcJABL3SxiO.kfcsr0M7WfK6
        log.info(passwordEncoder.encode(str));

        String enStr = "$2a$10$K6hoLBPGEMFllEC7UoY3M..o6rc3HAcJABL3SxiO.kfcsr0M7WfK6";

        log.info(passwordEncoder.matches(str, enStr));

    }

}
