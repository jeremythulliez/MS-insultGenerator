package com.jt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jt.engine.InsultGeneratorService;

@RestController
@RequestMapping("/api")
public class InsultController {

	@Autowired
	InsultGeneratorService insultGeneratorService;
	
	@RequestMapping(value = "/randomInsult", method = RequestMethod.GET)
	public String randomInsult(HttpServletRequest req){
		return insultGeneratorService.getRandomInsult();
	}
	
	
}
