package main;
import items.AgedBrie;
import items.BackstagePass;
import items.Item;
import items.Sulfuras;

import java.util.ArrayList;
import java.util.List;



public class Main {

   public static void main(String[] args) {
      System.out.println("OMGHAI!");
      List<Item> items = new ArrayList<Item>();
      items.add(new Item(10, 20));
      items.add(new AgedBrie(2, 0));
      items.add(new Item(5, 7));
      items.add(new Sulfuras(0));
      items.add(new BackstagePass(15, 20));
      items.add(new Item(3, 6));
      for (Item currentItem : items) {
        currentItem.update();
      }
   }

}
