package fr.xebia.katas.gildedrose;

class AgedBrie extends Item {

   public AgedBrie(int sellIn, int quality) {
      super("Aged Brie", sellIn, quality);
   }
   @Override
   protected void update() {
      sellIn--;
      if (getSellIn() < 0) {
         addQuality(2);
      } else {
         addQuality(1);
      }
   }
   public static Item anAgedBrie(int sellIn, int quality) {
      return new AgedBrie(sellIn, quality);
   }
}