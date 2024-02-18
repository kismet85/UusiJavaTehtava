package com.ismet.view;

import com.ismet.controller.CurrencyController;
import com.ismet.controller.DictionaryController;
import com.ismet.model.Currency;
import com.ismet.model.Dictionary;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class CurrencyView extends Application {
    private CurrencyController controller;

    private Currency currency;
    public CurrencyView() {
        currency = new Currency();
        this.controller = new CurrencyController(currency);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Currency exchanger");

        Label currencyLabel = new Label("Enter amount:");
        TextField currencyField = new TextField();
        Label toCurrency = new Label("Eur to ");
        Button exchangeButton = new Button("Show currency exchange.");

        // Luo comboboxi
        ComboBox<String> currencyComboBox = new ComboBox<>();
        currencyComboBox.setPromptText("Select currency");
        // Lisää kaikki valuutat komboboxiin
        HashMap<String, Double> allCurrencies = currency.getAllCurrencies();
        currencyComboBox.getItems().addAll(allCurrencies.keySet());



        Label meaningLabel = new Label("Exchange rate:");
        TextField meaningField = new TextField();

        exchangeButton.setOnAction(event -> {
            String selectedCurrency = currencyComboBox.getValue();
            double exchangeRate = currency.searchCurrency(selectedCurrency);
            double amount = Double.parseDouble(currencyField.getText());
            double result = amount * exchangeRate;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedResult = decimalFormat.format(result);
            meaningField.setText(String.valueOf(formattedResult));
        });

        HBox meaningArea = new HBox(10);
        VBox verticalRoot = new VBox(10);
        HBox root = new HBox(10);
        verticalRoot.setPadding(new Insets(10));
        meaningArea.setPadding(new Insets(8));
        root.setPadding(new Insets(10));
        meaningArea.getChildren().addAll(meaningLabel, meaningField);
        root.getChildren().addAll(currencyLabel,currencyField,toCurrency, currencyComboBox, exchangeButton);
        verticalRoot.getChildren().addAll(root,meaningArea);
        primaryStage.setScene(new Scene(verticalRoot, 680, 380));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
