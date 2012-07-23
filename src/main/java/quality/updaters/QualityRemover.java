package quality.updaters;

import quality.QualityStore;
import quality.QualityUpdater;


public class QualityRemover extends ResponsibilityCheckingUpdater implements QualityUpdater {

   final int destinationQuality;
   public QualityRemover(int destinationQuality, int border) {
      super(border);
      this.destinationQuality = destinationQuality;
   }
   @Override
   protected void doUpdate(QualityStore item) {
      item.removeAllQuality();
      
   }
}