package com.example.pen;

public class PenFactory {
    public IPen createPen(IPenType penType, IMachinsmType machinsmType, IRefillType refillType) {
        return new Pen(penType, machinsmType, refillType);
    }
}
