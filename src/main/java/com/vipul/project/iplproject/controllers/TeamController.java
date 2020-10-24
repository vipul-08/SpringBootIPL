package com.vipul.project.iplproject.controllers;

import com.vipul.project.iplproject.model.Team;
import com.vipul.project.iplproject.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/api/v1/teams")
    public List<Team> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        teams.sort(Comparator.comparing(Team::getPoint).reversed());
        return teams;
    }

    @PostMapping("/api/v1/teams")
    public Team insertTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @PutMapping("/api/v1/teams")
    public Team updateTeam(@RequestBody Team team) {
        Team existingTeam = teamRepository.findById(team.getTeamId()).orElse(null);
        existingTeam.setMatchesPlayed(team.getMatchesPlayed());
        existingTeam.setMatchesLost(team.getMatchesLost());
        existingTeam.setPoint(team.getPoint());
        existingTeam.setMatchesWon(team.getMatchesWon());

        return teamRepository.save(existingTeam);
    }

    @GetMapping("/api/v1/teams/{id}")
    public Team getTeamById(@PathVariable int id) {
        return teamRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/api/v1/teams/{id}")
    public String deleteTeam(@PathVariable int id) {
        teamRepository.deleteById(id);
        return "Team Deleted Successfully";
    }

}
