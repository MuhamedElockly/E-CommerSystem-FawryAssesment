
package fawryassesment;

import java.util.Date;

public class ECommerceSystem {
     public static void main(String[] args) {   
         // the main hirericy for system is 
                //Product (abstract)
                //├─ ExpirableProduct
                //│  ├─ ShippableExpirableProduct (cheese, biscuits)
                //├─ NonExpirableProduct
                //│  ├─ ShippableNonExpirableProduct (TV, furniture)
                //│  ├─ NonShippableNonExpirableProduct (scratch cards)
        // i made two types of product (Expirable, nonExpirable) , and each one spillited it into (shipped ,nonshipped)
        // i made this to hande expire product and shipped product in the same time
                
                
                
                
         //i made this line to make 7 day expire date for chess by convert it to milly secends
        Date cheeseExpiry = new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000); 
        Product cheese = new ShippableExpirableProduct("Cheese", 100, 10, cheeseExpiry, 0.4);       
        Date biscuitsExpiry = new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000);
        Product biscuits = new ShippableExpirableProduct("Biscuits", 150, 5, biscuitsExpiry, 0.7);        
        Product tv = new ShippableNonExpirableProduct("TV", 10000, 3, 15.0);
        Product scratchCard = new NonExpireProduct("Scratch Card", 50, 100);
        Customer customer = new Customer("Mohamed Mahmoud", 20000);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(cheese, 2);
        cart.addItem(biscuits, 1);
        cart.addItem(tv, 1);
        cart.addItem(scratchCard, 3);
               
        CheckoutService checkoutService = new CheckoutService();
        try {
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }

    }
}
