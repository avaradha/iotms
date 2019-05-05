package com.openecs.iotms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


import com.openecs.iotms.controllers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IotmsApplicationTests {

	@Autowired
	private DataController dataController;

	@Test
	public void contextLoads() {
		assertThat(dataController).isNotNull();
	}
}
