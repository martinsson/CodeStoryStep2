package items;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import items.AgedBrie;
import items.BackstagePass;
import items.Item;
import items.Sulfuras;

import java.util.ArrayList;


import org.junit.Test;

public class InnTest {

    @Test
    public void qualityIncreasesByOne() throws Exception {
        int startquality = 10;
        Item freshItem = new Item(2, startquality);

        new Inn(asList(freshItem)).updateQuality();
        assertThat(freshItem.getQuality()).isEqualTo(startquality-1);
    }
    @Test
    public void qualityDegradesTwiceAsFastAfterTheDateHasPassed() throws Exception {
       int startquality = 10;
       Item freshItem = new Item(2, startquality);
       Item passedItem = new Item(0, startquality);
       
       new Inn(asList(freshItem, passedItem)).updateQuality();
       assertThat(startquality - freshItem.getQuality()).isEqualTo((startquality - passedItem.getQuality()) / 2);
    }
    @Test
    public void quality_is_never_negative() throws Exception {
        
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(10, 0));
        items.add((Item) new AgedBrie(2, 0));
        items.add(new Item(5, 0));
        items.add((Item) new Sulfuras(0));
        items.add((Item) new BackstagePass(15, 0));
        items.add(new Item(3, 0));
        Inn inn = new Inn(items);
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        for (Item item : items) {
            assertThat(item.getQuality()).isGreaterThanOrEqualTo(0);
        }
    }
    
   @Test
    public void brie_quality_increases_with_time() throws Exception {
        int startQuality = 20;
        Item brie = new AgedBrie(10, startQuality);
        new Inn(asList(brie)).updateQuality();
        assertThat(brie.getQuality()).isEqualTo(startQuality+1);
    }
   
   @Test
   public void brie_quality_increases_twice_as_fast_after_the_date_has_passed() throws Exception {
      int startQuality = 20;
      Item brie = new AgedBrie(1, startQuality);
      Inn inn = new Inn(asList(brie));
      inn.updateQuality();
      assertThat(brie.getQuality()).isEqualTo(startQuality+1);
      inn.updateQuality();
      assertThat(brie.getQuality()).isEqualTo(startQuality+3);
      inn.updateQuality();
      assertThat(brie.getQuality()).isEqualTo(startQuality+5);
   }
   
    @Test
    public void qualityNeverExceeds50() throws Exception {
        ArrayList<Item> items = new ArrayList<Item>();
        int maxQuality = 50;
        items.add(new Item(50, maxQuality));
        items.add((Item) new AgedBrie(50, maxQuality));
        items.add(new Item(50, maxQuality));
        items.add((Item) new BackstagePass(50, maxQuality));
        items.add(new Item(50, maxQuality));
        Inn inn = new Inn(items);
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        for (Item item : items) {
            assertThat(item.getQuality()).isLessThanOrEqualTo(maxQuality);
        }
    }
    @Test
    public void sulfuras_never_decreases_in_quality() throws Exception {
        int startQuality = 80;
        Item sulfuras = new Sulfuras(startQuality);
        Inn inn = new Inn(asList(sulfuras));
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        assertThat(sulfuras.getQuality()).isEqualTo(startQuality);
    }
    @Test
    public void backstage_passes_increases_by2_from_day_10_to_6_before_the_concert() throws Exception {
        int startQuality = 20;
        Item sulfuras = new BackstagePass(10, startQuality);
        Inn inn = new Inn(asList(sulfuras));
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        assertThat(sulfuras.getQuality()).isEqualTo(startQuality + 10);
    }
    @Test
    public void backstage_passes_increases_by3_from_day_5_to_0_before_the_concert() throws Exception {
        int startQuality = 20;
        Item sulfuras = new BackstagePass(5, startQuality);
        Inn inn = new Inn(asList(sulfuras));
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        assertThat(sulfuras.getQuality()).isEqualTo(startQuality + 15);
    }
    @Test
    public void backstage_passes_increases_by1_from_before_day_10_the_concert() throws Exception {
        int startQuality = 20;
        Item sulfuras = new BackstagePass(15, startQuality);
        Inn inn = new Inn(asList(sulfuras));
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        inn.updateQuality();
        assertThat(sulfuras.getQuality()).isEqualTo(startQuality + 5*1+2);
    }
    @Test
    public void backstage_passes_is_0_after_the_concert() throws Exception {
        int startQuality = 20;
        Item sulfuras = new BackstagePass(0, startQuality);
        Inn inn = new Inn(asList(sulfuras));
        inn.updateQuality();
        assertThat(sulfuras.getQuality()).isEqualTo(0);
    }
    



}
