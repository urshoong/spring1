package org.zerock.spring1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secu")
@Log4j2
public class SecuSampleController {

    //누구나 접근 할 수 있는 요청 경로
    @GetMapping("/all")
    public void doAll(){

    }

    //일반 권한이 있는 사용자만 들어 올 수 있는 요청 경로
    @GetMapping("/auth")
    public void doAuth(){

    }

}
