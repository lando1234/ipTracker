package com.iptracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iptracker.Utils;
import com.iptracker.model.Country;
import com.iptracker.model.StatisticsReport;

@Service
public class StatisticsService {

	private volatile List<Country> countriesRegistered = new ArrayList<>();
	private volatile Country closestToBsAs;
	private volatile Country farthestfromBsAs;

	public void addCountryToStatistics(Country country) {
		this.countriesRegistered.add(country);
		if( closestToBsAs == null || this.closestToBsAs.getDistance() > country.getDistance())
			this.closestToBsAs = country;
		if( farthestfromBsAs == null || this.farthestfromBsAs.getDistance() < country.getDistance() )
			this.farthestfromBsAs = country;
	}

	public StatisticsReport generateStatistics() {
		double totalDistance = this.countriesRegistered.stream()
		 .map( country -> country.getDistance())
		 .reduce(0d,(subtotal, distance) -> subtotal + distance);
		int listSize = this.countriesRegistered.size();
		return StatisticsReport.builder()
		                       .closestCountry(this.closestToBsAs)
		                       .farthestCountry(this.farthestfromBsAs)
		                       .averageDistance(Utils.formatDecimal(listSize > 0?totalDistance / listSize : 0 ) + " Kms")
		                       .build();
	}
}
