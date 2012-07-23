package fr.xebia.katas.gildedrose;

import java.util.Iterator;

import org.hamcrest.internal.ArrayIterator;

import fr.xebia.katas.gildedrose.qualityUpdate.QualityIncreaser;
import fr.xebia.katas.gildedrose.qualityUpdate.QualityRemover;
import fr.xebia.katas.gildedrose.qualityUpdate.QualityUpdater;
class BackstagePass extends Item {

   public class DoNothingUpdater implements QualityUpdater {

      @Override
      public boolean update(QualityStore item, int sellIn) {
         return true;
      }

   }

   private static final int NOT_USED = 0;
   QualityUpdaterChain qualityUpdater;
   
   public BackstagePass(int sellIn, int quality) {
      super(NOT_USED, quality);
      qualityUpdater = new QualityUpdaterChain(
            sellIn,
            new QualityRemover(0, 0),
            new QualityIncreaser(3, 5),
            new QualityIncreaser(2, 10),
            new QualityIncreaser(1, 15), 
            new DoNothingUpdater());
   }
   
   @Override
   public void update() {
      qualityUpdater.update(this);
   }
   
    
   static class QualityUpdaterChain {

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
}