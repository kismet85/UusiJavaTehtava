package com.ismet.view;

import com.ismet.controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Graphics extends Application {
    private static final int CANVAS_SIZE = 1000; // Adjust as needed

    private Canvas canvas;
    private GraphicsContext gc;
    private PetController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new PetController();

        canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        gc = canvas.getGraphicsContext2D();


        Image petImage = new Image("file:src/main/resources/catttt.jpg");

        ImageView petImageView = new ImageView(petImage);


        petImageView.setFitWidth(20);
        petImageView.setFitHeight(20);

        gc.drawImage(petImageView.getImage(), controller.getPetX(), controller.getPetY());


        canvas.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            controller.updatePetLocation(event.getX(), event.getY());
            draw();
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, CANVAS_SIZE, CANVAS_SIZE);
        primaryStage.setTitle("Virtual Pet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void draw() {
        gc.clearRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);

        Image catimage = controller.getPetImage();
        ImageView petImageView = new ImageView(catimage);
        petImageView.setFitHeight(20);
        petImageView.setFitWidth(20);
        gc.drawImage(petImageView.getImage(), controller.getPetX(), controller.getPetY());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
