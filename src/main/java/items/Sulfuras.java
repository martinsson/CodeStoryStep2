package items;

import quality.updaters.DoNothingUpdater;
import quality.updaters.QualityUpdaterChain;

public class Sulfuras extends Item {

   public Sulfuras(int sellIn, int quality) {
        super(sellIn, quality);
        qualityUpdater = new QualityUpdaterChain(sellIn, 
              new DoNothingUpdater());
    }

}