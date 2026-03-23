package com.example.pen;

public class Cap implements IMachinsmType {
    @Override
    public void open() {
        System.out.println("Cap removed");
    }

    @Override
    public void close() {
        System.out.println("Cap placed back");
    }
}
