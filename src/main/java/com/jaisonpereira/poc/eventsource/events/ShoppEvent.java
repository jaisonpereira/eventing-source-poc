package com.jaisonpereira.poc.eventsource.events;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.jaisonpereira.poc.eventsource.domain.SaleDto;

import lombok.Getter;

@Getter
public class ShoppEvent extends ResourceCreatedEvent<String, SaleDto> {

	private static final long serialVersionUID = 1362200324985467985L;

	private SaleDto sale;

	public ShoppEvent(Object source, SaleDto dto, HttpServletResponse response) {
		super(source, UUID.randomUUID().toString(), dto, response);
		this.sale = dto;
	}

}
