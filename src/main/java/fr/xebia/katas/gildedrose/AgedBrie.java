package fr.xebia.katas.gildedrose;

class AgedBrie extends Item {

   public AgedBrie(int sellIn, int quality) {
      super("Aged Brie", sellIn, quality);
   }
   @Override
   public void update() {
      sellIn--;
      if (getSellIn() < 0) {
         increaseQuality(2);
      } else {
         increaseQuality(1);
      }
   }
}