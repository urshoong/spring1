package org.zerock.spring1.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {org.zerock.spring1.config.RootConfig.class})
@Log4j2
public class TodoServiceTests {

    @Autowired
    TodoService service;

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        PageResponseDTO<TodoDTO> result = service.getList(pageRequestDTO);

        log.info(result.getTotal());

        result.getDtoList().forEach(dto -> log.info(dto));

        log.info(result);

    }
}
