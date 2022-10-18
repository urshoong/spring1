package org.zerock.spring1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.spring1.dto.MemberMapper;

@Controller
@RequestMapping("/member")
@Log4j2
public class MemberController {

    @GetMapping("/addAll")
    public void addAll(){

    }

    @PostMapping("/addAll")
    public void addAllPost(MemberMapper memberWrapper){
        //log.info(Arrays.toString(arr));
        log.info(memberWrapper.getArr().getClass().getName());
        log.info(memberWrapper);

    }

}
