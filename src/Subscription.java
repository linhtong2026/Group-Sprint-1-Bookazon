public abstract class Subscription {
    private final String name;
    private final double discountRate;

    protected Subscription(String name, double discountRate) {
        this.name = name;
        this.discountRate = discountRate;
    }

    public String name() {
        return name;
    }

    public double discountRate() {
        return discountRate;
    }

    public double apply(double subtotal) {
        return subtotal * (1.0 - discountRate);
    }

    @Override
    public String toString() {
        return String.format("%s subscription (%.0f%% discount)", 
                             name, discountRate * 100);
    }
}