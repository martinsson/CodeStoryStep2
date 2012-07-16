package fr.xebia.katas.gildedrose;

class AgedBrie extends Item {

   public AgedBrie(int sellIn, int quality) {
      super("Aged Brie", sellIn, quality);
   }
   @Override
   protected void update() {
      if (getQuality() < 50) {
         quality++;
      }
      sellIn--;
      if (getSellIn() < 0) {
         if (getQuality() < 50) {
            quality++;
         }
      }
   }
   public static Item anAgedBrie(int sellIn, int quality) {
      return new AgedBrie(sellIn, quality);
   }
}