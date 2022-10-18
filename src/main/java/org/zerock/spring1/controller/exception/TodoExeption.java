package org.zerock.spring1.controller.exception;

import lombok.Getter;

@Getter
public class TodoExeption extends Exception {

    private int errorCode;
    private String msg;

    public TodoExeption(int code, String msg){
        this.errorCode = code;
        this.msg = msg;
    }

}
