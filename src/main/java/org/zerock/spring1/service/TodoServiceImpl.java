package org.zerock.spring1.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoDTO;
import org.zerock.spring1.mapper.TodoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
@ToString
public class TodoServiceImpl implements TodoService{

    private final TodoMapper todoMapper;


    @Override
    public Long register(TodoDTO todoDTO) {

        log.info(todoDTO);
        todoMapper.insert(todoDTO);
        return todoDTO.getTno();
    }

    @Override
    public TodoDTO read(Long tno) {
        log.info(tno);
        return todoMapper.select(tno);
    }

    @Override
    public boolean remove(Long tno) {
        log.info(tno);
        return todoMapper.delete(tno) == 1;
    }

    @Override
    public boolean modify(TodoDTO dto) {
        log.info(dto);
        return todoMapper.update(dto) == 1;
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO requestDTO) {

        List<TodoDTO> dtoList = todoMapper.listPage(requestDTO);
        int total = todoMapper.listCount(requestDTO);

        return new PageResponseDTO(requestDTO,total, dtoList);
    }
}
