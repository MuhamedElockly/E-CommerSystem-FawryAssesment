package fawryassesment;

class ShippableNonExpirableProduct extends NonExpireProduct implements Shippable {

    private double weight;

    public ShippableNonExpirableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
