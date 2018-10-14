package com.empeti.springaop;

import com.empeti.springaop.annotations.SqsRetry;
import org.springframework.stereotype.Component;

@Component
public class SqsRetryTest {
    @SqsRetry(producer = "testProducer")
    public void retryableMethod(){
        System.out.println("retryableMethod");
    }

    @SqsRetry(producer = "otherProducer")
    public void otherRetryableMethod(){
        System.out.println("otherRetryableMethod");
    }

}
