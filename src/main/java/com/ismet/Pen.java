package com.ismet;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    private Color currentColor;
    private boolean capOn;

    public Pen() {
        this(Color.RED); // Default color is red
    }

    public Pen(Color color) {
        this.currentColor = color;
        this.capOn = true; // Cap is initially on
    }

    public String draw() {
        if (capOn) {
            return ""; // If cap is on, pen cannot draw
        } else {
            return "Drawing " + currentColor;
        }
    }


    public void capOff() {
        this.capOn = false;
    }

    public void capOn() {
        this.capOn = true;
    }

    public void changeColor(Color newColor) {
        if (capOn) {
            currentColor = newColor;
        }
    }

}


