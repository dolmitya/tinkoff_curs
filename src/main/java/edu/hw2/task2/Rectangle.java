package edu.hw2.task2;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(int h, int w) {
        height = h;
        width = w;
    }

    public Rectangle setWidth(int w) {
        return new Rectangle(height, w);
    }

    public Rectangle setHeight(int h) {
        return new Rectangle(h, width);
    }

    double area() {
        return width * height;
    }
}
