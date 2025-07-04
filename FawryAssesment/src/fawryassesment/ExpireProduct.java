package fawryassesment;

import java.util.Date;

public class ExpireProduct extends Product {

    private Date expirationDate;

    public ExpireProduct(String name, double price, int quantity, Date expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired() {
        Date today = new Date();
        if (today.after(expirationDate)) {
            return true;
        } else {
            return false;
        }
    }
}
