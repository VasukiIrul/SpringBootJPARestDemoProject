package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.config.ContextLoader;

@SpringBootApplication
@EnableJpaAuditing // this is to enable automated auditing by jpa the created and updated by field
					// wil be populated.
public class SpringTutorialApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SpringTutorialApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(SpringTutorialApplication.class, args);
		ContextLoader.getInstance().storeApplicationContext(ctx);
		System.out.println("welcome to my appl");
		
	}
}
