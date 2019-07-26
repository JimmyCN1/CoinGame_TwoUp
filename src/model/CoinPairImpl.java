package model;

import model.interfaces.Coin;
import model.interfaces.CoinPair;

public final class CoinPairImpl implements CoinPair {
  private Coin[] coinPair = new Coin[2];
  
  public CoinPairImpl() {
    this.coinPair[0] = new CoinImpl(1);
    this.coinPair[1] = new CoinImpl(2);
  }
  
  @Override
  public Coin getCoin1() {
    return this.coinPair[0];
  }
  
  @Override
  public Coin getCoin2() {
    return this.coinPair[1];
  }
  
  @Override
  public boolean equals(Object coinPair) {
    return equals(coinPair);
  }
  
  @Override
  public boolean equals(CoinPair coinPair) {
    return this.coinPair[0].equals(coinPair.getCoin1()) && this.coinPair[1].equals(coinPair.getCoin2());
  }
  
  @Override
  public String toString() {
    return String.format("%s, %s", this.coinPair[0].toString(), this.coinPair[1].toString());
  }
}
