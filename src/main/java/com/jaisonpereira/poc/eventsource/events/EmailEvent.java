package com.jaisonpereira.poc.eventsource.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class EmailEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1362200324985467985L;

	private String message;

	public EmailEvent(Object source, String dto) {
		super(source);
		this.message = dto;
	}

}
