package com.ismet.controller;

import com.ismet.model.Currency;
import com.ismet.view.CurrencyView;
import com.ismet.view.DictionaryView;

public class CurrencyController {

    private Currency currency;

    public CurrencyController(Currency currency)
    {
        this.currency = currency;
    }

    public static void main(String[] args) {
        DictionaryView.launch(CurrencyView.class);
    }
}
