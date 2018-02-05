package com.example.futsalApp.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.futsalApp.Dao.PlayerDao;
import com.example.futsalApp.model.Player;

@Service
public class PlayerService {

	@Autowired
	PlayerDao playerDao;
	
	public double ratingCalculator(Player player) {
		
		int a = player.getScoring();
		int b = player.getDefending();
		int c = player.getPassing();
		int d = player.getGoalkeeping();
		
		double sum = (double) a + b + c + d;
	
		return sum/4;
	}
	
	
	@Transactional
	public List<Player> getPlayers(){
		return playerDao.getPlayers();
	}
	
	@Transactional
	public Player getPlayerById(int id) {
		return playerDao.getPlayerById(id);
	}
	
	@Transactional
	public void deletePlayer(int id) {
		playerDao.deletePlayer(id);
	}
	
	@Transactional
	public void addPlayer(Player player) {
		playerDao.addPlayer(player);
	}
	
	@Transactional
	public List <Player> topPlayers(){
		
		List <Player> allPlayers = playerDao.getPlayers();
		
		for(int i = 0; i <allPlayers.size(); i++) {
			Player currentPlayer = allPlayers.get(i);
			currentPlayer.setRating(ratingCalculator(currentPlayer));
		}
		
		Collections.sort(allPlayers, new Comparator <Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return Double.compare(p2.getRating(), p1.getRating());
			}
		});
		
		List <Player> subList = allPlayers.subList(0, 3);
		return subList;
		
	}
}
