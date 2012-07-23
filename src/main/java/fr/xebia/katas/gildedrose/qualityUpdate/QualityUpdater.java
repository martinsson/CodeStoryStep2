package fr.xebia.katas.gildedrose.qualityUpdate;

import fr.xebia.katas.gildedrose.QualityStore;

public interface QualityUpdater {
   boolean update(QualityStore item, int sellIn);
}