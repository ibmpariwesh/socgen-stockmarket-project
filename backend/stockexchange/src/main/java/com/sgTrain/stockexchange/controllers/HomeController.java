package com.sgTrain.stockexchange.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class HomeController {

	@GetMapping(path="/home")
	public String print() {
		return "Welcome User!";
	}
	
}
