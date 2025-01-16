package com.employee.crud.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAdvice {
    @Pointcut(value = "execution(* com.employee.crud.*.*.*(..))")
    public void myPointCut() {
    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper mapper = new ObjectMapper();

        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().toString();
        Object[] array = proceedingJoinPoint.getArgs();

        log.info("method invoked:" + " " + className + " " + methodName + "() " + "arguments:" + " " + mapper.writeValueAsString(array));
        Object object = proceedingJoinPoint.proceed();
        log.info(className + " " + methodName + "()" + "Response: " + mapper.writeValueAsString(object));
        return object;
    }
}
