package com.example.futsalApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.futsalApp.service.GameService;
import com.example.futsalApp.service.PlayerService;

@Controller
public class UserController {

	@Autowired
	PlayerService playerService;
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/user/home")
	public ModelAndView activePlayers(ModelAndView modelView) {
		modelView.addObject("topplayers",playerService.topPlayers());
		modelView.addObject("players",playerService.getPlayers());
		modelView.addObject("games",gameService.getGames());
		modelView.setViewName("userhome");
		return modelView;
	}
}
