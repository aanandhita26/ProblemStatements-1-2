import java.util.*;

public class FlashSaleInventory {

    private HashMap<String, Integer> stock = new HashMap<>();
    private Queue<Integer> waitingList = new LinkedList<>();

    public void addProduct(String id, int quantity) {
        stock.put(id, quantity);
    }

    public void checkStock(String id) {
        System.out.println("Stock: " + stock.getOrDefault(id, 0));
    }

    public void purchase(String id, int userId) {
        int quantity = stock.getOrDefault(id, 0);

        if (quantity > 0) {
            stock.put(id, quantity - 1);
            System.out.println("Purchase successful. Remaining: " + (quantity - 1));
        } else {
            waitingList.add(userId);
            System.out.println("Added to waiting list");
        }
    }

    public static void main(String[] args) {
        FlashSaleInventory f = new FlashSaleInventory();
        f.addProduct("IPHONE", 2);

        f.purchase("IPHONE", 1);
        f.purchase("IPHONE", 2);
        f.purchase("IPHONE", 3);
    }
}