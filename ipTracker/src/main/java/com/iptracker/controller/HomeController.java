package com.iptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iptracker.service.ContentResolver;

@Controller
@RequestMapping("/home")
public class HomeController {

	private ContentResolver contentResolver;

	@Autowired
	public HomeController(ContentResolver contentResolver) {
		this.contentResolver = contentResolver;
	}

	@GetMapping
	public String getHome() {
		return "home";
	}

	@PostMapping
	public ModelAndView postIp(@RequestParam(value = "ip") String ip){
		ModelAndView modelAndView = new ModelAndView("ip-data");
		this.contentResolver.getInfo(ip).ifPresent(ipInfo -> modelAndView.addObject(ipInfo));
		return modelAndView;
	}
}
