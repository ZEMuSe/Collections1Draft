import java.util.Objects;

public class PricePurchase extends Purchase {
    private Byn discount;

    public PricePurchase() {
    }
    public PricePurchase(String name, Byn cost, Number number, Byn discount){
        super(name, cost, number);
        this.discount = discount;
    }
    public PricePurchase(String name, int price, Number number, int discount){
        this(name, new Byn(price), number, new Byn(discount));
    }
    public Byn getCost(){
        return super.getCost().sub(discount);
    }

    @Override
    public String toString() {
        return "[PricePurchase] " + super.toString() + ";" + discount;
    }


}