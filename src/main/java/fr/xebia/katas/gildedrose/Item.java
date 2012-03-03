package fr.xebia.katas.gildedrose;

public class Item {
   private String name;
   protected int sellIn;
   protected int quality;

   public Item(String name, int sellIn, int quality) {
      this.name = name;
      this.quality = quality;
      this.sellIn = sellIn;
   }

   public void setSellIn(int sellIn) {
      this.sellIn = sellIn;
   }

   public void setQuality(int quality) {
      this.quality = quality;
   }

   public String getName() {
      return name;
   }

   public int getSellIn() {
      return sellIn;
   }

   public int getQuality() {
      return quality;
   }

   protected void update() {
    
    if (!getName().equals("Aged Brie")) {
        if (getQuality() > 0) {
           quality--;
        }
     } else {
        if (getQuality() < 50) {
           quality++;
        }
     }
    sellIn--;

     if (getSellIn() < 0) {
        if (!getName().equals("Aged Brie")) {
              if (getQuality() > 0) {
                 quality--;
              }
        } else {
           if (getQuality() < 50) {
              quality++;
           }
        }
     }
}

   protected void addQuality(int amount) {
      if (getQuality() < 50) {
         quality +=amount;
      }
   }
}
