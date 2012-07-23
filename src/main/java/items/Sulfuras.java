package items;


public class Sulfuras extends Item {

   public Sulfuras(int sellIn, int quality) {
      //TOOD sellIn has no meaning for Sulfras, it shouldnt be needed and 
      // we shouldnt even be able to ask it for sellIn 
        super(0, quality);
        qualityUpdater = new VoidUpdaterChain();
    }

}