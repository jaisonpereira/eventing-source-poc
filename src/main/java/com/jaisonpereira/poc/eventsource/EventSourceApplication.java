package com.jaisonpereira.poc.eventsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EventSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventSourceApplication.class, args);
	}

}
