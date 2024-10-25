package com.vesalukkarila.simple.webapp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*by default will boot up an embedded Tomcat on port 8080.*/
@SpringBootApplication
public class SimpleWebappSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleWebappSpringbootApplication.class, args);
	}

}
