package fr.xebia.katas.gildedrose;

public class Item {
   protected int sellIn;
   protected int quality;

   public Item(String name, int sellIn, int quality) {
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

   protected void increaseQuality(int amount) {
      quality +=amount;
      if (getQuality() > 50)
         quality = 50;
   }
   
   protected void decreaseQuality(int amount) {
      quality -=amount;
      if (getQuality() < 0) 
         quality = 0;
   }
   
   protected void setSellIn(int sellIn) {
      this.sellIn = sellIn;
   }
   
   protected void setQuality(int quality) {
      this.quality = quality;
   }
   
   protected int getSellIn() {
      return sellIn;
   }
   
   protected int getQuality() {
      return quality;
   }
   
}
