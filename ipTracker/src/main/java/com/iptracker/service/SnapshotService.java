package com.iptracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTask;

import com.iptracker.rest.RestConnector;

import lombok.Getter;

@Getter
public abstract class SnapshotService {

	private RestConnector restConnector;

	protected SnapshotService(RestConnector restConnector) {
		this.restConnector = restConnector;
		this.populateSnapshot();

	}

	public void reload() {
		this.populateSnapshot();
	}

	protected abstract void populateSnapshot();
}
