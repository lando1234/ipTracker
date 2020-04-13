package com.iptracker.rest;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iptracker.exception.RestConnectorException;

@Service
public class RestConnection {

	private ObjectMapper objectMapper;

	@Autowired
	public RestConnection(ObjectMapper defaultObjectMapper) {
		this.objectMapper = defaultObjectMapper;
	}

	public <T> T get(String url, Class clazz) {
		try {
			return (T) this.objectMapper.readValue(this.getResponseFromUrl(url),clazz);
		} catch (Exception e) {
			throw new RestConnectorException(e);
		}
	}

	private String getResponseFromUrl(String url) {
		try {
			URL urlObj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			BufferedReader responseFromApi = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String bfLineRead;
			StringBuffer response = new StringBuffer();
			while ((bfLineRead = responseFromApi.readLine()) != null) {
				response.append(bfLineRead);
			}
			return response.toString();
		} catch (Exception e) {
			throw new RestConnectorException(e);
		}
	}
}

