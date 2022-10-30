package com.jaisonpereira.poc.eventsource.events;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResourceCreatedEvent<K, T> extends ApplicationEvent {

	public ResourceCreatedEvent(Object source, K id, T recurso, HttpServletResponse response) {
		super(source);
		this.id = id;
		this.recurso = recurso;
		this.response = response;
	}

	public ResourceCreatedEvent(Object source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1105178472575576576L;
	private K id;
	private T recurso;
	private HttpServletResponse response;

}
