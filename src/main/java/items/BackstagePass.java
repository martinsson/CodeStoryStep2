package items;

import quality.updaters.DoNothingUpdater;
import quality.updaters.QualityIncreaser;
import quality.updaters.QualityRemover;
import quality.updaters.QualityUpdaterChain;

public class BackstagePass extends Item {

   private static final int NOT_USED = 0;
   QualityUpdaterChain qualityUpdater;
   
   public BackstagePass(int sellIn, int quality) {
      super(NOT_USED, quality);
      qualityUpdater = new QualityUpdaterChain(
            sellIn,
            new QualityRemover(0, 0),
            new QualityIncreaser(3, 5),
            new QualityIncreaser(2, 10),
            new QualityIncreaser(1, 15), 
            new DoNothingUpdater());
   }
   
   @Override
   public void update() {
      qualityUpdater.update(this);
   }
}