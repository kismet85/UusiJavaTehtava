package com.ismet.model;

public class Pet {
    private double x;
    private double y;

    public Pet() {
        this.x = 250;
        this.y = 250;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void updateLocation(double targetX, double targetY) {

        double dx = targetX - x;
        double dy = targetY - y;

        double distance = Math.sqrt(dx * dx + dy * dy);

        double maxSpeed = 1;


        if (distance > maxSpeed) {
            dx *= maxSpeed / distance;
            dy *= maxSpeed / distance;
        }

        x += dx;
        y += dy;
    }
}
