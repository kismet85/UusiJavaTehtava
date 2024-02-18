package com.ismet.model;

import java.util.HashMap;

public class Currency {

    private final HashMap<String, Double> currency;

    public Currency()
    {
        this.currency = new HashMap<>();
        currency.put("Euro", 1.0);
        currency.put("Dollar", 1.15);
        currency.put("Lek", 110.0);
        currency.put("Yen", 120.0);
        currency.put("Pound", 0.8);
    }
    public Double searchCurrency(String currentCurrency) {
        return currency.getOrDefault(currentCurrency, 0.00);
    }

    public HashMap getAllCurrencies()
    {
        return currency;
    }
}
