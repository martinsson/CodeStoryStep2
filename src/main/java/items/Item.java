package items;

import quality.QualityStore;
import quality.updaters.QualityDecreaser;
import quality.updaters.QualityUpdaterChain;

public class Item implements QualityStore {
   protected int sellIn;
   protected int quality;
   protected QualityUpdaterChain qualityUpdater;

   public Item(int sellIn, int quality) {
      this.quality = quality;
      this.sellIn = sellIn;
      qualityUpdater = new QualityUpdaterChain(sellIn, 
            new QualityDecreaser(2, 0), 
            new QualityDecreaser(1));
   }
   public void update() {
      qualityUpdater.update(this);
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
