package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
  private String playerId;
  private String playerName;
  private Integer initialPoints;
  private Integer currentBet;
  private BetType betType;
  private CoinPair coinPairResult;
  
  public SimplePlayer(String playerId, String playerName, Integer initialPoints) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.initialPoints = initialPoints;
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
    return this.initialPoints;
  }
  
  @Override
  public void setPoints(int points) {
    this.initialPoints = points;
  }
  
  @Override
  public String getPlayerId() {
    return this.playerId;
  }
  
  // sets current bet and returns true if player has sufficient points and
  // the bet is > 0, else returns false
  @Override
  public boolean setBet(int bet) {
    if (bet > 0 && this.initialPoints > bet) {
      this.currentBet = bet;
      return true;
    }
    return false;
  }
  
  @Override
  public int getBet() {
    return this.currentBet;
  }
  
  @Override
  public void setBetType(BetType betType) {
    this.betType = betType;
  }
  
  @Override
  public BetType getBetType() {
    return this.betType;
  }
  
  @Override
  public void resetBet() {
    this.currentBet = 0;
    this.betType = BetType.NO_BET;
  }
  
  @Override
  public CoinPair getResult() {
    return this.coinPairResult;
  }
  
  @Override
  public void setResult(CoinPair coinPair) {
    this.coinPairResult = coinPair;
  }
  
  @Override
  public String toString() {
    return String.format("Player: id=%s, name=%s, bet=%s, betType=%s, points=%s RESULT .. %s\n",
            this.playerId, this.playerName, this.currentBet, this.betType, this.initialPoints, this.coinPairResult.toString());
  }
}
