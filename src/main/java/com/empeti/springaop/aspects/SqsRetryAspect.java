package com.empeti.springaop.aspects;

import com.empeti.springaop.annotations.SqsRetry;
import com.empeti.springaop.service.SqsProducer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class SqsRetryAspect {
    private ApplicationContext ctx;

    public SqsRetryAspect(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Around("@annotation(com.empeti.springaop.annotations.SqsRetry)")
    public void addSqsRetryLogic(ProceedingJoinPoint call) throws Throwable {
        MethodSignature signature = (MethodSignature) call.getSignature();
        Method method = signature.getMethod();

        SqsRetry sqsRetry = method.getAnnotation(SqsRetry.class);
        System.out.println(sqsRetry);

        try{
            call.proceed();
            throw new RuntimeException();
        }
        catch (RuntimeException e){
            SqsProducer producer = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
                    ctx.getAutowireCapableBeanFactory(), SqsProducer.class, sqsRetry.producer());
            System.out.println(producer.getName());
            System.out.println("Exception caught");
            System.out.println(e);
        }
    }
}
