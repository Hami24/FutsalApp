package com.example.futsalApp.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.futsalApp.model.Game;


@Repository
public class GameDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public List <Game> getGames(){
		Session currentSession = sessionFactory.getCurrentSession();
		List <Game> games = currentSession.createQuery("from Game").list();
		return games;
	}
	
	public void addGame(Game game) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(game);
	}
	
}
