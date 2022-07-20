package com.bkoding.webdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	
	@Value("${target}")
	private String target;
	
	@GetMapping("/")
	public String testRequest() {
		return "Hello Prism " + target;
	}
	
	@GetMapping("/sleep")
	public String testRequestWithDelay(@RequestParam long duration) throws InterruptedException {
		Thread.sleep(duration);
		return "Hello Prism " + target;
	}

}
