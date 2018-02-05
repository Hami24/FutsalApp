package com.example.futsalApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.futsalApp.Dao.GameDao;
import com.example.futsalApp.model.Game;

@Service
public class GameService {

	@Autowired
	GameDao gameDao;
	
	@Transactional
	public List <Game> getGames(){
		return gameDao.getGames();
	}
	@Transactional
	public void addGame(Game game) {
		gameDao.addGame(game);
	}
	
}
