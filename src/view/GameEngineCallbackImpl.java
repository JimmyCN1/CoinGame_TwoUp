package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * Skeleton implementation of GameEngineCallback showing Java logging behaviour
 *
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
  private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());
  private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("L dd, yyyy HH:mm:ss");
  private LocalDateTime dateTime;
  private String dateTimeString;
  
  public GameEngineCallbackImpl() {
    // NOTE need to also set the console to FINE in %JRE_HOME%\lib\logging.properties
    logger.setLevel(Level.FINE);
    this.dateTime = LocalDateTime.now();
    this.dateTimeString = dateTime.format(dateTimeFormatter);
  }
  
  @Override
  public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {
    //TODO: alternate implementation in timeClassMethodToStringMethod
//    String nameOfThisMethod = getClass().getEnclosingMethod().getName();
    // intermediate results logged at Level.FINE
    logger.log(Level.FINE, String.format("%sFINE: %s %s\n",
            timeClassMethodToString(), player.getPlayerName(), coinFlipToString(coin)));
    // TODO: complete this method to log intermediate results
  }
  
  @Override
  public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
    logger.log(Level.FINE, String.format("%sFINE: Spinner %s\n",
            timeClassMethodToString(), coinFlipToString(coin)));
  }
  
  @Override
  public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
    // final results logged at Level.INFO
    logger.log(Level.INFO, String.format("%sINFO: %s, final result=%s, %s",
            timeClassMethodToString(), player.getPlayerName(),
            coinPair.getCoin1().toString(), coinPair.getCoin2().toString()));
    // TODO: complete this method to log results
  }
  
  @Override
  public void spinnerResult(CoinPair coinPair, GameEngine engine) {
    logger.log(Level.INFO, String.format("%sINFO: Spinner, final result=%s, %s",
            timeClassMethodToString(), coinPair.getCoin1().toString(), coinPair.getCoin2().toString()));
    // TODO: complete this method to log intermediate results
  }
  
  public void spinnerResult(GameEngine gameEngine) {
    logger.log(Level.INFO, String.format("%sINFO: Final Player Results\n%s",
            timeClassMethodToString(), finalPlayerResultsToString(gameEngine)));
  }
  
  private String timeClassMethodToString() {
    // get name of caller method
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
    String callerMethod = stackTraceElements[1].getMethodName();
    return String.format("%s %s\n%s\n",
            this.dateTimeString, getClass().getName(), callerMethod);
  }
  
  private String coinFlipToString(Coin coin) {
    return String.format("coin %s flipped to %s", coin.getNumber(), coin.getFace());
  }
  
  private String finalPlayerResultsToString(GameEngine gameEngine) {
    String finalPlayerResults = "";
    for (Player player : gameEngine.getAllPlayers()) {
      finalPlayerResults += player.toString();
    }
    return finalPlayerResults;
  }
}
