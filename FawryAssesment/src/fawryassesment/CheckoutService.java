package fawryassesment;

import fawryassesment.ShoppingCart;
import java.util.ArrayList;
import java.util.List;

class CheckoutService {

    private static final double SHIPPING_FEE_PER_KG = 30.0;
    private ShippingService shippingService = new ShippingService();

    public void checkout(Customer customer, ShoppingCart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cannot checkout with empty cart");
        }
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().isExpired()) {
                throw new IllegalStateException(item.getProduct().getName() + " is expired");
            }
            if (item.getQuantity() > item.getProduct().getQuantity()) {
                throw new IllegalStateException("Not enough stock for " + item.getProduct().getName());
            }
        }

        double subtotal = cart.calculateSubtotal();
        List<Shippable> shippableItems=getShippableItems(cart);
   
        double shippingFee = calculateShippingFee(shippableItems);
        double totalAmount = subtotal + shippingFee;

        if (totalAmount > customer.getBalance()) {
            throw new IllegalStateException("Insufficient customer balance");
        }

        if (!shippableItems.isEmpty()) {
            shippingService.shipItems(shippableItems);
        }

        customer.deductBalance(totalAmount);

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        printReceipt(cart, subtotal, shippingFee, totalAmount, customer);
    }

    private List<Shippable> getShippableItems(ShoppingCart cart) {
        List<Shippable> shippableItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((Shippable) item.getProduct());
                }
            }
        }
        return shippableItems;
    }

    private double calculateShippingFee(List<Shippable> shippableItems) {
        double totalWeight = 0;
        for (Shippable shippable : shippableItems) {
            totalWeight += shippable.getWeight();
        }
        return totalWeight * SHIPPING_FEE_PER_KG;
    }

    private void printReceipt(ShoppingCart cart, double subtotal, double shippingFee, double totalAmount, Customer customer)
    {
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
               System.out.println( item.getQuantity()+"x "+item.getProduct().getName()+"    "+  item.getTotalPrice());
        }
        System.out.println("-------");
        System.out.println("Subtotal    "+ subtotal);
        System.out.println("Shipping    "+ shippingFee);
        System.out.println("Amount    "+ totalAmount);
        System.out.println("Remaining balance: "+ customer.getBalance());
        
    }
}
