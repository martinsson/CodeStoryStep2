package quality.updaters;

import quality.QualityStore;

public interface UpdaterChain {

   void update(QualityStore item);

}