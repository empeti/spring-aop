package com.empeti.springaop.config;

import com.empeti.springaop.service.SqsProducer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {
    @Bean
    @Qualifier("testProducer")
    public SqsProducer testSqsProducer(){
        SqsProducer sqsProducer =  new SqsProducer();
        sqsProducer.setName("Test Producer");
        return sqsProducer;
    }

    @Bean
    @Qualifier("otherProducer")
    public SqsProducer otherSqsProducer(){
        SqsProducer sqsProducer =  new SqsProducer();
        sqsProducer.setName("Other Producer");
        return sqsProducer;
    }
}
