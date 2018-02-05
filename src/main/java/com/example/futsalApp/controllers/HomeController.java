package com.example.futsalApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public ModelAndView home(ModelAndView modelView, Authentication auth){
		modelView.setViewName("home");
		modelView.addObject("auth",auth.getAuthorities().toString());
		return modelView;
	}
	
	@GetMapping("/error")
	public String error(){
		return "error";
	}
	
}
