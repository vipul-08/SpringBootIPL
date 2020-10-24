package com.vipul.project.iplproject.controllers;

import com.vipul.project.iplproject.model.Player;
import com.vipul.project.iplproject.repositories.PlayerRepository;
import com.vipul.project.iplproject.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/api/v1/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/api/v1/players/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerRepository.findById(id).orElse(null);
    }

    @GetMapping("/api/v1/players/team/{teamAlias}")
    public List<Player> getPlayerByTeam(@PathVariable String teamAlias) {
        return playerRepository.getAllByTeamTeamAlias(teamAlias);
    }

    @PostMapping("/api/v1/players")
    public Player insertPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("/api/v1/players")
    public Player updatePlayer(@RequestBody Player player) {
        Player existingPlayer = playerRepository.findById(player.getPlayerId()).orElse(null);
        existingPlayer.setRuns(player.getRuns());
        existingPlayer.setWickets(player.getWickets());
        existingPlayer.setCatches(player.getCatches());
        return playerRepository.save(existingPlayer);
    }

    @DeleteMapping("/api/v1/players/{id}")
    public String deletePlayerById(@PathVariable int id) {
        playerRepository.deleteById(id);
        return "Player deleted successfully";
    }

    @GetMapping("/api/v1/players/stats/orange-cap")
    public Player findOrangeCapHolder() {
        return playerRepository.findTop5ByOrderByRunsDesc().get(0);
    }

    @GetMapping("/api/v1/players/stats/purple-cap")
    public Player findPurpleCapHolder() {
        return playerRepository.findTop5ByOrderByWicketsDesc().get(0);
    }

    @GetMapping("/api/v1/players/stats/yellow-cap")
    public Player findYellowCapHolder() {
        return playerRepository.findTop5ByOrderByCatchesDesc().get(0);
    }

    @GetMapping("/api/v1/players/stats/runs")
    public List<Player> findLeadingRunScorers() {
        return playerRepository.findTop5ByOrderByRunsDesc();
    }

    @GetMapping("/api/v1/players/stats/wickets")
    public List<Player> findLeadingWicketTakers() {
        return playerRepository.findTop5ByOrderByWicketsDesc();
    }

    @GetMapping("/api/v1/players/stats/catches")
    public List<Player> findLeadingCatchers() {
        return playerRepository.findTop5ByOrderByCatchesDesc();
    }
}
