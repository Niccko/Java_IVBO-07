package practice4;

public abstract class Shape{
    String color;
    boolean filled;
    Shape(){};
    Shape(String color_, boolean filled_){
        color = color_;
        filled = filled_;
    }

    public void setColor(String color_) { color = color_; }
    public String getColor() { return color; }
    public void setFilled( boolean filled_) { filled = filled; }
    public boolean isFilled() { return filled; }

    abstract double getArea();
    abstract double getPerimeter();
}

class Circle extends Shape{
    private double radius;
    Circle(double radius_){
        radius = radius_;
    }
    Circle(double radius_, String color,boolean filled){
        super(color,filled);
        radius = radius_;
    }

    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    @Override
    double getArea() { return Math.PI*Math.pow(getRadius(),2); }

    @Override
    double getPerimeter() { return Math.PI*radius*2; }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", is filled: "+isFilled()+
                ", color = " + getColor()+
                '}';
    }
}

class Rectangle extends Shape{
    private double width,height;
    Rectangle(double width_, double height_){
        width = width_;
        height = height_;
    }
    Rectangle(double width_, double height_, String color, boolean filled){
        super(color,filled);
        width = width_;
        height = height_;
    }

    public double getWidth() { return width; }

    public void setWidth(double width) { this.width = width; }

    public double getHeight() { return height; }

    public void setHeight(double height) { this.height = height; }

    @Override
    double getArea() { return width*height; }

    @Override
    double getPerimeter() { return 2*(width+height); }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", is filled: "+isFilled()+
                ", color = " + getColor()+
                '}';
    }
}

class Square extends Shape{
    private double side;
    Square(double side_){
        side = side_;
    }
    Square(double side_, String color, boolean filled){
        super(color,filled);
        side = side_;
    }

    public double getSide() { return side; }
    public void setSide(double side) { this.side = side; }

    @Override
    double getPerimeter() {
        return side*4;
    }

    @Override
    double getArea() {
        return side*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                ", side=" + side +
                '}';
    }
}