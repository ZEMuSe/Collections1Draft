import java.io.FileReader;
import java.util.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Runner {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new FileReader("in.csv.txt"))) {
            Map<Purchase, WeekDay> lastPurchasesMap = new HashMap<>();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] strings = line.split(";");
                String lines = scanner.nextLine();
                WeekDay day  = WeekDay.valueOf(lines);
                if (strings.length == 4){
                    String name = strings[0];
                    int cost = Integer.parseInt(strings[1]);
                    int number = Integer.parseInt(strings[2]);
                    int discount = Integer.parseInt(strings[3]);
                    PricePurchase purchase = new PricePurchase(name, cost, number, discount);
                    lastPurchasesMap.put(purchase, day);
                }else if (strings.length == 3){
                    String name = strings[0];
                    int cost = Integer.parseInt(strings[1]);
                    int number = Integer.parseInt(strings[2]);
                    Purchase purchase = new Purchase(name, cost, number);
                    lastPurchasesMap.put(purchase, day);
                }
            }
            System.out.println(lastPurchasesMap);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}
