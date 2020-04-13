package com.iptracker.service;

import com.iptracker.rest.RestConnection;

import lombok.Getter;

@Getter
public abstract class SnapshotService {

	private RestConnection restConnector;

	protected SnapshotService(RestConnection restConnector) {
		this.restConnector = restConnector;
		this.populateSnapshot();

	}

	public void reload() {
		this.populateSnapshot();
	}

	protected abstract void populateSnapshot();
}
