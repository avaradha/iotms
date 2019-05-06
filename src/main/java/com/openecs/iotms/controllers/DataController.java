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


import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

// REF:
// https://spring.io/guides/gs/relational-data-access/
// https://www.logicbig.com/tutorials/spring-framework/spring-boot/jdbc-and-in-memory-h2.html
// https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html

@RestController
public class DataController implements ApplicationContextAware {
    private ApplicationContext appContext;
    // EX:
    // appContext.getBeanDefinitionNames();
    // DiskSpaceHealthIndicator healthBean = (DiskSpaceHealthIndicator) appContext.getBean(DiskSpaceHealthIndicator.class);

    @Autowired
    JdbcTemplate jdbcTemplate;    

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        this.appContext = appContext;
    }
    
    @RequestMapping("/companies")
    public List<Map<String, Object>> getCompanies(Model model) {
        String sql = "select * from companies limit 10";  
        return jdbcTemplate.queryForList(sql);
    }

    @RequestMapping("/companies/count")
    public int getCompaniesCount(Model model) {
		String sql = "select count(*) from companies";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @RequestMapping("/status")
    public String status() {
		return "OK";
    }
}