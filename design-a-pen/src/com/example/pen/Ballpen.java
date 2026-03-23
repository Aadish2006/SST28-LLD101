package com.example.pen;

public class Ballpen implements IPenType {
    @Override
    public void write() {
        System.out.println("Writing with Ballpen");
    }
}
