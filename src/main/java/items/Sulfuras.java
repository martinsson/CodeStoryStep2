package items;

import quality.updaters.chains.VoidUpdaterChain;


public class Sulfuras extends Item {

   public Sulfuras(int quality) {
        super(new VoidUpdaterChain(), quality);
    }

}