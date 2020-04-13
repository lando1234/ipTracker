package com.iptracker.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iptracker.Utils;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Country implements Serializable {

	private String name;
	private String nativeName;
	@JsonProperty(value = "alpha2Code")
	private String isoCode;
	@JsonProperty(value = "latlng")
	private int[] coordinates;
	private List<String> timezones;
	private List<Currency> currencies;
	private Double distance;
	private String parsedDistance;

	public void setDistanceFrom(Country country) {
		this.distance = this.getCoordinates().length == 0 ? 0 : this.distanceFrom(country);
		this.parsedDistance = this.distance != 0? Utils.formatDecimal(distance) + " Kms": "No hay coordenadas para el país";
	}

	public String parseName() {
		return this.nativeName + "( " + this.name + " )";
	}

	private double distanceFrom(Country country) {
		double lat1 = country.getCoordinates()[0];
		double lon1 = country.getCoordinates()[1];
		double lat2 = this.getCoordinates()[0];
		double lon2 = this.getCoordinates()[1];
		double theta = lon1 - lon2;

		double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math
		 .cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist = dist * 60 * 1.1515;

		distance = dist * 1.609344;
		return distance;
	}
}

