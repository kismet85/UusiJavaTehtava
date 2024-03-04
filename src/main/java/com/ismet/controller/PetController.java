package com.ismet.controller;

import com.ismet.model.Pet;
import com.ismet.view.Graphics;
import javafx.scene.image.Image;

public class PetController {
    private Pet pet;

    public PetController() {
        this.pet = new Pet();
    }

    public void updatePetLocation(double targetX, double targetY) {
        pet.updateLocation(targetX, targetY);
    }

    public double getPetX() {
        return pet.getX();
    }

    public double getPetY() {
        return pet.getY();
    }

    public Image getPetImage() {
        return new Image("file:src/main/resources/catttt.jpg");
    }

    public static void main(String[] args) {
        Graphics.launch(Graphics.class);
    }
}
