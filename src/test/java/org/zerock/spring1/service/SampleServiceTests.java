package org.zerock.spring1.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {org.zerock.spring1.config.RootConfig.class})
@Log4j2
public class SampleServiceTests {

    @Autowired
    private SampleService service;

    @Autowired
    private TimeService timeService;


    @Test
    public void testInsert(){

    }


    @Test
    public void testService(){

        log.info("========================");
        log.info(service);
        log.info(service.getClass().getName());

        service.add(10,20);

    }
}
