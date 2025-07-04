package fawryassesment;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

class ShippingService {

    private HashMap<Shippable, Integer> itemsCount = new HashMap<>();

    public void shipItems(List<Shippable> shippableItems) {
        if (shippableItems.isEmpty()) {
            return;
        }
        // I made this function to calculate each product count in the passed list using HashMap to get the the frequency of each product
        CalcItemsCount(shippableItems);
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Map.Entry<Shippable, Integer> entry : itemsCount.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey().getName() + "    " + entry.getKey().getWeight());
            totalWeight += entry.getKey().getWeight() * entry.getValue();
        }

        System.out.println("Total package weight " + totalWeight);
        System.out.println();
    }

    public void CalcItemsCount(List<Shippable> shippableItems) {
        for (Shippable item : shippableItems) {
            itemsCount.put(item, itemsCount.getOrDefault(item, 0) + 1);
        }
    }

    private int getQuantityForProduct(Shippable item) {

        return itemsCount.get(item);
    }
}
