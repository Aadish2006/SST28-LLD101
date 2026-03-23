package com.example.pen;

class main{
    public static void main(String[] args) {
        PenFactory penFactory = new PenFactory();

        IPen ballPen = penFactory.createPen(new Ballpen(), new Cap(), new CartraigeFill("Blue"));
        ballPen.open();
        ballPen.write();
        ballPen.write();
        ballPen.changeRefill(new InkFill("Red"));
        System.out.println("After refill change -> Color: " + ballPen.getColor() + ", Capacity: " + ballPen.getCapacity());
        ballPen.close();

        System.out.println("----");

        IPen inkPen = penFactory.createPen(new InkPen(), new Cap(), new InkFill("Black"));
        inkPen.open();
        inkPen.write();
        inkPen.changeRefill(new CartraigeFill("Green"));
        System.out.println("After refill change -> Color: " + inkPen.getColor() + ", Capacity: " + inkPen.getCapacity());
        inkPen.close();
    }
}