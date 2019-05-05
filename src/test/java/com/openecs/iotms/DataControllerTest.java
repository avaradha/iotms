package com.openecs.iotms;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


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
public class DataControllerTest {

  @Autowired
  DataController dataController;

  private MockMvc mockMvc;

  @Before
  public void setup() throws Exception {
    // Setup application context and build mockMvc
    this.mockMvc = MockMvcBuilders.standaloneSetup(this.dataController).build();
  }

 @Test
 public void testApiResponse() throws Exception {

  // Send an API request and validate response (Headers + Content)
  mockMvc.perform(get("/status"))
   .andExpect(status().isOk());
 }  
}
