/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

class DrivableTrader extends Trader {

    private int money;

    private List<Drivable> inventory;

    private List<Drivable> wishlist;

    public DrivableTrader(int money, List<Drivable> inv, List<Drivable> wish) {
        super(money);
        this.inventory = inv;
        this.wishlist = wish;
    }

    public void addToWishlist(Drivable obj) {
        this.wishlist.add(obj);
    }
    public DrivableTrader(int money) {
        super(money);
        this.inventory = new ArrayList<Drivable>();
        this.wishlist = new ArrayList<Drivable>();
    }
    public int getSellingPrice(Drivable obj) {
        if(obj instanceof Tradable) {
            return ((Tradable) obj).getPrice() + obj.getMaxSpeed();
        }
        return Tradable.MISSING_PRICE;
    }
}