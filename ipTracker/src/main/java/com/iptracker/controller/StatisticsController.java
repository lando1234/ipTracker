package com.iptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iptracker.model.StatisticsReport;
import com.iptracker.service.StatisticsService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	private StatisticsService statisticsService;

	@Autowired
	public StatisticsController(StatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}

	@GetMapping
	public ResponseEntity<StatisticsReport> getStatistics() {
		return new ResponseEntity<StatisticsReport>(this.statisticsService.generateStatistics(), HttpStatus.OK);
	}
}
