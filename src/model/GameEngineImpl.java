package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameEngineImpl implements GameEngine {
  private List<Player> players = new ArrayList<>();
  private List<GameEngineCallback> gameEngineCallbacks = new ArrayList<>();
  
  @Override
  public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
  
  }
  
  @Override
  public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
  
  }
  
  @Override
  public void applyBetResults(CoinPair spinnerResult) {
  
  }
  
  // if id exists, then replaces the player with the new player
  // else, adds the new player to the game
  @Override
  public void addPlayer(Player player) {
    boolean idAlreadyExists = false;
    for (int i = 0; i < this.players.size(); i++) {
      if (player.getPlayerId() == this.players.get(i).getPlayerId()) {
        idAlreadyExists = true;
        this.players.set(i, player);
        break;
      }
    }
    if (!idAlreadyExists) {
      this.players.add(player);
    }
    
  }
  
  @Override
  public Player getPlayer(String id) {
    Player player = null;
    for (int i = 0; i < this.players.size(); i++) {
      if (this.players.get(i).getPlayerId() == id) {
        player = this.players.get(i);
        break;
      }
    }
    return player;
    
  }
  
  @Override
  public boolean removePlayer(Player player) {
    return this.players.remove(player);
  }
  
  @Override
  public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
    this.gameEngineCallbacks.add(gameEngineCallback);
  }
  
  @Override
  public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
    return this.gameEngineCallbacks.remove(gameEngineCallback);
  }
  
  @Override
  public Collection<Player> getAllPlayers() {
    return this.players;
  }
  
  @Override
  public boolean placeBet(Player player, int bet, BetType betType) {
    return false;
  }
}
