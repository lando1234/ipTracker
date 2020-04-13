package com.iptracker.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iptracker.model.IpRequest;
import com.iptracker.model.IpResponse;
import com.iptracker.rest.RestConnection;

@Component
public class IpService {

	private RestConnection restConnector;

	private final Map<String,IpResponse> ipCache = new HashMap<>();

	@Autowired
	public IpService(RestConnection restConnector) {
		this.restConnector = restConnector;
	}

	public IpResponse getIpCountry(IpRequest request ){
		IpResponse response = this.ipCache.get(request.getIp());
		if(response == null ){
			response = this.restConnector.get(request.getUrl(), IpResponse.class);
			this.ipCache.put(request.getIp(),response);
		}

		return response;
	}
}

