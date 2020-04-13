package com.iptracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iptracker.model.Currency;
import com.iptracker.model.CurrencyRatio;
import com.iptracker.model.CurrencyResponse;
import com.iptracker.model.IpRequest;
import com.iptracker.model.IpResponse;
import com.iptracker.rest.RestConnector;

@Component
public class CurrencyService extends SnapshotService{
	private final String API_KEY = "b33cac102aa65c44bae93c2eb8bd0039";


	private CurrencyResponse currencySnapshot;

	@Autowired
	public CurrencyService(RestConnector restConnector) {
		super(restConnector);
	}

	public List<CurrencyRatio> getCurrencyRatios(List<Currency> currencies ){
		return extractRatios(currencies);
	}

	private List<CurrencyRatio> extractRatios(List<Currency> currencies) {
		return currencies.stream()
		                 .map( cur -> this.currencySnapshot.getBaseRatio(cur).orElse(null))
		                 .filter( val -> val != null)
		                 .collect(Collectors.toList());
	}

	@Override
	protected void populateSnapshot() {
		StringBuilder builder = new StringBuilder();
		builder.append("http://data.fixer.io/api/latest?access_key=");
		builder.append(API_KEY);
		this.currencySnapshot = this.getRestConnector().get(builder.toString(),CurrencyResponse.class);
	}

}

