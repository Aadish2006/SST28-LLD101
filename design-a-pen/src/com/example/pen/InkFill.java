package com.example.pen;

public class InkFill implements IRefillType {
    private String color;

    public InkFill() {
        this.color = "Black";
    }

    public InkFill(String color) {
        this.color = color;
    }

    @Override
    public void refill() {
        System.out.println("Refilled using ink bottle");
    }

    @Override
    public String getColor() {
        return color;
    }
}
