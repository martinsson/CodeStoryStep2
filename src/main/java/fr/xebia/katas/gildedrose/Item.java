package fr.xebia.katas.gildedrose;

public class Item implements QualityStore {
   protected int sellIn;
   protected int quality;

   public Item(int sellIn, int quality) {
      this.quality = quality;
      this.sellIn = sellIn;
   }
   public void update() {
      sellIn--;
      if (getSellIn() < 0) {
         decreaseQuality(2);
      } else {
         decreaseQuality(1);
      }
}

   public void increaseQuality(int amount) {
      quality +=amount;
      if (getQuality() > 50)
         quality = 50;
   }
   
   public void decreaseQuality(int amount) {
      quality -=amount;
      if (getQuality() < 0) 
         quality = 0;
   }
   
   public void removeAllQuality() {
      this.quality = 0;
   }
   
   protected int getSellIn() {
      return sellIn;
   }
   
   protected int getQuality() {
      return quality;
   }
   
}
