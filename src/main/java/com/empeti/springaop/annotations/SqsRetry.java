package com.empeti.springaop.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqsRetry {
    @AliasFor("producer")
    String value() default "";

    @AliasFor("value")
    String producer() default "";
}