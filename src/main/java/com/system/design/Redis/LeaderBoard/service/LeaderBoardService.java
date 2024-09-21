package com.system.design.Redis.LeaderBoard.service;

import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class LeaderBoardService {
  private static final String LeaderboardKey = "LEADERBOARD";
  @Autowired private ZSetOperations<String, String> zSetOperations;

  public void updateScore(String playerName, double score) {
    zSetOperations.incrementScore(LeaderboardKey, playerName, score);
  }

  public Optional<Set<String>> getTopNPlayer(int top) {
    return Optional.ofNullable(zSetOperations.reverseRange(LeaderboardKey, 0, top - 1));
  }

  public Optional<Double> getPlayerScore(String name) {
    return Optional.ofNullable(zSetOperations.score(LeaderboardKey, name));
  }

  public Long getPlayerRank(String name) {
    Optional<Long> rank = Optional.ofNullable(zSetOperations.reverseRank(LeaderboardKey, name));
    return rank.map(aLong -> aLong + 1).orElse(0L);
  }
}
