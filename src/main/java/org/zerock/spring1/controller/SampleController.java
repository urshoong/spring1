package org.zerock.spring1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.spring1.controller.exception.TodoExeption;
import org.zerock.spring1.dto.PageRequestDTO;
import org.zerock.spring1.dto.PageResponseDTO;
import org.zerock.spring1.dto.TodoDTO;
import org.zerock.spring1.service.TodoService;

/**
 *
 * @RestController 선언해서 사용한다
 *
 * @RequestBody - JSON 데이터를 받고자 하는 데이터 구조로 변경해준다 -> TodoDTO
 *
 * */

@RestController
@Log4j2
@RequiredArgsConstructor
public class SampleController {

    private final TodoService todoService;

    @GetMapping("/ex1")
    public String[] getArr(){
        return new String[]{"AAA", "BBB", "CCC"};
    }

    @PostMapping("/ex2")
    public String[] getArr2(@RequestBody TodoDTO todoDTO){
        log.info(todoDTO);
        return new String[]{"AAA", "BBB", "CCC"};
    }

    @GetMapping("/exList")
    public PageResponseDTO<TodoDTO> getList(){
        return todoService.getList(PageRequestDTO.builder().build());
    }

    //
    @GetMapping("/exRead/{tno}")
    public TodoDTO read(@PathVariable("tno") Long tno) throws TodoExeption{
        log.info("tno : " + tno);
        TodoDTO dto = todoService.read(tno);
        if(dto == null){
            throw new TodoExeption(404, "NOT EXIST");
        }

        return dto;
    }
}
