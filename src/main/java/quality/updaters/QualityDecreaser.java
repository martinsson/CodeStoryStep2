package quality.updaters;

import quality.QualityStore;


public class QualityDecreaser extends ResponsibilityCheckingUpdater {

   private final int amount;
   public static final int NO_BORDER = Integer.MAX_VALUE;

   public QualityDecreaser(int amount, int border) {
      super(border);
      this.amount = amount;
   }

   public QualityDecreaser(int amount) {
      this(amount, NO_BORDER);
   }

   @Override
   protected void doUpdate(QualityStore item) {
      item.decreaseQuality(amount);
   }
   
}