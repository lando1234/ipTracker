package com.iptracker.service;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnapshotContainer{
	private CountryService countryService;
	private CurrencyService currencyService;

	@Autowired
	public SnapshotContainer(CountryService countryService, CurrencyService currencyService) {
		this.countryService = countryService;
		this.currencyService = currencyService;

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(countryService::reload, 0, 1, TimeUnit.DAYS);
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(currencyService::reload, 0, 1, TimeUnit.HOURS);
	}
}
