package com.example.pen;

public interface IPen {
    int FULL_CAPACITY = 100;
    int EMPTY_CAPACITY = 0;

    void open();

    void write();

    void refill();

    void changeRefill(IRefillType newRefillType);

    String getColor();

    int getCapacity();

    void close();
}
