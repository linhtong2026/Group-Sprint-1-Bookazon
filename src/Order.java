
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private String dateCreated;
    private String dateShipped;
    private String userName;
    private String orderStatus;
    private Address shippingAddress;
    private Address billingAddress;
    private double orderPrice;
    private double subtotal;
    private List<CartItem> items;
    private Subscription subscription;

    public Order(Cart cart, TotalPriceCalculator totalPriceCalculator, Subscription subscription) {
        this.subscription = subscription;
        this.items = Collections.unmodifiableList(new ArrayList<>(cart.getItems()));

        this.subtotal = 0.0;
        for (CartItem item : this.items) {
            this.subtotal += item.getTotalPrice();
        }

        this.orderPrice = totalPriceCalculator.calculateTotalPrice(this.items);
    }

    public void setShippingAddress(Address address) {
        this.shippingAddress = address;
    }

    public void setBillingAddress(Address address) {
        this.billingAddress = address;
    }

    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    public void setDateCreated(String date) {
        this.dateCreated = date;
    }

    public void setDateShipped(String date) {
        this.dateShipped = date;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void printOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("Date Created: " + dateCreated);
        System.out.println("Date Shipped: " + dateShipped);
        System.out.println("User Name: " + userName);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Shipping Address: " + (shippingAddress != null ? shippingAddress.toString() : "Not set"));
        System.out.println("Billing Address: " + (billingAddress != null ? billingAddress.toString() : "Not set"));

        System.out.println();
        System.out.println("Pricing Breakdown:");
        System.out.printf("Subtotal: $%.2f%n", subtotal);

        if (subscription != null && subscription.discountRate() > 0) {
            double discountAmount = subtotal - orderPrice;
            System.out.printf("Subscription: %s%n", subscription.toString());
            System.out.printf("Discount Amount: -$%.2f%n", discountAmount);
        } else {
            System.out.println("Subscription: Normal (No discount)");
            System.out.println("Discount Amount: $0.00");
        }

        System.out.printf("Final Total: $%.2f%n", orderPrice);
    }
}
