package com.ismet.view;

import com.ismet.controller.CurrencyController;
import com.ismet.dao.CurrencyDao;
import com.ismet.datasource.MariaDbConnection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;
import java.util.HashMap;

public class CurrencyView extends Application {
    private CurrencyController controller;
    private CurrencyDao currencyDao;

    public CurrencyView() {
        MariaDbConnection dbConnection = new MariaDbConnection();
        this.currencyDao = new CurrencyDao(dbConnection);
        this.controller = new CurrencyController(dbConnection);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Currency exchanger");
        HashMap<String, Double> allCurrencies = (HashMap<String, Double>) currencyDao.getAllCurrencies();

        Label currencyLabel = new Label("Enter amount:");
        TextField currencyField = new TextField();
        ComboBox<String> currencyFirstComboBox = new ComboBox<>();
        currencyFirstComboBox.setPromptText("Select currency");
        currencyFirstComboBox.getItems().addAll(allCurrencies.keySet());

        Label toCurrency = new Label(" to ");
        Button exchangeButton = new Button("Show currency exchange.");


        ComboBox<String> currencySecondComboBox = new ComboBox<>();
        currencySecondComboBox.setPromptText("Select currency");
        currencySecondComboBox.getItems().addAll(allCurrencies.keySet());

        Label meaningLabel = new Label("Exchange rate:");
        TextField meaningField = new TextField();

        exchangeButton.setOnAction(event -> {
            String selectedFirstCurrency = currencyFirstComboBox.getValue();
            String selectedSecondCurrency = currencySecondComboBox.getValue();

            double amount = Double.parseDouble(currencyField.getText());
            double exchangeRate = controller.getExchangeRate(selectedSecondCurrency,selectedFirstCurrency);
            if (exchangeRate != 0.0) {
                double result = amount * exchangeRate;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResult = decimalFormat.format(result);
                meaningField.setText(formattedResult);
            } else {
                meaningField.setText("Exchange rate not available");
            }
        });

        HBox meaningArea = new HBox(10);
        VBox verticalRoot = new VBox(10);
        HBox root = new HBox(10);


        verticalRoot.setPadding(new Insets(10));
        meaningArea.setPadding(new Insets(8));
        root.setPadding(new Insets(10));


        meaningArea.getChildren().addAll(meaningLabel, meaningField);


        root.getChildren().addAll(currencyLabel, currencyField, currencyFirstComboBox,
                toCurrency, currencySecondComboBox, exchangeButton);


        verticalRoot.getChildren().addAll(root, meaningArea);


        primaryStage.setScene(new Scene(verticalRoot, 680, 380));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
