package com.example.pen;

public class Click implements IMachinsmType {
    @Override
    public void open() {
        System.out.println("Click mechanism opened");
    }

    @Override
    public void close() {
        System.out.println("Click mechanism closed");
    }
}
