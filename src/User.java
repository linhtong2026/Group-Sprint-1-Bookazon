import java.util.ArrayList;

public class User {
    private String name;
    private Subscription subscription;
    private Cart cart;
    private final OrderHistory orderHistory;
    private final AddressBook addressBook;

    public User(String name, Subscription subscription) {
        this.name = name;
        this.subscription = subscription;  // normal, gold, platinum, silver membership
        this.cart = new Cart();
        this.orderHistory = new OrderHistory();
        this.addressBook = new AddressBook();
    }

    public String getName() { return name; }

    public String getSubscription() { return subscription.toString(); }

    public void setSubscription(Subscription subscription) { this.subscription = subscription; }

    public void viewCart() { cart.viewCartDetails(); }

    public void setShippingAddress(Address address) {
        addressBook.setShippingAddress(address);
    }

    public void setBillingAddress(Address address) {
        addressBook.setBillingAddress(address);
    }

    public void addToCart(Media media, int quantity) {
        cart.addItem(new CartItem(media.getTitle(), media.getPrice(), quantity, new StandardPricing()));
    }

    public void addToCart(Book book, int quantity) {
        addToCart((Media) book, quantity);
    }

    public void removeFromCart(Media media) {
        for (CartItem item : new ArrayList<>(cart.getItems())) {
            if (item.getName().equals(media.getTitle())) {
                cart.removeItem(item);
                break;
            }
        }
    }

    public void removeFromCart(Book book) {
        removeFromCart((Media) book);
    }

    public void viewOrders() {
        orderHistory.printOrders();
    }

    public void checkout() {
        DiscountService discountService = new DiscountService();
        Order order = new Order(cart, new TotalPriceCalculator(discountService, this.subscription), this.subscription);
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
