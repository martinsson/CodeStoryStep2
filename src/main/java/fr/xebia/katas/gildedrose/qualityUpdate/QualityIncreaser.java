package fr.xebia.katas.gildedrose.qualityUpdate;

import fr.xebia.katas.gildedrose.QualityStore;


public class QualityIncreaser extends ResponsibilityCheckingUpdater {

   private final int amount;

   public QualityIncreaser(int amount, int border) {
      super(border);
      this.amount = amount;
   }

   @Override
   protected void doUpdate(QualityStore item) {
      item.increaseQuality(amount);
   }
   
}