package quality.updaters;

import quality.QualityStore;
import quality.QualityUpdater;

public class DoNothingUpdater implements QualityUpdater {

   @Override
   public boolean update(QualityStore item, int sellIn) {
      return true;
   }

}