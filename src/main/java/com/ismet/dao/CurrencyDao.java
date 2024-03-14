package com.ismet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ismet.datasource.MariaDbConnection;
import com.ismet.model.Currency;

    public class CurrencyDao {
        private MariaDbConnection dbConnection;

        public CurrencyDao(MariaDbConnection dbConnection) {
            this.dbConnection = dbConnection;
        }
        public Map<String, Double> getAllCurrencies() {
            Map<String, Double> currencies = new HashMap<>();
            String sql = "SELECT abbreviation, conversion_rate FROM currency";
            try (PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String abbreviation = resultSet.getString("abbreviation");
                    double conversionRate = resultSet.getDouble("conversion_rate");
                    currencies.put(abbreviation, conversionRate);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return currencies;
        }
        public double getExchangeRate(String sourceCurrency, String targetCurrency) {
            String sql = "SELECT conversion_rate FROM currency WHERE abbreviation = ?";
            try (Connection connection = MariaDbConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, sourceCurrency);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getDouble("conversion_rate");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0.0;
        }

    }
