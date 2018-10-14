package com.empeti.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringAopApplication.class, args);
        ctx.getBean(StringWriter.class).write("hello");
        SqsRetryTest retryTest = ctx.getBean(SqsRetryTest.class);
        retryTest.retryableMethod();
        retryTest.otherRetryableMethod();
    }
}
