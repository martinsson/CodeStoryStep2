package fr.xebia.katas.gildedrose.qualityUpdate;

import fr.xebia.katas.gildedrose.QualityStore;


public class QualityRemover extends ResponsibilityCheckingUpdater implements QualityUpdater {

   final int destinationQuality;
   public QualityRemover(int destinationQuality, int border) {
      super(border);
      this.destinationQuality = destinationQuality;
   }
   @Override
   protected void doUpdate(QualityStore item) {
      item.removeAllQuality();
      
   }
}