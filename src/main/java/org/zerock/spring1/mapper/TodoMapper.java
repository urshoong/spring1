package org.zerock.spring1.mapper;

import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {

    List<TodoDTO> listAll();

    int insert(TodoDTO dto);

    TodoDTO select(Long tno);

    int delete(Long tno);

    int update(TodoDTO dto);

    List<TodoDTO> listPage(PageRequestDTO pageRequestDTO);

    int listCount(PageRequestDTO pageRequestDTO);
}
