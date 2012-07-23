package items;

import quality.QualityStore;
import quality.UpdaterChain;
import quality.updaters.QualityDecreaser;
import quality.updaters.chains.QualityUpdaterChain;

public class Item implements QualityStore {
   private static final int MIN_QUALITY = 0;
   private static final int MAX_QUALITY = 50;
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
      if (qualityIsToBig())
         quality = MAX_QUALITY;
   }

   public void decreaseQuality(int amount) {
      quality -=amount;
      if (qualityIsTooLow()) 
         quality = MIN_QUALITY;
   }
   
   private boolean qualityIsToBig() {
      return quality() > MAX_QUALITY;
   }
   
   private boolean qualityIsTooLow() {
      return quality() < MIN_QUALITY;
   }
   
   public void removeAllQuality() {
      this.quality = MIN_QUALITY;
   }
   
   protected int quality() {
      return quality;
   }
   
}
