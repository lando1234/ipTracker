package com.iptracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class CurrencyRatio {
	private String base;
	private String currency;
	private double ratio;

	@Override
	public String toString() {
		return this.currency + "(1 " + this.base + "= "+ ratio + " " + this.currency + ")";
	}
}
