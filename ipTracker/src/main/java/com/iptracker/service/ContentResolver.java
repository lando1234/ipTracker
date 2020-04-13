package com.iptracker.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iptracker.Utils;
import com.iptracker.model.Country;
import com.iptracker.model.CurrencyRatio;
import com.iptracker.model.IpInfo;
import com.iptracker.model.IpRequest;
import com.iptracker.model.IpResponse;

@Component
public class ContentResolver {

	private IpService ipService;
	private CountryService countryService;
	private CurrencyService currencyService;
	private StatisticsService statisticsService;

	@Autowired
	public ContentResolver(IpService ipService, CountryService countryService, CurrencyService currencyService,StatisticsService statisticsService) {
		this.ipService = ipService;
		this.countryService = countryService;
		this.currencyService = currencyService;
		this.statisticsService = statisticsService;
	}

	public IpInfo getInfo(String ip){
		IpResponse ipServiceresponse = this.ipService.getIpCountry(new IpRequest(ip));
		Country country = this.countryService.getCountryData(ipServiceresponse.getCountryCode());
		List<CurrencyRatio> currencyRatios = this.currencyService.getCurrencyRatios(country.getCurrencies());

		this.statisticsService.addCountryToStatistics(country);

		return IpInfo.builder()
					 .ip(ip)
					 .countryName(country.parseName())
					 .isoCode(country.getIsoCode())
					 .distance(country.getParsedDistance())
					 .times(country.getTimezones().stream().map(zone -> getDates(zone)).collect(Collectors.toList()))
					 .currencies(currencyRatios)
					 .build();
	}


	private String getDates(String zone) {
		return Utils.formatLocalDateTime(LocalDateTime.now(ZoneId.of(zone))) + "( " + zone + " )";
	}


}
