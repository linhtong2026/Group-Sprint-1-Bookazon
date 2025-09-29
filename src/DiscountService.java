public class DiscountService implements DiscountCalculator {
    public double applyDiscount(double subtotal, Subscription subscription) {
        if (subscription == null) return subtotal;
        double rate = subscription.discountRate();
        return subtotal * (1.0 - rate);
    }
}