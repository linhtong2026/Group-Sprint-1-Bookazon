import java.util.HashMap;
import java.util.Map;

public class DiscountService implements DiscountCalculator {
    private static final Map<String, Double> DISCOUNT_MAP = new HashMap<>();

    static {
        DISCOUNT_MAP.put("gold", 0.15);
        DISCOUNT_MAP.put("platinum", 0.10);
        DISCOUNT_MAP.put("silver", 0.05);
        DISCOUNT_MAP.put("normal", 0.0);
    }

    public double applyDiscount(double subtotal, String subscription) {
        if (subscription == null) return subtotal;

        String subscription_tier = subscription.toLowerCase();
        double rate = DISCOUNT_MAP.getOrDefault(subscription_tier, 0.0);

        return subtotal * (1.0 - rate);
    }
}