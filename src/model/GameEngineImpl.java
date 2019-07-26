package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

import java.util.Collection;

public class GameEngineImpl implements GameEngine {
  
  @Override
  public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
  
  }
  
  @Override
  public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
  
  }
  
  @Override
  public void applyBetResults(CoinPair spinnerResult) {
  
  }
  
  @Override
  public void addPlayer(Player player) {
  
  }
  
  @Override
  public Player getPlayer(String id) {
    return null;
  }
  
  @Override
  public boolean removePlayer(Player player) {
    return false;
  }
  
  @Override
  public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
  
  }
  
  @Override
  public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
    return false;
  }
  
  @Override
  public Collection<Player> getAllPlayers() {
    return null;
  }
  
  @Override
  public boolean placeBet(Player player, int bet, BetType betType) {
    return false;
  }
}
