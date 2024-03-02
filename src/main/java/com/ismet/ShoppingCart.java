package com.ismet;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Double> cart = new HashMap<>();
    private double totalAmountMoney = 0;
    private int totalAmountItems = 0;
    public void addItem(String item, Double price)
    {
        cart.put(item, price);
    }

    public int getItemCount()
    {
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            Double value = entry.getValue();
            totalAmountMoney += value;
            totalAmountItems++;
        }
        return totalAmountItems;
    }

    public void removeItem(String key)
    {
        cart.remove(key);
    }

    public double calculateTotal()
    {
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            Double value = entry.getValue();
            totalAmountMoney += value;
        }
        return totalAmountMoney;
    }
}
