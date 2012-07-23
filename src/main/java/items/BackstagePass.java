package items;

import quality.updaters.DoNothingUpdater;
import quality.updaters.QualityIncreaser;
import quality.updaters.QualityRemover;
import quality.updaters.QualityUpdaterChain;

public class BackstagePass extends Item {

   public BackstagePass(int sellIn, int quality) {
      super(new QualityUpdaterChain(
               sellIn,
               new QualityRemover(0, 0),
               new QualityIncreaser(3, 5),
               new QualityIncreaser(2, 10),
               new QualityIncreaser(1, 15), 
               new DoNothingUpdater()), 
           quality);
   }
   
}