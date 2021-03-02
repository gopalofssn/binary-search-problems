package com.gs.gift.pair.selection;

/**
 * Given a input in  sorted order, pick 2 gift and utilize max amount
 * @author Gopal Selvaraj
 *
 *Input
      Hat, 15.00
      Teddy Bear, 25.75
      Speaker, 59.99
      Necklace, 129.95
      Chair, 145.99
      Kayak, 209.25
      xbox, 295.95
      
      Amount to use : 165$
     Output : Chair & Teddy Bear
     
     Space : O(1)
     Time : n log n
 */
public interface PairGiftSelection {

  public String[] selection(String[][] itemAndPrices, final float maxAmount);
  
}
