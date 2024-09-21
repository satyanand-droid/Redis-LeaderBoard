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

  public void addPlayer(String playerName, double score) {
    zSetOperations.add(LeaderboardKey, playerName, score);
  }

  public Optional<Set<String>> getTopNPlayer(int top) {
    return Optional.ofNullable(zSetOperations.reverseRange(LeaderboardKey, 0, top - 1));
  }

  public Optional<Double> getPlayerScore(String name) {
    return Optional.ofNullable(zSetOperations.score(LeaderboardKey, name));
  }

  public Optional<Long> getPlayerRank(String name) {
    Long rank = zSetOperations.reverseRank(LeaderboardKey, name);
    return Optional.ofNullable(rank);
  }
}
