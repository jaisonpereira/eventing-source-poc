package com.jaisonpereira.poc.eventsource.domain;

import java.util.UUID;

import lombok.Data;

@Data
public class CustomerDto {

	public CustomerDto(String name) {
		this.name = name;
		this.id = UUID.randomUUID().toString();
	}

	private String id;
	private String name;

}
