package com.jaisonpereira.poc.eventsource.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jaisonpereira.poc.eventsource.domain.CustomerDto;
import com.jaisonpereira.poc.eventsource.domain.SaleDto;
import com.jaisonpereira.poc.eventsource.domain.services.SaleService;
import com.jaisonpereira.poc.eventsource.events.EmailEvent;
import com.jaisonpereira.poc.eventsource.events.ShoppEvent;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sale")
@Slf4j
public class SaleController {

	private final ApplicationEventPublisher applicationEventPublisher;
	private final SaleService service;

	public SaleController(ApplicationEventPublisher applicationEventPublisher, SaleService service) {
		super();
		this.applicationEventPublisher = applicationEventPublisher;
		this.service = service;
	}

	@GetMapping()
	public String get() {
		return "sale";
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerDto postSale(HttpServletResponse response) {
		CustomerDto dto = new CustomerDto("jaison");
		SaleDto sale = new SaleDto();
		sale.setCustomer(dto);
		log.info("sale started");
		applicationEventPublisher.publishEvent(new ShoppEvent(this, sale, response));
		applicationEventPublisher
				.publishEvent(new EmailEvent(this, "sale in processing Customer : " + sale.getCustomer().getName()));

		service.createSale(sale);
		return dto;
	}

}
