package com.openecs.iotms;

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

@RestController
public class DataController implements ApplicationContextAware {
    private ApplicationContext appContext;

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