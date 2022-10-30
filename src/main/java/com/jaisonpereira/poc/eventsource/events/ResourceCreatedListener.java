package com.jaisonpereira.poc.eventsource.events;

import java.net.URI;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ResourceCreatedListener<K, T> {

	@EventListener
	public void addHeaderLocation(ResourceCreatedEvent<K, T> event) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(event.getId())
				.toUri();
		event.getResponse().setHeader("Location", uri.toASCIIString());
		log.info("Creating resource location for event location: {} ", uri.toASCIIString());
	}
}
