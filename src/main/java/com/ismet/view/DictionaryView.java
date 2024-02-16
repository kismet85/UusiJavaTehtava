package com.ismet.view;

import com.ismet.controller.DictionaryController;
import com.ismet.model.Dictionary;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DictionaryView extends Application {
    private DictionaryController controller;

    private Dictionary dictionary;
    public DictionaryView() {
        dictionary = new Dictionary();
        this.controller = new DictionaryController(dictionary);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Virtual Dictionary");

        Label searchLabel = new Label("Enter word:");
        TextField searchField = new TextField();
        Label meaningLabel = new Label("Enter meaning of word:");
        TextField meaningField = new TextField();
        Button searchButton = new Button("Search");
        Button addButton = new Button("Add");
        Label meaningExplanationLabel = new Label("Explanation of word:");
        TextArea meaningArea = new TextArea();

        searchButton.setOnAction(event -> {
            String word = searchField.getText();
            String meaning = controller.searchWord(word);
            meaningArea.setText(meaning);
        });

        addButton.setOnAction(event ->
        {
            String word = searchField.getText();
            String meaning = meaningField.getText();
            dictionary.addWord(word, meaning);
        });
        HBox buttonBox = new HBox(5);
        buttonBox.getChildren().addAll(searchButton, addButton);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(searchLabel, searchField, meaningLabel, meaningField, buttonBox,meaningExplanationLabel, meaningArea);

        primaryStage.setScene(new Scene(root, 680, 380));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}