package fr.xebia.katas.gildedrose;

import java.util.Iterator;

import org.hamcrest.internal.ArrayIterator;

class BackstagePass extends Item {

   private static final int NOBORDER = Integer.MAX_VALUE;
   QualityUpdaterChain qualityUpdater = new QualityUpdaterChain(
         new QualitySetter(0, 0),
         new QualityIncreaser(3, 5),
         new QualityIncreaser(2, 10),
         new QualityIncreaser(1, 15),
         new QualityIncreaser(0, NOBORDER));
   
   public BackstagePass(int sellIn, int quality) {
      super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
   }
   
   @Override
   public void update() {
      sellIn--;
      qualityUpdater.update(this, sellIn);
   }
    
   static class QualityUpdaterChain {

      private final QualityUpdater[] qualityUpdaters;

      public QualityUpdaterChain(QualityUpdater...qualitySetters) {
         this.qualityUpdaters = qualitySetters;
      }

      public void update(Item item, int sellIn) {
         Iterator<Object> iterator = new ArrayIterator(qualityUpdaters);
         boolean keepOn = true;
         while (iterator.hasNext() && keepOn) {
            QualityUpdater updater = (QualityUpdater) iterator.next();
            keepOn = !updater.update(item, sellIn);
         }
         
      }
      
   }
}