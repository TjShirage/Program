package com.ejc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ejc")
public class CruDoperationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CruDoperationApplication.class, args);

	}

}
