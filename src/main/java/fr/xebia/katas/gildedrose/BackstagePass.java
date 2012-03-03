package fr.xebia.katas.gildedrose;

class BackstagePass extends Item {

   public BackstagePass(int sellIn, int quality) {
      super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
   }
   
   @Override
   protected void update() {
      if (getSellIn() < 1) {
         quality = 0;
      } else if (getSellIn() < 6) {
            addQuality(3);
      } else if (getSellIn() < 11) {
            addQuality(2);
      } else if (getSellIn() < 16) {
            addQuality(1);
      }
      sellIn--;
   }
    
   public static Item aBackstagePass(int sellIn, int quality) {
      return new BackstagePass(sellIn, quality);
   }

}