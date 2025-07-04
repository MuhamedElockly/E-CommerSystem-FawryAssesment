
package fawryassesment;

class NonExpireProduct extends Product {

    public NonExpireProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
