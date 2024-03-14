package com.ismet.controller;

import com.ismet.datasource.MariaDbConnection;
import com.ismet.dao.CurrencyDao;

public class CurrencyController {
    private final CurrencyDao currencyDao;

    public CurrencyController(MariaDbConnection dbConnection) {
        this.currencyDao = new CurrencyDao(dbConnection);
    }
    public double getExchangeRate(String sourceCurrency, String targetCurrency) {
        return currencyDao.getExchangeRate(sourceCurrency, targetCurrency);
    }
    public double convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        double exchangeRate = currencyDao.getExchangeRate(sourceCurrency, targetCurrency);
        if (exchangeRate != 0.0) {
            return amount * exchangeRate;
        } else {
            return -1; // Or throw an exception
        }
    }
}
