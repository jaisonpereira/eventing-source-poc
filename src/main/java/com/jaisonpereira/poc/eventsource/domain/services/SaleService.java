package com.jaisonpereira.poc.eventsource.domain.services;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jaisonpereira.poc.eventsource.domain.SaleDto;
import com.jaisonpereira.poc.eventsource.events.EmailEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SaleService {

	@Async
	@EventListener
	public void sendMailSale(EmailEvent event) throws InterruptedException {
		Thread.sleep(4000);
		log.info("Sending mail in async mode : {}", event.getMessage());
	}

	public void createSale(SaleDto dto) {

		log.info("salvando sale {}", dto);

		log.info("sale finished");

	}

}
