package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
  private String playerId;
  private String playerName;
  private Integer bankRoll;
  private Integer currentBet;
  
  public SimplePlayer(String playerId, String playerName, Integer bankRoll) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.bankRoll = bankRoll;
  }
  
  @Override
  public String getPlayerName() {
    return this.playerName;
  }
  
  @Override
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }
  
  @Override
  public int getPoints() {
    return this.bankRoll;
  }
  
  @Override
  public void setPoints(int points) {
    this.bankRoll = points;
  }
  
  @Override
  public String getPlayerId() {
    return this.playerId;
  }
  
  @Override
  public boolean setBet(int bet) {
    return false;
  }
  
  @Override
  public int getBet() {
    return this.currentBet;
  }
  
  @Override
  public void setBetType(BetType betType) {
  
  }
  
  @Override
  public BetType getBetType() {
    return null;
  }
  
  @Override
  public void resetBet() {
  
  }
  
  @Override
  public CoinPair getResult() {
    return null;
  }
  
  @Override
  public void setResult(CoinPair coinPair) {
  
  }
}
