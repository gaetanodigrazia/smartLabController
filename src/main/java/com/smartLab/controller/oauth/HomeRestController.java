package com.smartLab.controller.oauth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HomeRestController {
		
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public String getHome() {
		return "home";
	}
}
