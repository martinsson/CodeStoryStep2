package fr.xebia.katas.gildedrose.qualityUpdate;

import fr.xebia.katas.gildedrose.Item;

public interface QualityUpdater {
   boolean update(Item item, int sellIn);
}