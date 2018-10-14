package com.empeti.springaop.aspects;

import com.empeti.springaop.annotations.ExtendWrite;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class ExtendWriteAspect {
    @Around("@annotation(com.empeti.springaop.annotations.ExtendWrite)")
    public Object extendWriter(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        ExtendWrite extendWrite = method.getAnnotation(ExtendWrite.class);

        Object returnObject = null;
        System.out.print(extendWrite.before());
        returnObject = joinPoint.proceed();
        System.out.println(extendWrite.after());

        return returnObject;
    }
}
