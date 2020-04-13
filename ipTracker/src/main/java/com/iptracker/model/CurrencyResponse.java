package com.iptracker.model;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CurrencyResponse implements Serializable {
	private String base;
	private Map<String,Double> rates;


	public Optional<CurrencyRatio> getBaseRatio(Currency currency) {
		return Optional.ofNullable(this.rates.get(currency.getCode())).map( value -> new CurrencyRatio(this.base,currency.getName(),value));
	}


}
