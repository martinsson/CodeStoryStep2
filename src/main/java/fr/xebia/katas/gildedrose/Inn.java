package fr.xebia.katas.gildedrose;

import static fr.xebia.katas.gildedrose.Sulfuras.aSulfuras;

import java.util.ArrayList;
import java.util.List;

public class Inn {
   private List<Item> items;

   public Inn(List<Item> initialItems) {
       items = initialItems;
   }

   public void updateQuality() {
      for (Item currentItem : items) {
        currentItem.update();
      }
   }

    public static void main(String[] args) {
      System.out.println("OMGHAI!");
      List<Item> items = new ArrayList<Item>();
      items.add(new Item("+5 Dexterity Vest", 10, 20));
      items.add(new Item("Aged Brie", 2, 0));
      items.add(new Item("Elixir of the Mongoose", 5, 7));
      items.add(aSulfuras(0, 80));
      items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
      items.add(new Item("Conjured Mana Cake", 3, 6));
      new Inn(items).updateQuality();
   }

}
