package fr.xebia.katas.gildedrose;

class BackstagePass extends Item {

   public BackstagePass(int sellIn, int quality) {
      super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
   }
   
   @Override
   public void update() {
      sellIn--;
      QualityUpdater qualityUpdater = null;
      if (getSellIn() < 0) {
         qualityUpdater = new QualitySetter(0);
      } else if (getSellIn() < 5) {
         qualityUpdater = new QualityIncreaser(3);
      } else if (getSellIn() < 10) {
         qualityUpdater = new QualityIncreaser(2);
      } else if (getSellIn() < 15) {
         qualityUpdater = new QualityIncreaser(1);
      } else {
         qualityUpdater = new QualityIncreaser(0);
      }
      qualityUpdater.update(this);
   }
    
   public static Item aBackstagePass(int sellIn, int quality) {
      return new BackstagePass(sellIn, quality);
   }

   interface QualityUpdater {
      void update(Item item);
   }
   static class QualitySetter implements QualityUpdater {

      private final int destinationQuality;

      public QualitySetter(int destinationQuality) {
         this.destinationQuality = destinationQuality;
      }

      @Override
      public void update(Item item) {
         item.setQuality(destinationQuality);
      }
   }
   static class QualityIncreaser implements QualityUpdater {

      private final int amount;

      public QualityIncreaser(int amount) {
         this.amount = amount;
      }

      @Override
      public void update(Item item) {
         item.increaseQuality(amount);
      }
      
   }
}