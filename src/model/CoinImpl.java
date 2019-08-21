package model;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin {
  private int coinNumber;
  private CoinFace coinFace;
  
  public CoinImpl(int coinNumber) {
    this.coinNumber = coinNumber;
    // randomise initial coinFace
    int num = (int) Math.floor(Math.random() * 2);
    if (num == 0) {
      this.coinFace = CoinFace.HEADS;
    } else {
      this.coinFace = CoinFace.TAILS;
    }
  }
  
  @Override
  public int getNumber() {
    return this.coinNumber;
  }
  
  @Override
  public CoinFace getFace() {
    return this.coinFace;
  }
  
  @Override
  public void flip() {
    if (coinFace == CoinFace.HEADS) {
      coinFace = CoinFace.TAILS;
    } else {
      coinFace = CoinFace.HEADS;
    }
  }
  
  @Override
  public boolean equals(Object coin) {
    if (coin == null || (coin != null && (coin.getClass() != getClass()))) {
      return false;
    }
    Coin coinCast = (Coin) coin;
    return equals(coinCast);
  }
  
  @Override
  public boolean equals(Coin coin) {
    return coinFace.equals(coin.getFace());
  }
  
  //TODO:
  @Override
  public int hashCode() {
    final int prime = 97;
    int result = 1;
    result = prime * result + ((this.coinFace == null) ? 0 : this.coinFace.hashCode());
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("Coin %s: %s", coinNumber, coinFaceToTitleCaseString());
  }
  
  private String coinFaceToTitleCaseString() {
    if (coinFace == CoinFace.HEADS) {
      return "Heads";
    } else {
      return "Tails";
    }
  }
}
