package com.ismet.model;
public class Currency {

        private String abbreviation;
        private String name;
        private double exchangeRate;

        // Constructor
        public Currency(String abbreviation, String name, double exchangeRate) {
            this.abbreviation = abbreviation;
            this.name = name;
            this.exchangeRate = exchangeRate;
        }

        // Getters
        public String getAbbreviation() {
            return abbreviation;
        }

        public String getName() {
            return name;
        }

        public double getExchangeRate() {
            return exchangeRate;
        }

        // Setters
        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setExchangeRate(double exchangeRate) {
            this.exchangeRate = exchangeRate;
        }
}
