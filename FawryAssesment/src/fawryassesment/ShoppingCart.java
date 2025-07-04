package fawryassesment;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        if (product.isExpired()) {
            throw new IllegalArgumentException(product.getName() + " is expired");
        }

        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getTotalPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        if (items.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
