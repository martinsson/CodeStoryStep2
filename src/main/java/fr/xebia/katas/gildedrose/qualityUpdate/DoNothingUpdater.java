package fr.xebia.katas.gildedrose.qualityUpdate;

import fr.xebia.katas.gildedrose.QualityStore;

public class DoNothingUpdater implements QualityUpdater {

   @Override
   public boolean update(QualityStore item, int sellIn) {
      return true;
   }

}