package fr.xebia.katas.gildedrose;
import java.util.ArrayList;
import java.util.List;



public class Main {

   public static void main(String[] args) {
      System.out.println("OMGHAI!");
      List<Item> items = new ArrayList<Item>();
      items.add(new Item("+5 Dexterity Vest", 10, 20));
      items.add(new AgedBrie(2, 0));
      items.add(new Item("Elixir of the Mongoose", 5, 7));
      items.add(new Sulfuras(80, 0));
      items.add(new BackstagePass(15, 20));
      items.add(new Item("Conjured Mana Cake", 3, 6));
      for (Item currentItem : items) {
        currentItem.update();
      }
   }

}
