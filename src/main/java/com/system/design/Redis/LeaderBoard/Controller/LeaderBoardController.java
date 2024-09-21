package com.system.design.Redis.LeaderBoard.Controller;

import com.system.design.Redis.LeaderBoard.service.LeaderBoardService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaderboard")
public class LeaderBoardController {

  @Autowired LeaderBoardService leaderboardService;

  @PostMapping("/updateScore")
  public String updateScore(@RequestParam String name, @RequestParam Double score) {
    leaderboardService.updateScore(name, score);
    return "score updated";
  }

  @GetMapping("top/{count}")
  public Set<String> getTopPlayers(@PathVariable int count) {
    Optional<Set<String>> players = leaderboardService.getTopNPlayer(count);
    return players.orElseGet(HashSet::new);
  }

  @GetMapping("rank/{name}")
  public Long getPlayerRank(@PathVariable String name) {
    return leaderboardService.getPlayerRank(name);
  }

  @GetMapping("score/{name}")
  public Double getPlayerScore(@PathVariable String name) {
    Optional<Double> score = leaderboardService.getPlayerScore(name);
    return score.orElse(0.0);
  }
}
