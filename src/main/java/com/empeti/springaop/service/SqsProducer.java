package com.empeti.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class SqsProducer {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SqsProducer{" +
                "name='" + name + '\'' +
                '}';
    }
}
