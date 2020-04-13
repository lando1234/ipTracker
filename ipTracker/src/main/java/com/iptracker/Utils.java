package com.iptracker;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	private static final DecimalFormat decimalFormat = new DecimalFormat("##.#");
	private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm:ss");

	public static String formatDecimal(double d ){
		return decimalFormat.format(d);
	}

	public static String formatLocalDateTime(LocalDateTime dateTime) {
		return dateFormatter.format(dateTime);
	}
}
