package com.openecs.iotms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableSwagger2
public class IotmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotmsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		// Execute OS command
		// https://www.baeldung.com/run-shell-command-in-java
		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

		try {
			String process;
			// getRuntime: Returns the runtime object associated with the current Java application.
			// exec: Executes the specified string command in a separate process.
			Process p = Runtime.getRuntime().exec("ps -few");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((process = input.readLine()) != null) {
				System.out.println(process); // <-- Print all Process here line
												// by line
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}	
		
		return args -> {
			/*

			System.out.println("Inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
					System.out.println(beanName);
			}
			*/
		};
		
		//return args -> {};
	}		

}
