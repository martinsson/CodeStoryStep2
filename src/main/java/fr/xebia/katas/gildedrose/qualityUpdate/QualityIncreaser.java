package fr.xebia.katas.gildedrose.qualityUpdate;

import fr.xebia.katas.gildedrose.Item;


public class QualityIncreaser extends ResponsibilityCheckingUpdater {

   private final int amount;

   public QualityIncreaser(int amount, int border) {
      super(border);
      this.amount = amount;
   }

   @Override
   protected void doUpdate(Item item) {
      item.increaseQuality(amount);
   }
   
}