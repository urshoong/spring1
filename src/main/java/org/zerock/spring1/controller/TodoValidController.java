package org.zerock.spring1.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.spring1.dto.TodoAddDTO;
import org.zerock.spring1.dto.TodoDTO;

import javax.validation.Valid;
import java.util.List;

/**
 * @Valid - BindingResult 한쌍임
 *
 * 일반적으로는 Form 태그에서 유효성 검사를 해서 데이터를 넘겨준다
 *
 * validator를 적극적으로 사용한다는것은 DTO를 여러개 만들어서 사용해야한다는 의미이다
 *
 * dueDate -> converter에서 null로 인해서 형변환 안되는 오류 예외 처리해주기
 * */


@Controller
@RequestMapping("/todo2")
@Log4j2
public class TodoValidController {

    @PostMapping("/register")
    public String registerPost(@Valid TodoAddDTO todoAddDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("--------------------------");
        log.info("--------------------------");
        log.info(bindingResult);

        //bindingResult에 에러가 있으면 체크할 수 있다
        if(bindingResult.hasErrors()){
            log.info("ERROR.....................");

            //SSR인 경우에만 사용 가능하다
            List<ObjectError> errorList = bindingResult.getAllErrors();

            redirectAttributes.addFlashAttribute("errors", errorList);

            return "redirect:/todo/register";
        }

        log.info(todoAddDTO);
        log.info("--------------------------");
        log.info("--------------------------");

        return "redirect:/todo/list";
    }

}
