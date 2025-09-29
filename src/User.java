import java.util.ArrayList;

public class User {
    private String name;
    private String subscription;
    private Cart cart;
    private final OrderHistory orderHistory;
    private final AddressBook addressBook;

    public User(String name, String subscription) {
        this.name = name;
        this.subscription = subscription;  // normal, gold, platinum, silver membership
        this.cart = new Cart();
        this.orderHistory = new OrderHistory();
        this.addressBook = new AddressBook();
    }

    public String getName() { return name; }

    public String getSubscription() { return subscription; }

    public void setSubscription(String role) { this.subscription = role; }

    public void viewCart() { cart.viewCartDetails(); }

    public void setShippingAddress(Address address) {
        addressBook.setShippingAddress(address);
    }

    public void setBillingAddress(Address address) {
        addressBook.setBillingAddress(address);
    }

    public void addToCart(Book book, int quantity) {
        cart.addItem(new CartItem(book.getTitle(), book.getPrice(), quantity, new StandardPricing()));
    }

    public void removeFromCart(Book book) {
        for (CartItem item : new ArrayList<>(cart.getItems())) {
            if (item.getName().equals(book.getTitle())) {
                cart.removeItem(item);
                break;
            }
        }
    }

    public void viewOrders() {
        orderHistory.printOrders();
    }

    public void checkout() {
        Order order = new Order(cart, this.subscription, new DiscountService());
        Address shipping = addressBook.getShippingAddress();
        Address billing = addressBook.getBillingAddress();

        if (shipping != null) {
            order.setShippingAddress(shipping);
        }
        if (billing != null) {
            order.setBillingAddress(billing);
        }
        order.setOrderStatus("Order Placed");
        order.setDateCreated("2024-01-01");
        order.setUserName(this.name);
        orderHistory.addOrder(order);
    }
}
