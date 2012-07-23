package fr.xebia.katas.gildedrose.qualityUpdate;

import fr.xebia.katas.gildedrose.Item;

public abstract class ResponsibilityCheckingUpdater implements QualityUpdater {

   protected final int border;

   public ResponsibilityCheckingUpdater(int border) {
      this.border = border;
   }

   @Override
   public boolean update(Item item, int sellIn) {
      if (sellIn >= border) 
         return false;
      doUpdate(item);
      return true;
   }

   protected abstract void doUpdate(Item item);

}