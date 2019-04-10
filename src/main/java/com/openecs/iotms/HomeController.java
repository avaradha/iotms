package com.openecs.iotms;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.springframework.boot.actuate.system.DiskSpaceHealthIndicator;
import org.springframework.boot.actuate.jms.JmsHealthIndicator;
import org.springframework.boot.actuate.health.Health;


//https://spring.io/understanding/application-context
//https://mythinkpond.com/post/2017-11-24-spring-framework-three-ways-to-application-context/
//SomeClass sc = (SomeClass)appContext.getBean(SomeClass.class);

//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;


// To use the Thymeleaf template, we need to use the @Controller directive. @RestController will not work.
@Controller
public class HomeController implements ApplicationContextAware {
    private ApplicationContext appContext;
    //SomeClass sc = (SomeClass)appContext.getBean(SomeClass.class);

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        this.appContext = appContext;
    }  

    @RequestMapping("/")
    public String home(Model model) {
        DiskSpaceHealthIndicator healthBean = (DiskSpaceHealthIndicator) appContext.getBean(DiskSpaceHealthIndicator.class);
        model.addAttribute("health", healthBean.health());

        
        return "dashboard";
    }
}