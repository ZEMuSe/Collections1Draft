import java.util.Objects;
import java.util.Scanner;

public class Purchase implements Comparable<Purchase>{
    private String name;
    private Byn cost;
    private Number number;

    public Purchase(){}

    public Purchase(String name ,Byn cost, Number number){
        this.name = name;
        this.cost = cost;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return name.equals(purchase.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result;
    }

    public Purchase(String name, int cost, int number){
        this(name, new Byn(cost), number);
    }
    public Purchase(String path){
        Scanner scanner = new Scanner(path);
    }
    public Byn getCost(){
        return cost.mul(number.doubleValue(), RoundMethod.ROUND, 0);
    }

    @Override
    public String toString() {
        return "[Purchase] " + name + ";" + cost + ";" + getCost() + ";" + number;
    }
    @Override
    public int compareTo(Purchase o){
        return getCost().compareTo(o.getCost());
    }

    public String getName() {
        return name;
    }

    public Number getNumber() {
        return number;
    }

}