package com.system.design.Redis.LeaderBoard.Controller;

import com.system.design.Redis.LeaderBoard.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/leaderboard")
public class LeaderBoardController {

    @Autowired
    LeaderBoardService leaderboardService;


    @PostMapping("/add")
    public String addPlayer(@RequestParam String name, @RequestParam Double score){
        leaderboardService.addPlayer(name,score);
        return "player added";
    }

    @GetMapping("top/{count}")
    public Set<String> getTopPlayers(@PathVariable int count){
        Optional<Set<String>> players= leaderboardService.getTopNPlayer(count);
        return players.orElseGet(HashSet::new);
    }
}
