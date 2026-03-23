package com.example.pen;

public class InkPen implements IPenType {
    @Override
    public void write() {
        System.out.println("Writing with InkPen");
    }
}
