package com.example.pen;

public class CartraigeFill implements IRefillType {
    private String color;

    public CartraigeFill() {
        this.color = "Blue";
    }

    public CartraigeFill(String color) {
        this.color = color;
    }

    @Override
    public void refill() {
        System.out.println("Refilled using cartridge");
    }

    @Override
    public String getColor() {
        return color;
    }
}
