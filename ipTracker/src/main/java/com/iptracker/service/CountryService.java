package com.iptracker.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iptracker.model.Country;
import com.iptracker.rest.RestConnection;


@Service
public class CountryService extends SnapshotService{
	private final String BASE_URL = "https://restcountries.eu/rest/v2/";
	private Map<String, Country> countrySnapshot = new HashMap<>();
	private Country buenosAires;

	@Autowired
	public CountryService(RestConnection restConnector) {
		super(restConnector);
	}

	public Country getCountryData(String code) {
		return this.countrySnapshot.get(code);
	}
	@Override
	protected void populateSnapshot() {
		this.countrySnapshot = new HashMap<>();
		Country[] countries = this.getRestConnector().get(BASE_URL + "all?fields=name;alpha2Code;latlng;timezones;currencies;nativeName", Country[].class);
		this.buenosAires = this.getRestConnector().get(BASE_URL + "alpha/AR?fields=name;alpha2Code;latlng",Country.class);
		Arrays.stream(countries).forEach(country -> {
			country.setDistanceFrom(this.buenosAires);
			this.countrySnapshot.put(country.getIsoCode(),country);
		});

	}

}
