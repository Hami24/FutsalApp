package com.example.futsalApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.futsalApp.model.Game;
import com.example.futsalApp.model.Player;
import com.example.futsalApp.service.GameService;
import com.example.futsalApp.service.PlayerService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	PlayerService playerService;
	
	@Autowired
	GameService gameService;
	
	@GetMapping("dashboard")
	public ModelAndView dashboard(ModelAndView modelView) {
		modelView.setViewName("admindashboard");
		modelView.addObject("players",playerService.getPlayers());
		modelView.addObject("games",gameService.getGames());
		modelView.addObject("player",new Player());
		modelView.addObject("game",new Game());
		return modelView;
	}
	
	@PostMapping("player/addPlayer")
	public String addPlayer(@ModelAttribute("player") Player player) {
		playerService.addPlayer(player);
		return "redirect:/admin/dashboard?updateDone";
	}
	
	@GetMapping("player/update/{id}")
	public ModelAndView showUpdateForm(@PathVariable("id") int id, ModelAndView model) {
		model.setViewName("player/updateForm");
		model.addObject("player",playerService.getPlayerById(id));
		return model;
	}
	
	@GetMapping("player/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		playerService.deletePlayer(id);
		return "redirect:/admin/dashboard?deleteDone";
	}
	
	@PostMapping("game/addGame")
	public String addGame(@ModelAttribute("game") Game game, @RequestParam(name="selected" ,required=false) List <Integer> values) {
		
		if(values == null) {
			return "redirect:/admin/dashboard?notSelected";
		}
		if(values.size() < 10){
			return "redirect:/admin/dashboard?notSelected";
		}
		
		else{
			List <Player> players = new ArrayList <Player> ();
			for(int i=0; i<values.size();i++){
				players.add(playerService.getPlayerById(values.get(i)));
			}
			game.setPlayers(players);
			gameService.addGame(game);
			return "redirect:/admin/dashboard?gameDone";
			
		}
			
	}
	
	
}
