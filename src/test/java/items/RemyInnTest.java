package items;

import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import items.AgedBrie;
import items.BackstagePass;
import items.Item;
import items.Sulfuras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RemyInnTest {

	private Random random = null;

	@Before
	public void setup()
	{
		 random = new Random(System.currentTimeMillis());
	}

    @Test
    public void quality_degrades_twice_as_fast_after_the_sell_date_has_passed() {
    	// Given
    	int startquality = 10;
        Item freshItem = new Item(2, startquality);
        Item passedItem = new Item(0, startquality);
        Inn inn = new Inn(asList(freshItem, passedItem));

        // When
        inn.updateQuality();
        int actualFreshItemQuality = startquality - freshItem.getQuality();
        int actualPassedItemQuality = startquality - passedItem.getQuality();

        // Then
        assertThat(actualFreshItemQuality).isEqualTo(actualPassedItemQuality / 2);
    }

    @Test
    public void quality_is_never_negative() {
        // Given
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(10, 0));
        items.add(new Item(2, 0));
        items.add(new Item(5, 0));
        items.add(new Item(0, 0));
        items.add((Item) new BackstagePass(15, 0));
        items.add(new Item(3, 0));
        Inn inn = new Inn(items);

        // When
        repeatUpdateQuality(inn, random.nextInt(10));


        // Then
        for (Item item : items) {
        	assertThat(item.getQuality()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    public void brie_quality_increases_with_time() {
    	//Given
        int startQuality = 20;
        Item brie = new AgedBrie(10, startQuality);
//        Item brie = new Item("Aged Brie", 10, startQuality);
        Inn inn = new Inn(asList(brie));

        // When
        inn.updateQuality();

        // Then
        assertThat(brie.getQuality()).isEqualTo(startQuality+1);
    }

    @Test
    public void quality_never_exceeds_50() {
    	// Given
        ArrayList<Item> items = new ArrayList<Item>();
        int maxQuality = 50;
        items.add(new Item(10, maxQuality));
        items.add(new Item(2, maxQuality));
        items.add(new Item(5, maxQuality));
        items.add((Item) new BackstagePass(15, maxQuality));
        items.add(new Item(3, maxQuality));
        items.add(new Item(0, 50));
        Inn inn = new Inn(items);

        // When
        repeatUpdateQuality(inn, random.nextInt(10));


        // Then
        for (Item item : items) {
            assertThat(item.getQuality()).isLessThanOrEqualTo(maxQuality);
        }
    }

    @Test
    public void sulfuras_never_decreases_in_quality() {
    	// Given
        int startQuality = 40;
        Item sulfuras = new Sulfuras(0, startQuality);
        Inn inn = new Inn(asList(sulfuras));

        // When
        repeatUpdateQuality(inn, random.nextInt(10));


        // Then
        assertThat(sulfuras.getQuality()).isGreaterThanOrEqualTo(startQuality);
    }

    @Test
    @Ignore
    public void sulfuras_never_has_to_be_sold() {
    	// Given
    	int startSellIn = 10;
      Item sulfuras = new Sulfuras(startSellIn, 0);

    	Inn inn = new Inn(asList(sulfuras));

    	// When
        repeatUpdateQuality(inn, random.nextInt(10));

    	// Then
//    	assertThat(sulfuras.getSellIn()).isEqualTo(startSellIn);
    }

	private void repeatUpdateQuality(Inn inn, int times) {
		for (int i = 0; i < times; i++) {
        	inn.updateQuality();
		}
	}

    @Test
    public void backstage_passes_increases_by2_from_day_10_to_6_before_the_concert() {
    	// Given
        int startQuality = 20;
        int sellIn = 10;
        Item backstage = new BackstagePass(sellIn, startQuality);
        Inn inn = new Inn(asList(backstage));



        // Then
        int startOfPeriod = sellIn;
        int endOfPeriod = 5;
        List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(startOfPeriod, endOfPeriod, inn, backstage);

        // When
        int qualityPerDayIncrease = 2;
        List<Integer> expectedBackstageQualityInThePeriod =inclusiveRange(22, 30, qualityPerDayIncrease);
		assertThat(actualBackstageQualityInThePeriod).isEqualTo(expectedBackstageQualityInThePeriod);
    }

    @Test
    public void backstage_passes_increases_by_3_from_day_5_to_0_before_the_concert() {
    	// Given
    	int startQuality = 20;
    	int sellIn = 5;
        Item backstage = new BackstagePass(sellIn, startQuality);
        Inn inn = new Inn(asList(backstage));

        // Then
        int startOfPeriod = sellIn;
        int endOfPeriod = 0;
        List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(startOfPeriod, endOfPeriod, inn, backstage);

        // When
        int qualityPerDayIncrease = 3;
        List<Integer> expectedBackstageQualityInThePeriod =inclusiveRange(23, 35, qualityPerDayIncrease);
		assertThat(actualBackstageQualityInThePeriod).isEqualTo(expectedBackstageQualityInThePeriod);
    }




    @Test
    public void backstage_passes_increases_by1_from_before_day_10_the_concert() {
       	// Given
    	int startQuality = 20;
    	int sellIn = 15;
        Item backstage = new BackstagePass(sellIn, startQuality);
        Inn inn = new Inn(asList(backstage));

        // Then
        int startOfPeriod = sellIn;
        int endOfPeriod = 10;
        List<Integer> actualBackstageQualityInThePeriod = backstageQualityInThePeriod(startOfPeriod, endOfPeriod, inn, backstage);

        // When
        int qualityPerDayIncrease = 1;
        List<Integer> expectedBackstageQualityInThePeriod =inclusiveRange(21, 25, qualityPerDayIncrease);
		assertThat(actualBackstageQualityInThePeriod).isEqualTo(expectedBackstageQualityInThePeriod);
    }

    @Test
    public void backstage_passes_is_0_after_the_concert() {
    	// Given
        int startQuality = 20;
        int sellIn = 0;
        Item sulfuras = new BackstagePass(sellIn, startQuality);
        Inn inn = new Inn(asList(sulfuras));

        // When
        inn.updateQuality();

        // Then
        assertThat(sulfuras.getQuality()).isEqualTo(0);
    }

    @Test
    @Ignore
    // TODO not yet implemented
    public void conjured_degrade_in_quality_twice_as_fast_as_normal_items() {
    	// Given
    	int startQuality = 6;
    	Item conjured = new Item(3, startQuality);
    	Inn inn = new Inn(asList(conjured));

    	// When
    	inn.updateQuality();

    	// Then
    	assertThat(conjured.getQuality()).isEqualTo(4);
    }

    private List<Integer> inclusiveRange(int min, int max, int step) {
    	List<Integer> inclusiveRange = new LinkedList<Integer>();
    	for (int i = min; i <= max ; i=i+step)
    		inclusiveRange.add(i);

		return inclusiveRange;
	}

	private List<Integer> backstageQualityInThePeriod(int startOfPeriod, int endOfPeriod, Inn inn, Item backstage) {
    	List<Integer> qualityInThePeriod = new LinkedList<Integer>();

    	for (int day= startOfPeriod; day > endOfPeriod; --day) {
        	inn.updateQuality();
        	qualityInThePeriod.add(backstage.getQuality());
    	}

		return qualityInThePeriod;
	}
}
