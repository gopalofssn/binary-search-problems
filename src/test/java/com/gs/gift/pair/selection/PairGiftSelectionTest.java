package com.gs.gift.pair.selection;

import static org.junit.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PairGiftSelectionTest {

  @DataProvider
  public PairGiftSelection[] pairGiftSelectionDataProvider() {
    return new PairGiftSelection[] {
                                    new PairGiftSelectionUsingLinear(),
                                    new PairGiftSelectionUsingBinarySearch()
                                    };
  }

  @Test(dataProvider = "pairGiftSelectionDataProvider")
  public void testValidScnerio1(PairGiftSelection pairGiftSelection) {
    String[][] itemAndPrice = {{"Hat", "15.00"}, {"Teddy Bear", "25.75"}, {"Speaker", "59.99"},
        {"Necklace", "129.95"}, {"Chair", "144.99"}, {"Kayak", "209.25"}, {"xbox", "295.95"}};

    assertArrayEquals(new String[]{"Teddy Bear", "Chair"},  pairGiftSelection.selection(itemAndPrice, 175.00f));

    assertArrayEquals(new String[] {"Hat", "Chair"},    pairGiftSelection.selection(itemAndPrice, 160.00f));

    assertArrayEquals(new String[]{"Necklace", "Chair"}, pairGiftSelection.selection(itemAndPrice, 275.00f));
  }

}
