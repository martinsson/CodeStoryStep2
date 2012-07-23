package fr.xebia.katas.gildedrose;


class QualitySetter extends ResponsibilityCheckingUpdater implements QualityUpdater {

   final int destinationQuality;
   public QualitySetter(int destinationQuality, int border) {
      super(border);
      this.destinationQuality = destinationQuality;
   }
   @Override
   protected void doUpdate(Item item) {
      item.setQuality(destinationQuality);
      
   }
}