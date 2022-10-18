package org.zerock.spring1.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class TimeLogAdvice {


    @Before("execution(* org.zerock.spring1.service.SampleService*.*(..))")
    public void logBefore(JoinPoint joinPoint){
      log.info("--------------------------");
      log.info("------TimeLogAdvice--------------------");
      log.info(Arrays.toString(joinPoint.getArgs()));
      log.info("--------------------------");
    }

    @Around("execution(* org.zerock.spring1.service.SampleService*.*(..))")
    public Object logBefore(ProceedingJoinPoint pjp) throws Throwable{
        log.info("--------------------------");
        log.info("------TimeLogAdvice AROUND--------------------");

        long start = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();

        log.info("------------------------------");
        log.info(end - start);
        log.info("--------------------------");

        return result;
    }

}
