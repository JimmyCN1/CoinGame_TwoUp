package view;

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
  private static final Logger logger = Logger.getLogger(GameEngineCallbackImpl.class.getName());
  
  public GameEngineCallbackImpl() {
    // NOTE need to also set the console to FINE in %JRE_HOME%\lib\logging.properties
    logger.setLevel(Level.FINE);
  }
  
  @Override
  public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {
    // intermediate results logged at Level.FINE
    logger.log(Level.FINE, String.format("%s %s", player.getPlayerName(), coinFlipToString(coin)));
    System.out.println(String.format("%s %s", player.getPlayerName(), coinFlipToString(coin)));
    // TODO: complete this method to log intermediate results
  }
  
  @Override
  public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
    logger.log(Level.FINE, String.format("Spinner %s", coinFlipToString(coin)));
    System.out.println(String.format("Spinner %s", coinFlipToString(coin)));
  }
  
  @Override
  public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
    // final results logged at Level.INFO
    logger.log(Level.INFO, String.format("%s, final result=%s, %s", player.getPlayerName(),
            coinPair.getCoin1().toString(), coinPair.getCoin2().toString()));
    System.out.println(String.format("%s, final result=%s, %s", player.getPlayerName(),
            coinPair.getCoin1().toString(), coinPair.getCoin2().toString()));
    // TODO: complete this method to log results
  }
  
  @Override
  public void spinnerResult(CoinPair coinPair, GameEngine engine) {
    logger.log(Level.INFO, String.format("Spinner, final result=%s\n",
            coinPair.toString()));
    System.out.println(String.format("Spinner, final result=%s\n",
            coinPair.toString()));
    logger.log(Level.INFO, String.format("Final Player Results\n%s", finalPlayerResultsToString(engine)));
    System.out.println(String.format("Final Player Results\n%s", finalPlayerResultsToString(engine)));
    // TODO: complete this method to log intermediate results
  }
  
  // overloaded method to log final results of players
//  private void spinnerResult(GameEngine gameEngine) {
//    logger.log(Level.INFO, String.format("%sINFO: Final Player Results\n%s",
//            timeClassMethodToString(), finalPlayerResultsToString(gameEngine)));
//  }
  
  // returns header string of each log method
//  private String timeClassMethodToString() {
//    // get name of caller method
//    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//    String callerMethod = stackTraceElements[1].getMethodName();
//    return String.format("%s %s\n%s\n",
//            this.dateTimeString, getClass().getName(), callerMethod);
//  }
  
  // returns string of a coin flip
  private String coinFlipToString(Coin coin) {
    return String.format("coin %s flipped to %s", coin.getNumber(), coin.getFace());
  }
  
  // returns string of final results for all players
  private String finalPlayerResultsToString(GameEngine gameEngine) {
    String finalPlayerResults = "";
    for (Player player : gameEngine.getAllPlayers()) {
      finalPlayerResults += player.toString();
    }
    return finalPlayerResults;
  }
}
