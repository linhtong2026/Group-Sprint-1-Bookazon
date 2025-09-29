import java.util.List;

public class TotalPriceCalculator {
    private final DiscountCalculator discountCalculator;

    public TotalPriceCalculator(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public double calculateTotalPrice(List<CartItem> items, String subscription) {
        double subtotal = 0.0;

        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return discountCalculator.applyDiscount(subtotal, subscription);
    }
}
