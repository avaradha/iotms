package com.openecs.iotms.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

@RestController
public class DataController implements ApplicationContextAware {
    private ApplicationContext appContext;

    // https://spring.io/guides/gs/relational-data-access/
    // https://www.logicbig.com/tutorials/spring-framework/spring-boot/jdbc-and-in-memory-h2.html
    @Autowired
    JdbcTemplate jdbcTemplate;    

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        this.appContext = appContext;
    }    

    @RequestMapping("/data")
    public Health home(Model model) {
        //return "Data Services";
        DiskSpaceHealthIndicator healthBean = (DiskSpaceHealthIndicator) appContext.getBean(DiskSpaceHealthIndicator.class);
        return healthBean.health();
        

        
        //return appContext.getBeanDefinitionNames();
    }


}