public class StandardPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int quantity) {
        return basePrice * quantity;
    }
}
