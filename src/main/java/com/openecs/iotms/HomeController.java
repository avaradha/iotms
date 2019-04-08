package com.openecs.iotms;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//https://spring.io/understanding/application-context
//https://mythinkpond.com/post/2017-11-24-spring-framework-three-ways-to-application-context/

//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;


// To use the Thymeleaf template, we need to use the @Controller directive. @RestController will not work.
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        return "dashboard";
    }
}