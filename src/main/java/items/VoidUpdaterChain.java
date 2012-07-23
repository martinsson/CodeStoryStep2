package items;

import quality.QualityStore;
import quality.updaters.UpdaterChain;

public class VoidUpdaterChain implements UpdaterChain {

   @Override
   public void update(QualityStore item) {
      // well just nothing
   }

}
