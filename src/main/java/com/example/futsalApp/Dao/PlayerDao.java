package com.example.futsalApp.Dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.futsalApp.model.Player;

@Repository
public class PlayerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Player> getPlayers(){
		Session currentSession = sessionFactory.getCurrentSession();
		List <Player> players = currentSession.createQuery("from Player").list();
		return players;
	}
	
	public Player getPlayerById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Player where playerId= :id");
		query.setParameter("id", id);
		return (Player) query.uniqueResult();
	}
	
	public void deletePlayer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Player where playerId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
	
	public void addPlayer(Player player) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(player);
	}
	
}
