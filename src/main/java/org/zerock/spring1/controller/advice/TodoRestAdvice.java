package org.zerock.spring1.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zerock.spring1.controller.exception.TodoExeption;

@RestControllerAdvice   //예외처리를 위해서 사용하는 어노테이션
@Log4j2
public class TodoRestAdvice {

    @ExceptionHandler(TodoExeption.class)
    public ResponseEntity<String> checkException(TodoExeption todoExeption){
        log.info("-------TodoRestAdvice-------");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(todoExeption.getMsg());
    }


}
