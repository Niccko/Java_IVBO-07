package practice3;

class Circle{
    int x,y,rad;
    Circle(int x_, int y_, int rad_){
        x=x_;
        y=y_;
        rad = rad_;
    }

    public int getRad() { return rad; }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setRad(int rad) { this.rad = rad; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    @Override
    public String toString() {
        return "Circle{"+
                "x=" + x +
                ", y=" + y +
                ", radius=" + rad +
                '}';
    }
}

class Human {
    Head head;
    Hand leftHand, rightHand;
    Leg leftLeg, rightLeg;

    Human(double handLength, double legLength) {
        leftHand = new Hand(handLength);
        rightHand = new Hand(handLength);
        leftLeg = new Leg(legLength);
        rightLeg = new Leg(legLength);
    }

    @Override
    public String toString() {
        return "Human{" +
                "Left hand length=" + leftHand.getLength() +
                ", Right hand length=" + rightHand.getLength() +
                ", Left leg length=" + leftLeg.getLength() +
                ", Right leg length=" + rightLeg.getLength() +
                '}';
    }
}

    class Leg{
        private double length;
        Leg(double length_){
            length = length_;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getLength() {
            return length;
        }
    }
    class Hand{
        private double length;
        Hand(double length_){
            length = length_;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public double getLength() {
            return length;
        }
    }
    class Head{

    }


class Book{
    String author;
    String name;
    int year;
    Book(String author_, String name_, int year_){
        author = author_;
        name = name_;
        year = year_;
    }

    public int getYear() { return year; }

    public String getAuthor() { return author; }

    public String getName() { return name; }

    public void setAuthor(String author) { this.author = author; }

    public void setName(String name) { this.name = name; }

    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

public class Main{
    public static void main(String[] args) {
        Human human = new Human(20,40);
        Circle cr = new Circle(20, 20, 10);
        Book book = new Book("Грибоедов","Горе от ума",1824);
        System.out.println(cr);
        System.out.println(human);
        System.out.println(book);

    }
}