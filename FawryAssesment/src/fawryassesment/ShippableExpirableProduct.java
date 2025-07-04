package fawryassesment;

import java.util.Date;

class ShippableExpirableProduct extends ExpireProduct implements Shippable {

    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity, Date expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
