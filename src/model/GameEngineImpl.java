package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameEngineImpl implements GameEngine {
  private GameEngineCallback gameEngineCallback = new GameEngineCallbackImpl();
  private CoinPairImpl spinner = new CoinPairImpl();
  private List<Player> players = new ArrayList<>();
  private List<GameEngineCallback> gameEngineCallbacks = new ArrayList<>();
  
  @Override
  public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
    if (delayIncrement1 < 0 || delayIncrement2 < 0) {
      throw new IllegalArgumentException();
    } else if (finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2) {
      throw new IllegalArgumentException();
    } else if (delayIncrement1 > (finalDelay1 - initialDelay1) || delayIncrement2 > (finalDelay2 - initialDelay2)) {
      throw new IllegalArgumentException();
    } else {
      while (initialDelay1 <= finalDelay1) {
        flipCoins(player);
        timeUntilNextFlip(initialDelay1);
        initialDelay1 += delayIncrement1;
      }
      gameEngineCallback.playerResult(player, player.getResult(), this);
    }
  }
  
  @Override
  public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) throws IllegalArgumentException {
    if (delayIncrement1 < 0 || delayIncrement2 < 0) {
      throw new IllegalArgumentException();
    } else if (finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2) {
      throw new IllegalArgumentException();
    } else if (delayIncrement1 > (finalDelay1 - initialDelay1) || delayIncrement2 > (finalDelay2 - initialDelay2)) {
      throw new IllegalArgumentException();
    } else {
      while (initialDelay1 <= finalDelay1) {
        flipCoins();
        timeUntilNextFlip(initialDelay1);
        initialDelay1 += delayIncrement1;
      }
      applyBetResults(spinner);
    }
  }
  
  private void flipCoins(Player player) {
    player.getResult().getCoin1().flip();
    player.getResult().getCoin2().flip();
    gameEngineCallback.playerCoinUpdate(player, player.getResult().getCoin1(), this);
    gameEngineCallback.playerCoinUpdate(player, player.getResult().getCoin2(), this);
  }
  
  private void flipCoins() {
    spinner.getCoin1().flip();
    spinner.getCoin2().flip();
    gameEngineCallback.spinnerCoinUpdate(spinner.getCoin1(), this);
    gameEngineCallback.spinnerCoinUpdate(spinner.getCoin2(), this);
  }
  
  private void timeUntilNextFlip(int duration) {
    try {
      Thread.sleep(duration);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void applyBetResults(CoinPair spinnerResult) {
    for (Player p : players) {
      if (p.getBetType() == BetType.COIN1) {
        BetType.COIN1.applyWinLoss(p, spinnerResult);
      } else if (p.getBetType() == BetType.COIN2) {
        BetType.COIN2.applyWinLoss(p, spinnerResult);
      } else if (p.getBetType() == BetType.BOTH) {
        BetType.BOTH.applyWinLoss(p, spinnerResult);
      } else {
        BetType.NO_BET.applyWinLoss(p, spinnerResult);
      }
    }
    gameEngineCallback.spinnerResult(spinnerResult, this);
  }
  
  // if id exists, then replaces the player with the new player
  // else, adds the new player to the game
  @Override
  public void addPlayer(Player player) {
    boolean idAlreadyExists = false;
    for (int i = 0; i < players.size(); i++) {
      if (player.getPlayerId() == players.get(i).getPlayerId()) {
        idAlreadyExists = true;
        players.set(i, player);
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
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).getPlayerId() == id) {
        player = players.get(i);
        break;
      }
    }
    return player;
  }
  
  @Override
  public boolean removePlayer(Player player) {
    return players.remove(player);
  }
  
  @Override
  public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
    gameEngineCallbacks.add(gameEngineCallback);
  }
  
  @Override
  public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
    return gameEngineCallbacks.remove(gameEngineCallback);
  }
  
  @Override
  public Collection<Player> getAllPlayers() {
    return players;
  }
  
  @Override
  public boolean placeBet(Player player, int bet, BetType betType) {
    boolean validBet = false;
    if (bet > 0 && player.getPoints() > bet) {
      validBet = true;
      player.setBet(bet);
      player.setBetType(betType);
    } else {
      player.setBet(0);
      player.setBetType(BetType.NO_BET);
    }
    return validBet;
  }
}
