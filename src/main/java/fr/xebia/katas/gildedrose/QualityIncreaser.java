package fr.xebia.katas.gildedrose;


class QualityIncreaser extends ResponsibilityCheckingUpdater {

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