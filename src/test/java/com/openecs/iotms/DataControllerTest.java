package com.openecs.iotms;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit4.SpringRunner;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.Assert.*;

import com.openecs.iotms.controllers.*;

// The "spring-boot-starter-test" includes the following testing libraries
// 
// https://junit.org/junit4/
// https://docs.spring.io/spring/docs/5.1.6.RELEASE/spring-framework-reference/testing.html#integration-testing
// http://hamcrest.org/JavaHamcrest/javadoc/2.1/
// https://joel-costigliola.github.io/assertj/
// https://site.mockito.org/
// https://github.com/skyscreamer/JSONassert
// https://github.com/json-path/JsonPath
// https://www.baeldung.com/spring-boot-testing

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DataControllerTest {

  @Autowired
  private MockMvc mockMvc;

  //@MockBean
  //private DataService service;  

  @Test
  public void getCompaniesTest() throws Exception {
    //when(service.getCompaniesCount()).thenReturn(100);
    this.mockMvc.perform(get("/companies/count")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void testDataController() {
      DataController dataController = new DataController();
      String result = dataController.status();
      System.out.println(result);
      assertEquals(result, "OK");
  }  
}