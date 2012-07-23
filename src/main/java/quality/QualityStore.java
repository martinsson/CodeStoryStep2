package quality;

public interface QualityStore {

   void increaseQuality(int amount);

   void decreaseQuality(int amount);

   void removeAllQuality();

}