package com.deepanshu.MindTrack;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {
    @GetMapping("abc")
    public String SayHello() {
        return "Hello World";
    }
}
