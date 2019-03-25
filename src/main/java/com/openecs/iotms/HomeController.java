package com.openecs.iotms;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// To use the Thymeleaf template, we need to use the @Controller directive. @RestController will not work.
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        return "dashboard";
    }
}