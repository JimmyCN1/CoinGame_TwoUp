package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
  private String playerId;
  private String name;
  private Integer bankRoll;
  
  public SimplePlayer(String playerId, String playerName, Integer bankRoll) {
    this.playerId = playerId;
    this.name = playerName;
    this.bankRoll = bankRoll;
  }
  
  @Override
  public String getPlayerName() {
    return null;
  }
  
  @Override
  public void setPlayerName(String playerName) {
  
  }
  
  @Override
  public int getPoints() {
    return 0;
  }
  
  @Override
  public void setPoints(int points) {
  
  }
  
  @Override
  public String getPlayerId() {
    return null;
  }
  
  @Override
  public boolean setBet(int bet) {
    return false;
  }
  
  @Override
  public int getBet() {
    return 0;
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
