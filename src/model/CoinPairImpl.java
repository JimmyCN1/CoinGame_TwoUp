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
    if (coinPair == null || (coinPair != null && (coinPair.getClass() != getClass()))) {
      return false;
    }
    CoinPair coinPairCast = (CoinPair) coinPair;
    return equals(coinPairCast);
  }
  
  @Override
  public boolean equals(CoinPair coinPair) {
    return this.getCoin1().equals(coinPair.getCoin1()) && getCoin2().equals(coinPair.getCoin2());
  }
  
  //TODO:
  @Override
  public int hashCode() {
    return this.getCoin2().hashCode() + this.getCoin2().hashCode();
  }
  
  @Override
  public String toString() {
    return String.format("%s, %s", getCoin1().toString(), getCoin2().toString());
  }
}
