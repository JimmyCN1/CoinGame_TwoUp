package model;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin {
  private int coinNumber;
  private CoinFace coinFace;
  
  public CoinImpl(int coinNumber) {
    this.coinNumber = coinNumber;
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
    if (this.coinFace == CoinFace.HEADS) {
      this.coinFace = CoinFace.TAILS;
    } else {
      this.coinFace = CoinFace.HEADS;
    }
  }
  
  @Override
  public boolean equals(Object coin) {
    return equals(coin);
  }
  
  @Override
  public boolean equals(Coin coin) {
    return this.coinFace == coin.getFace();
  }
  
  @Override
  public String toString() {
    return String.format("Coin %s: %s", this.coinNumber, coinFaceToTitleCaseString());
  }
  
  private String coinFaceToTitleCaseString() {
    if (this.coinFace == CoinFace.HEADS) {
      return "Heads";
    } else {
      return "Tails";
    }
  }
}
