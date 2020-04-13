package com.iptracker.rest;

import static com.fasterxml.jackson.databind.DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class JacksonObjectMapper {
	@Bean
	public ObjectMapper defaultObjectMapper() {

		ObjectMapper mapper = new Jackson2ObjectMapperBuilder()
		 .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
		 .build();

		return mapper;
	}
}
