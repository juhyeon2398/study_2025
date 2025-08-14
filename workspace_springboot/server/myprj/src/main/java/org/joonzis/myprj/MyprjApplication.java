package org.joonzis.myprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class MyprjApplication {

	public static void main(String[] args) {

		log.info("Starting MyprjApplication...22222222");

		SpringApplication.run(MyprjApplication.class, args);
	}

}
