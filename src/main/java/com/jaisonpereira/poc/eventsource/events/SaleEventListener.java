package com.jaisonpereira.poc.eventsource.events;

import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SaleEventListener implements ApplicationListener<ShoppEvent> {

	@Override
	public void onApplicationEvent(ShoppEvent event) {
		try {
			log.info("Received sale:  {} ", event.getSale());
			Thread.sleep(3000);
			event.getSale().setShopped("BOLSA|Carteira");
			event.getSale().setId(UUID.randomUUID().toString());
			log.info("Received sale after add procuts from customer:  {} ", event.getSale());

		} catch (Exception e) {
			log.error("Error on get saleEvent ", e);
		}
	}
}