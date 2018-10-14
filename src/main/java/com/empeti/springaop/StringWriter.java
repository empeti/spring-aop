package com.empeti.springaop;

import com.empeti.springaop.annotations.ExtendWrite;
import org.springframework.stereotype.Service;

@Service
public class StringWriter {
    @ExtendWrite(before="Before ", after = " there after")
    public void write(String string){
        System.out.print(string);
    }
}
