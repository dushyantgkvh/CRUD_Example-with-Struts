package com.witty.struts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class HelloWorldController {

	@GetMapping(path = "hello")
	public String hello() {
		return "Welcome to spring boot";
	}
}
