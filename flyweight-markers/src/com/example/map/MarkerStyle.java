package com.example.map;

/**
 * CURRENT STATE (BROKEN ON PURPOSE):
 * A style object exists, but is mutable and is created per marker,
 * even when thousands of markers share the same config.
 *
 * TODO (student):
 * - Make this an immutable Flyweight (final fields, no setters).
 */


/**
 * Flyweight Object (Intrinsic State)
 *
 * This class represents the shared style of map markers.
 * Many markers can reuse the same MarkerStyle instance.
 *
 * CHANGES MADE:
 * 1. Made the class immutable.
 * 2. All fields are now final.
 * 3. Removed all setter methods.
 *
 * WHY?
 * Flyweight objects are shared between many objects.
 * If they were mutable, changing the style for one marker
 * would affect all markers referencing the same style.
 *
 * Immutability ensures safe sharing.
 */

public class MarkerStyle {

    private final String shape;   // e.g., PIN, CIRCLE, SQUARE
    private final String color;   // e.g., RED, BLUE, GREEN
    private final int size;       // e.g., 10..20
    private final boolean filled; // filled vs outline

    public MarkerStyle(String shape, String color, int size, boolean filled) {
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.filled = filled;
    }

    public String getShape() { return shape; }
    public String getColor() { return color; }
    public int getSize() { return size; }
    public boolean isFilled() { return filled; }

    // BROKEN: setters should go away after immutability refactor
    // public void setShape(String shape) { this.shape = shape; }
    // public void setColor(String color) { this.color = color; }
    // public void setSize(int size) { this.size = size; }
    // public void setFilled(boolean filled) { this.filled = filled; }

    @Override
    public String toString() {
        return shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
    }
}
