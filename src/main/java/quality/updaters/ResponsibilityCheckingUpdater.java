package quality.updaters;

import quality.QualityStore;
import quality.QualityUpdater;

public abstract class ResponsibilityCheckingUpdater implements QualityUpdater {

   protected final int border;

   public ResponsibilityCheckingUpdater(int border) {
      this.border = border;
   }

   @Override
   public boolean update(QualityStore item, int sellIn) {
      if (sellIn >= border) 
         return false;
      doUpdate(item);
      return true;
   }

   protected abstract void doUpdate(QualityStore item);

}