package quality.updaters;

import quality.QualityStore;


public class QualityIncreaser extends ResponsibilityCheckingUpdater {

   private final int amount;
   public static final int NO_BORDER = Integer.MAX_VALUE;

   public QualityIncreaser(int amount, int border) {
      super(border);
      this.amount = amount;
   }

   public QualityIncreaser(int amount) {
      this(amount, NO_BORDER);
   }

   @Override
   protected void doUpdate(QualityStore item) {
      item.increaseQuality(amount);
   }
   
}