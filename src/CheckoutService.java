
public class CheckoutService {

    public void addToCart(User user, Media media, int quantity) {
        user.addToCart(media, quantity);
    }

    public void checkout(User user) {
        user.checkout();
    }

    public void viewOrders(User user) {
        user.viewOrders();
    }

    public void viewCart(User user) {
        user.viewCart();
    }
}
