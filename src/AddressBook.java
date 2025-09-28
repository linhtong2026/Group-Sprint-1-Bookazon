public class AddressBook {
    private Address shippingAddress;
    private Address billingAddress;

    public void setShippingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.shippingAddress = new Address(line1, line2, city, state, zip, country);
    }

    public void setBillingAddress(String line1, String line2, String city, String state, String zip, String country) {
        this.billingAddress = new Address(line1, line2, city, state, zip, country);
    }

    public Address getShippingAddress() { return shippingAddress; }
    public Address getBillingAddress()  { return billingAddress; }
}
