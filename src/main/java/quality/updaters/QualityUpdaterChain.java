package quality.updaters;


import java.util.Iterator;

import org.hamcrest.internal.ArrayIterator;

import quality.QualityStore;
import quality.QualityUpdater;


public class QualityUpdaterChain {

   private final QualityUpdater[] qualityUpdaters;
   private int sellIn;

   public QualityUpdaterChain(int sellIn, QualityUpdater...qualitySetters) {
      this.sellIn = sellIn;
      this.qualityUpdaters = qualitySetters;
   }

   public void update(QualityStore item) {
      sellIn--;
      Iterator<Object> iterator = new ArrayIterator(qualityUpdaters);
      boolean keepOn = true;
      while (iterator.hasNext() && keepOn) {
         QualityUpdater updater = (QualityUpdater) iterator.next();
         keepOn = !updater.update(item, sellIn);
      }
      
   }
   
}