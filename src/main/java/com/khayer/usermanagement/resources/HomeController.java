package com.khayer.usermanagement.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class HomeController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return String.format("Hello %s!",name);
    }
    
    
    @GetMapping("/")
    public String home(){
        return "Hello, Usermanagement";
    }
    
}
