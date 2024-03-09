DROP DATABASE IF EXISTS CurrencyConverterDB;

CREATE DATABASE CurrencyConverterDB;

USE CurrencyConverterDB;

CREATE TABLE Currency (
    abbreviation VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50),
    conversion_rate DOUBLE
);

INSERT INTO Currency (abbreviation, name, conversion_rate) VALUES
    ('EUR', 'Euro', 1.0),
    ('USD', 'United States Dollar', 1.15),
    ('ALL', 'Albanian Lek', 110.0),
    ('JPY', 'Japanese Yen', 120.0),
    ('GBP', 'British Pound', 0.8);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON CurrencyConverterDB.Currency TO 'appuser'@'localhost';

SELECT * FROM Currency;

SELECT * FROM Currency WHERE abbreviation = 'EUR';

SELECT COUNT(*) AS num_currencies FROM Currency;

SELECT * FROM Currency ORDER BY conversion_rate DESC LIMIT 1;
