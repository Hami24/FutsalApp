package com.example.futsalApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int playerId;
	
	@Column
	private String playerName;
	
	@Column
	private int scoring;
	
	@Column
	private int passing;
	
	@Column
	private int defending;
	
	@Column
	private int goalkeeping;

	@Transient
	private double rating;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable( name = "player_games",
				joinColumns = @JoinColumn(name = "playerId"),
				inverseJoinColumns = @JoinColumn(name = "gameId")
		      )
	private List <Game> games;
	
	public Player() {
		
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScoring() {
		return scoring;
	}

	public void setScoring(int scoring) {
		this.scoring = scoring;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}

	public int getDefending() {
		return defending;
	}

	public void setDefending(int defending) {
		this.defending = defending;
	}

	public int getGoalkeeping() {
		return goalkeeping;
	}

	public void setGoalkeeping(int goalkeeping) {
		this.goalkeeping = goalkeeping;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	

}
