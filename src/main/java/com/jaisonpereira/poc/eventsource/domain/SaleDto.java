package com.jaisonpereira.poc.eventsource.domain;

import lombok.Data;

@Data
public class SaleDto {

	private String id;
	private CustomerDto customer;
	private String shopped;

}
