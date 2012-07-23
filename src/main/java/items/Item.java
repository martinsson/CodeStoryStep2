package items;

import quality.QualityStore;
import quality.UpdaterChain;
import quality.updaters.QualityDecreaser;
import quality.updaters.chains.QualityUpdaterChain;

public class Item implements QualityStore {
   private int quality;
   private UpdaterChain updaterChain;

   public Item(int sellIn, int quality) {
      this(new QualityUpdaterChain(sellIn, 
               new QualityDecreaser(2, 0), 
               new QualityDecreaser(1)), 
           quality);
   }
   
   public Item(UpdaterChain updaterChain, int quality) {
      this.updaterChain = updaterChain;
      this.quality = quality;
   }
   public void update() {
      updaterChain.update(this);
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
   
   protected int getQuality() {
      return quality;
   }
   
}
