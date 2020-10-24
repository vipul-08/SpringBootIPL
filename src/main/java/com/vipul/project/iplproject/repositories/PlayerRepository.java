package com.vipul.project.iplproject.repositories;

import com.vipul.project.iplproject.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> getAllByTeamTeamAlias(String alias);
    List<Player> findTop5ByOrderByRunsDesc();
    List<Player> findTop5ByOrderByWicketsDesc();
    List<Player> findTop5ByOrderByCatchesDesc();
}
