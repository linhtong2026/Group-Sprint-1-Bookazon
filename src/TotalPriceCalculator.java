import java.util.List;

public class TotalPriceCalculator {
    private final DiscountCalculator discountCalculator;
    private final Subscription subscription;

    public TotalPriceCalculator(DiscountCalculator discountCalculator, Subscription subscription) {
        this.discountCalculator = discountCalculator;
        this.subscription = subscription;
    }

    public double calculateTotalPrice(List<CartItem> items) {
        double subtotal = 0.0;

        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return discountCalculator.applyDiscount(subtotal, this.subscription);
    }
}
