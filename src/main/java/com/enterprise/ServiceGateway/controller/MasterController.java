package com.enterprise.ServiceGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterController {
	
	@GetMapping("/test")
	public String test() {
		return "Hello world!!Swapnil";
	}

}
