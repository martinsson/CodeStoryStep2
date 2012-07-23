package items;

import static quality.updaters.QualityIncreaser.NO_BORDER;
import quality.updaters.QualityIncreaser;
import quality.updaters.QualityUpdaterChain;

public class AgedBrie extends Item {

   private QualityUpdaterChain qualityUpdater;
   public AgedBrie(int sellIn, int quality) {
      super(sellIn, quality);
      qualityUpdater = new QualityUpdaterChain(sellIn, 
                                      new QualityIncreaser(2, 0), 
                                      new QualityIncreaser(1, NO_BORDER));
      
   }
   @Override
   public void update() {
      qualityUpdater.update(this);
   }
}