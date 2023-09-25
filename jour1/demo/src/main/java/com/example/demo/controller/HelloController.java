package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
    @PostMapping("/test")
    public String hello(){

        return "Hello World";
    }

}
