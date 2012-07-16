package fr.xebia.katas.gildedrose;


import java.util.List;

public class Inn {
   private List<Item> items;

   public void updateQuality() {
      for (Item currentItem : items) {
         currentItem.update();
      }
   }


   public Inn(List<Item> initialItems) {
       items = initialItems;
   }

}
