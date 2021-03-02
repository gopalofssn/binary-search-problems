package com.gs.gift.pair.selection;

// Time : O(n)
public class PairGiftSelectionUsingLinear implements PairGiftSelection {

  public String[] selection(String[][] itemAndPrices, final float maxAmount) {

    String[] selectedGift = new String[0];
    float previouslyAmountUtlized = 0.00f;
    int left = 0;
    int right = itemAndPrices.length - 1;

    while (left < right ) {
      float leftItemPrice = Float.parseFloat(itemAndPrices[left][1]);
      if(leftItemPrice * 2 > maxAmount) {
        break;
      }
      
      float rightItemPrice = Float.parseFloat(itemAndPrices[right][1]);
      float amountUtlized = (leftItemPrice + rightItemPrice);

      if ( amountUtlized <= maxAmount && amountUtlized > previouslyAmountUtlized) {
        selectedGift = new String[] {itemAndPrices[left][0], itemAndPrices[right][0]};
        previouslyAmountUtlized = amountUtlized;
        left++;
      } else {
        right--;
      }


    }
    return selectedGift;
  }

}
