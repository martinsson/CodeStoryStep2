package quality.updaters.chains;

import quality.QualityStore;
import quality.UpdaterChain;

public class VoidUpdaterChain implements UpdaterChain {

   @Override
   public void update(QualityStore item) {
      // well just nothing
   }

}
