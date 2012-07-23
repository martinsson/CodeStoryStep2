package quality.updaters;

import quality.QualityStore;
import quality.QualityUpdater;


public class QualityRemover extends ResponsibilityCheckingUpdater implements QualityUpdater {

   public QualityRemover(int border) {
      super(border);
   }
   
   @Override
   protected void doUpdate(QualityStore item) {
      item.removeAllQuality();
      
   }
}