package com.topdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.topdata")
//@EntityScan("com.topdata.model")
//@EnableJpaRepositories("com.topdata.repository")
public class TopDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopDataApplication.class, args);
	}

}
