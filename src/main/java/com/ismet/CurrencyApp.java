package com.ismet;

import com.ismet.dao.CurrencyDao;
import com.ismet.datasource.MariaDbConnection;
import com.ismet.view.CurrencyView;
import com.ismet.view.DictionaryView;

import java.util.Map;

public class CurrencyApp {

    public static void main(String[] args) {
        MariaDbConnection dbConnection = new MariaDbConnection();
        CurrencyDao currencyDao = new CurrencyDao(dbConnection);

        Map<String, Double> currencies = currencyDao.getAllCurrencies();
        for (Map.Entry<String, Double> entry : currencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        DictionaryView.launch(CurrencyView.class);
    }
}
