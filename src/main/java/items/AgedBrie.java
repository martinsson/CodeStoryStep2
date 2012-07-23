package items;

import quality.updaters.QualityIncreaser;
import quality.updaters.QualityUpdaterChain;

public class AgedBrie extends Item {

   public AgedBrie(int sellIn, int quality) {
      super(0, quality);
      qualityUpdater = new QualityUpdaterChain(sellIn, 
                                      new QualityIncreaser(2, 0), 
                                      new QualityIncreaser(1));
      
   }
}