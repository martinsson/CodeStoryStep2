package fr.xebia.katas.gildedrose;

class Sulfuras extends Item {

    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    protected void update() {}

    public static Item aSulfuras(int startQuality, int sellIn) {
        return new Sulfuras(sellIn, startQuality);
    }
    
}