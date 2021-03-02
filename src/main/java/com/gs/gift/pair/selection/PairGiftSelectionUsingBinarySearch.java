package com.gs.gift.pair.selection;


public class PairGiftSelectionUsingBinarySearch implements PairGiftSelection {

  public String[] selection(String[][] itemAndPrices, final float maxAmount) {
    
    float previouslyAmountUtlized = 0.00f;
    String[] selectedItems = new String[2];
 
    for(int index = 0; index < itemAndPrices.length; index++) {
     
      float firstItemprice = Float.parseFloat(itemAndPrices[index][1].trim());
      if(firstItemprice * 2 > maxAmount) {
        System.out.println("break p1 1" );
        break;
      }
      
      String[] pair = pairSelection(itemAndPrices,  index + 1, (maxAmount - firstItemprice));
      
      if(pair.length == 0){
        System.out.println("break p1 2" );
        break;
      }
      
      float secondItemPrice = Float.parseFloat(pair[1].trim());
      float amountUtlized = firstItemprice + secondItemPrice;
      if(previouslyAmountUtlized < amountUtlized) {
        selectedItems = new String[] {itemAndPrices[index][0], pair[0]};
        previouslyAmountUtlized = amountUtlized;
      }
    }
    System.out.println(selectedItems[0] + selectedItems[1]);
    return selectedItems;
  }

  private String[] pairSelection(String[][] itemAndPrices, int left, final float expectedAmount) { 
    final int LEN = itemAndPrices.length;
    int right = itemAndPrices.length - 1;
    
    while(left <= right) {
      int mid = left + ((right - left) / 2);
      String[] midItemPrice = itemAndPrices[mid];
      float  price  = Float.parseFloat(midItemPrice[1].trim());
      float  diff = expectedAmount - price; // 10 - 2 = 8
      if( diff >= 0 && mid != LEN - 1  &&  ( expectedAmount - Float.parseFloat(itemAndPrices[mid + 1][1].trim()) ) < 0) {
         return midItemPrice;
      }
      
      if(diff > 0) {
         left = mid + 1;
      }else {
        right = mid - 1;
      }
      
    }
    
    return new String[]{};
  }
  
}
