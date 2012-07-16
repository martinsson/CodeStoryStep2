package fr.xebia.katas.gildedrose;

import java.util.ArrayList;

import org.junit.Test;

import static fr.xebia.katas.gildedrose.BackstagePass.aBackstagePass;
import static fr.xebia.katas.gildedrose.Sulfuras.aSulfuras;
import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

public class InnTest {

    @Test
    public void qualityDegradesTwiceAsFastAfterTheDateHasPassed() throws Exception {
        int startquality = 10;
        Item freshItem = new Item("toto", 2, startquality);
        Item passedItem = new Item("toto", 0, startquality);

        new Inn(asList(freshItem, passedItem)).updateQuality();
        assertThat(startquality - freshItem.getQuality()).isEqualTo((startquality - passedItem.getQuality()) / 2);
    }
    @Test
    public void quality_is_never_negative() throws Exception {
        
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 0));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 0));
        items.add(aSulfuras(0, 0));
        items.add(aBackstagePass(15, 0));
        items.add(new Item("Conjured Mana Cake", 3, 0));
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
        Item brie = AgedBrie.anAgedBrie(10, startQuality);
        new Inn(asList(brie)).updateQuality();
        assertThat(brie.getQuality()).isEqualTo(startQuality+1);
    }
    @Test
    public void qualityNeverExceeds50() throws Exception {
        ArrayList<Item> items = new ArrayList<Item>();
        int maxQuality = 50;
        items.add(new Item("+5 Dexterity Vest", 10, maxQuality));
        items.add(new Item("Aged Brie", 2, maxQuality));
        items.add(new Item("Elixir of the Mongoose", 5, maxQuality));
        items.add(aBackstagePass( 15, maxQuality));
        items.add(new Item("Conjured Mana Cake", 3, maxQuality));
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
        Item sulfuras = aSulfuras(startQuality, 0);
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
        Item sulfuras = aBackstagePass( 10, startQuality);
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
        Item sulfuras = aBackstagePass( 5, startQuality);
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
        Item sulfuras = aBackstagePass( 15, startQuality);
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
        Item sulfuras = aBackstagePass( 0, startQuality);
        Inn inn = new Inn(asList(sulfuras));
        inn.updateQuality();
        assertThat(sulfuras.getQuality()).isEqualTo(0);
    }
    



}
