package org.zerock.spring1.service;

import com.sun.tools.javac.comp.Todo;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoDTO;
import sun.jvm.hotspot.debugger.Page;

public interface TodoService {

    Long register(TodoDTO todoDTO);

    TodoDTO read(Long tno);

    boolean remove(Long tno);

    boolean modify(TodoDTO dto);

    PageResponseDTO<TodoDTO> getList(PageRequestDTO requestDTO);


}
