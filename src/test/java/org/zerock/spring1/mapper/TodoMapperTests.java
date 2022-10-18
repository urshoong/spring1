package org.zerock.spring1.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.TodoDTO;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {org.zerock.spring1.config.RootConfig.class})
@Log4j2
public class TodoMapperTests {

    @Autowired(required = false)
    TodoMapper mapper;

    @Test
    public void testAll() {

        mapper.listAll().forEach(todoDTO -> log.info(todoDTO));

    }

    @Test
    public void testInsert() {

        TodoDTO dto = TodoDTO.builder()
                .title("Ssss")
                .memo("test")
                .dueDate(LocalDate.now())
                .writer("user1")
                .build();

        int count = mapper.insert(dto);


        log.info("=============================");
        log.info(dto.getTno());
        log.info(count);
    }

    @Test
    public void testSelect() {

        log.info(mapper.select(255L));

    }

    @Test
    public void testDelete() {

        log.info(mapper.delete(255L));

    }

    @Test
    public void testUpdate() {
        TodoDTO dto = TodoDTO.builder()
                .tno(255L)
                .title("Updated..Ssss")
                .memo("Update...test")
                .dueDate(LocalDate.of(2022,11,20))
                .writer("user1")
                .build();

        mapper.update(dto);
    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        mapper.listPage(pageRequestDTO).forEach(todoDTO -> log.info(todoDTO));

        log.info(mapper.listCount(pageRequestDTO));
    }
}
