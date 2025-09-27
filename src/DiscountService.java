public class DiscountService {

    public double applySubscriptionDiscount(double subtotal, String subscription) {
        double rate = 0.0;
        if (subscription != null) {
            String tier = subscription.toLowerCase();
            if (tier.equals("gold")) {
                rate = 0.15;
            } else if (tier.equals("platinum")) {
                rate = 0.10;
            } else if (tier.equals("silver")) {
                rate = 0.05;
            }
        }
        return subtotal * (1.0 - rate);
    }
}
