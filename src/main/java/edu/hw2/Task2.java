package edu.hw2;

@SuppressWarnings("uncommentedmain")
public class Task2 {

    private Task2() {
    }

    public static class Rectangle {

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

    public static class Square extends Rectangle {
        public Square() {
        }

        public Square(int side) {
            super(side, side);
        }

        public Square setSide(int side) {
            return new Square(side);
        }

    }
}
