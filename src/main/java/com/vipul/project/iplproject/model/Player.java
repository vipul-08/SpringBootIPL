package com.vipul.project.iplproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private int playerId;
    private String playerName;
    private int runs;
    private int wickets;
    private int catches;
    @ManyToOne
    private Team team;

    public Player() {
    }

    public Player(int playerId, String playerName, int runs, int wickets, int catches, Team team) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.wickets = wickets;
        this.catches = catches;
        this.team = team;
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

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getCatches() {
        return catches;
    }

    public void setCatches(int catches) {
        this.catches = catches;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
