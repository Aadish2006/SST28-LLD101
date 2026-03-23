package com.example.pen;

public class Pen implements IPen {
    private final IPenType penType;
    private final IMachinsmType machinsmType;
    private IRefillType refillType;
    private String color;
    private int capacity;

    public Pen(IPenType penType, IMachinsmType machinsmType, IRefillType refillType) {
        this.penType = penType;
        this.machinsmType = machinsmType;
        this.refillType = refillType;
        this.color = refillType.getColor();
        this.capacity = FULL_CAPACITY;
    }

    @Override
    public void open() {
        machinsmType.open();
    }

    @Override
    public void write() {
        if (capacity <= EMPTY_CAPACITY) {
            System.out.println("Pen is empty. Please change refill.");
            return;
        }

        penType.write();
        capacity--;
        System.out.println("Current color: " + color + ", capacity: " + capacity);
    }

    @Override
    public void refill() {
        refillType.refill();
        capacity = FULL_CAPACITY;
        color = refillType.getColor();
        System.out.println("Pen refilled. Color: " + color + ", capacity: " + capacity);
    }

    @Override
    public void changeRefill(IRefillType newRefillType) {
        this.refillType = newRefillType;
        refill();
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void close() {
        machinsmType.close();
    }
}
