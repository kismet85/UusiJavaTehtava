package com.ismet.view;

import com.ismet.controller.NoteController;
import com.ismet.model.Notebook;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class NoteBookView extends Application {


    private Notebook notebook;

    private NoteController noteController;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/notebook_view.fxml"));
        Parent root = fxmlLoader.load();

        notebook = new Notebook();

        noteController = fxmlLoader.getController();
        noteController.setNotebook(notebook);
        noteController.setNoteBookView(this);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
