package com.vipul.project.iplproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {
    @Id
    @GeneratedValue
    private int teamId;
    private String teamName;
    private String teamAlias;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private int point;

    public Team() {

    }

    public Team(int teamId, String teamName, String teamAlias, int matchesPlayed, int matchesWon, int matcesLost, int point) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamAlias = teamAlias;
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matcesLost;
        this.point = point;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamAlias() {
        return teamAlias;
    }

    public void setTeamAlias(String teamAlias) {
        this.teamAlias = teamAlias;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }
}
