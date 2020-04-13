package com.iptracker.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class IpInfo {
	private String ip;
	private String countryName;
	private String countryNativeName;
	private String isoCode;
	private List<String> times;
	private List<CurrencyRatio> currencies;
	private String distance;

}

