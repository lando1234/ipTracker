package com.iptracker.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class StatisticsReport implements Serializable {
	private String averageDistance;
	private Country closestCountry;
	private Country farthestCountry;
}
