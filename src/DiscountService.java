import java.util.HashMap;
import java.util.Map;

public class DiscountService {
    private static final Map<String, Double> DISCOUNT_MAP = new HashMap<>();

    static {
        DISCOUNT_MAP.put("gold", 0.15);
        DISCOUNT_MAP.put("platinum", 0.10);
        DISCOUNT_MAP.put("silver", 0.05);
        DISCOUNT_MAP.put("normal", 0.0);
    }

    public double applySubscriptionDiscount(double subtotal, String subscription) {
        if (subscription == null) return subtotal;

        String tier = subscription.toLowerCase();
        double rate = DISCOUNT_MAP.getOrDefault(tier, 0.0);

        return subtotal * (1.0 - rate);
    }
}