package com.iptracker.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class IpRequest implements IRequest{
	private String ip;

	public IpRequest(String ip) {
		this.ip = ip;
	}

	@Override
	public String getUrl() {
		StringBuilder builder = new StringBuilder();
		builder.append("https://api.ip2country.info/ip?");
		builder.append(this.ip);
		return builder.toString();
	}
}
