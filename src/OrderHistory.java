
import java.util.ArrayList;
import java.util.List;

public class OrderHistory {

    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void printOrders() {
        for (Order o : orders) {
            o.printOrderDetails();
        }
    }
}
