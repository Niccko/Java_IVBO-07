##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice1/Main1.java
```java
package practice1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        int[] array;
        Scanner sc = new Scanner(System.in);
        System.out.println("Размер: ");
        array = new int[sc.nextInt()];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
            sum+=array[i];
        }
        System.out.println(sum);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice1/Main2.java
```java
package practice1;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]+" ");
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice1/Main3.java
```java
package practice1;

public class Main3 {
    public static void main(String[] args){
        for (double i = 1; i <= 10; i++) {
            System.out.println(1/i+" ");
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice1/Main4.java
```java
package practice1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main4 {
    public static void main(String[] args){
        int[] array;
        int rand;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.println("Размер: ");
        array = new int[sc.nextInt()];

        System.out.println("Метод генерации (1-Math.random(), 0 - Random)");
        rand = sc.nextInt();
        for (int i = 0; i < array.length; i++) {
            if(rand==1) {
                array[i] = (int) Math.random() * 100;
            } else {
                array[i] = rd.nextInt(100);
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        Arrays.sort(array);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice1/Main5.java
```java
package practice1;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Размер: ");
        int num = sc.nextInt();
        for (int i = num-1; i >0 ; i--) {
            num*=i;
        }
        System.out.print(num);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice10/App.java
```java
package practice10;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Vector;

public class App extends JFrame {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public App(){
        Font mainFont = new Font("Arial",Font.BOLD,24);
        DecimalFormat dc = new DecimalFormat("###.####");
        Calculator calculator = new Calculator();
        JPanel mainPanel = new JPanel(null);
        JPanel buttonPanel = new JPanel(null);

        //Window setup
        setTitle("Calculator");
        setSize(525,300);
        setResizable(false);

        //Creating elements
        JTextField textA = new JTextField(20);
        textA.setBounds(10,10,480,50);
        textA.setFont(mainFont);
        textA.setToolTipText("Number A");

        JTextField textB = new JTextField(20);
        textB.setBounds(10,70,480,50);
        textB.setFont(mainFont);
        textB.setToolTipText("Number B");

        JTextField result = new JTextField();
        result.setEnabled(false);
        result.setDisabledTextColor(Color.BLACK);
        result.setBounds(10,200,480,50);
        result.setFont(mainFont);


        Vector<JButton> buttons = new Vector<>();

        JButton addButton = new JButton("+");
        addButton.setFont(mainFont);
        addButton.setBounds(0,0,75,50);
        JButton subButton = new JButton("-");
        subButton.setBounds(80,0,75,50);
        subButton.setFont(mainFont);
        JButton multButton = new JButton("*");
        multButton.setBounds(160,0,75,50);
        multButton.setFont(mainFont);
        JButton divButton = new JButton("/");
        divButton.setBounds(240,0,75,50);
        divButton.setFont(mainFont);

        //Adding elements to the window
        buttons.add(addButton);
        buttons.add(subButton);
        buttons.add(multButton);
        buttons.add(divButton);

        mainPanel.add(textA);
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divButton);
        mainPanel.add(textB);
        buttonPanel.setBounds(100,130,1000,50);
        mainPanel.add(buttonPanel);
        mainPanel.add(result);


        for (JButton button:buttons) {
            button.addActionListener(action->{
                if(textA.getText().equals("") || textB.getText().equals("") || !isNumeric(textA.getText())||!isNumeric(textB.getText())){
                    result.setText("Invalid operators");
                } else {
                    double a = Double.parseDouble(textA.getText());
                    double b = Double.parseDouble(textB.getText());
                    String res = dc.format(calculator.calculate(a,button.getText(),b));
                    textA.setText("");
                    textB.setText("");
                    result.setText(res);
                }
            });
        }
        
        add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice10/Calculator.java
```java
package practice10;

public class Calculator {
    public double calculate(double a, String sign, double b){
        switch (sign){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return 0;
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice10/Main.java
```java
package practice10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            App app = new App();
            app.setVisible(true);
        });
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice11/Main.java
```java
package practice11;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final static AtomicInteger totalSum = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            work(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time: " + (endTime - startTime));
        System.out.println("total sum: " + totalSum.get());
    }

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        double result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static double doHardWork(int start, int count) {
        double a = 1;
        for (int i = 0; i < count; i++) {
            a += Math.cbrt(34.3415)*Math.exp(34.34524784)/Math.sqrt(a);
            totalSum.incrementAndGet();
        }
        return a;
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice12/Colors.java
```java
package practice12;

public enum  Colors {
    YELLOW(93),
    GREEN(92),
    GRAY(37),
    WHITE(97),
    RED(31);

    private int colorCode;

    Colors(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice12/Main.java
```java
package practice12;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";

    public static void printColored(String text, Colors color){
        String ANSI_COLOR = "\u001B["+color.getColorCode()+"m";
        System.out.println(ANSI_COLOR+text+ANSI_RESET);
    }

    public static void main(String[] args) {
        printColored("SAMPLE_TEXT_WRYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY"
                                        +"YYYYYYYYYYYYYYYYYYYYYYYYYYYY",Colors.YELLOW);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice13/Human.java
```java
package practice13;

public class Human {
    String name;
    int birthYear;
    int height;

    public void setName(String name) throws Exception {
        if(name.length()>1) {
            this.name = name;
        } else throw new Exception();
    }

    public void setBirthYear(int birthYear) throws InvalidBirthYearException {
        if(birthYear>1900 && birthYear<2020) {
            this.birthYear = birthYear;
        } else throw new InvalidBirthYearException();
    }

    public void setHeight(int height) throws InvalidHeightException {
        if(height<250 && height > 50) {
            this.height = height;
        } else throw new InvalidHeightException();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", height=" + height +
                '}';
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice13/InvalidBirthYearException.java
```java
package practice13;

public class InvalidBirthYearException extends Exception {
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice13/InvalidHeightException.java
```java
package practice13;

public class InvalidHeightException extends RuntimeException {
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice13/Main.java
```java
package practice13;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.setHeight(150);
        try {
            human.setName("Misha");
            human.setBirthYear(1899);
        } catch (InvalidBirthYearException e) {
            System.out.println("Error:\nГод рождения не соответсвует пределам 1900-2020");
        } catch (Exception e){
            System.out.println("Error:\nНекорректное имя");
        } finally {
            System.out.println(human);
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice14/Regex.java
```java
package practice14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ruleCnt = sc.nextInt();
        Map<String,String> reps = new HashMap<>();

        while(ruleCnt>0){
            reps.put(sc.next(), sc.next());
            ruleCnt--;
        }
        String input = sc.next();
        StringBuilder regex = new StringBuilder();
        String[] rules = reps.keySet().toArray(new String[0]);
        for (int i = 0; i < rules.length; i++) {
            regex.append(rules[i]);
            if(i!=rules.length-1) regex.append("|");
        }
        Pattern pat = Pattern.compile(regex.toString());
        Matcher match = pat.matcher(input);
        String result = match.replaceAll(x->reps.get(x.group()));

        System.out.println(result);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice14/WithoutRegex.java
```java
package practice14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithoutRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ruleCnt = Integer.parseInt(sc.nextLine());
        Map<String,String> reps = new HashMap<>();
        String s[] = new String[2];
        ArrayList<String> rules = new ArrayList<>();
        while(ruleCnt>0){
            String inp = sc.nextLine();
            rules.add(inp);
            ruleCnt--;
        }

        String input = sc.next();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            boolean flag = false;

            for (String k:rules) {
                s = k.split(" ");
                if(i+s[0].length()<input.length()) {
                    String subkey = input.substring(i, i+s[0].length());
                    if (s[0].equals(subkey)) {
                        result.append(s[1]);
                        i += s[0].length() - 1;
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) result.append(input.charAt(i));
        }
        System.out.println(result);

    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice15/Main.java
```java
package practice15;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Structure struct = new Structure();
        struct.add(5);
        struct.InitState(0,struct.getState(1),1,struct.getState(4),2);
        struct.InitState(1,struct.getState(2),4,struct.getState(3),6);
        struct.InitState(2,struct.getState(3),6,struct.getState(4),2);
        struct.InitState(3,struct.getState(2),3,struct.getState(4),5);
        struct.InitState(4,struct.getState(0),5,struct.getState(2),3);

        struct.setCurrentState(struct.getState(0));
        ArrayList<Integer> path = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int currPath = sc.nextInt();
        while(currPath!=-1){
            path.add(currPath);
            currPath = sc.nextInt();
        }
        for (int cp:path) {
            struct.move(cp);
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice15/State.java
```java
package practice15;

public class State {
    private State[] next = new State[2];
    private int actions[] = new int[2];
    public State() {

    }

    public void setNext0(State next0, int action) {
        this.next[0] = next0;
        this.actions[0] = action;
    }

    public void setNext1(State next1, int action) {
        this.next[1] = next1;
        this.actions[1] = action;
    }

    public State getNext(int dir) {
        return next[dir];
    }

    public int[] getActions() {
        return actions;
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice15/Structure.java
```java
package practice15;

import java.util.ArrayList;

public class Structure {
    ArrayList<State> states = new ArrayList<>();
    State currentState = null;
    public Structure() {

    }
    public void add(int count){
        for (int i = 0; i < count; i++) {
            states.add(new State());
        }
    }
    public void InitState(int index, State next0,int action0, State next1, int action1){
        State st = states.get(index);
        st.setNext0(next0,action0);
        st.setNext1(next1,action1);
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void move(int dir){
        System.out.println(decodeAction(currentState.getActions()[dir]));
        currentState = currentState.getNext(dir);

    }

    public State getState(int index){
        return states.get(index);
    }

    public String decodeAction(int action){
        switch (action){
            case 1:
                return "create_project";
            case 2:
                return "add_library";
            case 3:
                return "restart";
            case 4:
                return "test";
            case 5:
                return "deploy";
            case 6:
                return "drop_db";
            default:
                return "";
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice16/Main.java
```java
package practice16;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    static PrintWriter pw;

    static {
        try {
            pw = new PrintWriter("Summary.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getContents(String path){
        File file = new File(path);
        if(file.isDirectory()){
            String[] contents = file.list();
            for (String s:contents) {
                getContents(path+"/"+s);
            }
        }
        if(file.isFile() ) {
            if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".java")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    System.out.println(file.getName());
                    pw.write("##### " + path + "\n```java\n");
                    String line = reader.readLine();
                    while (line != null) {
                        pw.write(line + "\n");
                        line = reader.readLine();
                    }
                    pw.write("```\n");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {
        Path filePath = Paths.get("").toAbsolutePath();
        getContents(filePath.toString()+"/src");
        pw.close();
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice2/Main.java
```java
package practice2;

import java.util.Vector;

class Shape{
    int a = 5;
    int b = 6;
    @Override
    public String toString() {
        return "Фигура."+a+" "+ b;
    }
}

class Ball{
    int a = 5;
    int b = 6;
    @Override
    public String toString() {
        return "Фигура."+a+" "+ b;
    }
}

class Book{
    int a = 5;
    int b = 6;
    @Override
    public String toString() {
        return "Фигура."+a+" "+ b;
    }
}

class Dog{
    String name;
    int age;
    Dog(String name_, int age_){
        name = name_;
        age = age_;
    }

    @Override
    public String toString() {
        return "Имя: "+name+"\nВозраст: "+age;
    }

    int toHumanAge(){return age*7;}

    void setAge(int age_) {age = age_;};
    void setName(String name_) {name = name_;};
    String getName() {return name;}
    int getAge(){return age;}
}

public class Main {
    static Vector<Dog> arrDog = new Vector<>();
    static void addDog(String name, int age){arrDog.add(new Dog(name,age));}
    public static void main(String[] args){
        Shape sh = new Shape();
        System.out.println(sh);
        addDog("Chuk",7);
        System.out.println(arrDog.firstElement());
        System.out.println(arrDog.firstElement().toHumanAge());
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice3/Main.java
```java
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
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice4/Main.java
```java
package practice4;

public class Main {

    public static void main(String[] args){
        Square sq = new Square(15,"red",true);
        System.out.println(sq);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice4/Shape.java
```java
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
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice5/Main.java
```java
package practice5;

import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Movable> objects = new LinkedList<>();
        objects.add(new MovableRectangle(5,5,10,15));
        MovableRectangle rect = new MovableRectangle(1,1,5,5);
        System.out.println(rect);
        rect.setHeight(9);
        System.out.println(rect);
    }

}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice5/Movable.java
```java
package practice5;

public interface Movable {
    void move(int dx,int dy);
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice5/MovableCircle.java
```java
package practice5;

public class MovableCircle extends Circle implements Movable {
    MovablePoint center;

    public MovableCircle(double x, double y, double radius) {
        super(radius);
        center = new MovablePoint(x,y);
    }

    public double getX() {
        return center.getX();
    }

    public void setX(double x) {
        center.setX(x);
    }

    public double getY() {
        return center.getY();
    }

    public void setY(double y) {
        center.setY(y);
    }

    @Override
    public void move(int dx,int dy) {
        center.move(dx,dy);
    }

}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice5/MovablePoint.java
```java
package practice5;

public class MovablePoint implements Movable {
    private double x,y;

    public MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void move(int dx,int dy) {
        x+=dx;
        y+=dy;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice5/MovableRectangle.java
```java
package practice5;

public class MovableRectangle implements Movable {
    private MovablePoint lUp, rDown;

    public MovableRectangle(double x1, double y1, double x2, double y2) {
        lUp = new MovablePoint(x1,y1);
        rDown = new MovablePoint(x2,y2);
    }

    public double getWidth(){
        return rDown.getX()-lUp.getX();
    }

    public double getHeight(){
        return rDown.getY()-lUp.getY();
    }

    public void setWidth(double width){
        rDown.setX(lUp.getX()+width);
    }

    public void setHeight(double height){
        rDown.setY(lUp.getY()+height);
    }

    @Override
    public void move(int dx, int dy) {
        lUp.move(dx,dy);
        rDown.move(dx,dy);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "lUp=" + lUp +
                ", rDown=" + rDown +
                '}';
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice5/Shape.java
```java
package practice5;

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
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice6/Main.java
```java
package practice6;

import java.util.Scanner;

public class Main {
    static double maximize(int[][] field){
        for (int i = 1; i < field.length; i++) {
            field[i][0] = field[i-1][0]+field[i][0];
            field[0][i] = field[0][i-1]+field[0][i];
        }
        for (int i = 1; i <field.length ; i++) {
            for (int j = 1; j <field.length ; j++) {
                field[i][j] = field[i][j]+Math.max(field[i][j-1],field[i-1][j]);
            }
        }
        return field[field.length-1][field.length-1];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] field = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = sc.nextInt();
            }
        }
        System.out.println(maximize(field));

    }

}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice7_8/Company.java
```java
package practice7_8;

import java.util.*;

public class Company {
    private List<Employee> employees = new LinkedList<>();
    private Vector<Integer> employeeId = new Vector<>();

    public Vector<Integer> getEmployeeId() { return employeeId; }

    public List<Employee> getEmployees() { return employees; }

    void hire(Employee employee){
        int id = (int)(Math.random()*10000);
        while(employeeId.contains(id)) id = (int)(Math.random()*10000);
        employee.setId(id);
        employeeId.add(id);
        employees.add(employee);
    };



    Employee getEmployeeById(int id){
        for (Employee emp:employees) {
            if(emp.getId() == id) return emp;
        }
        return null;
    }
    void hireAll(List<Employee> employeeList){
        for (Employee emp:employeeList) {
            hire(emp);
        }
    }

    void fire(int id){
        employees.remove(getEmployeeById(id));
        employeeId.remove((Integer)id);
    }

    double getIncome(){
        double income = 0;
        for (Employee employee:employees) {
            if(employee.getPosition() instanceof Manager){
                income+=((Manager) employee.getPosition()).getIncome();
            }
        }
        return income;
    }

    List<Employee> getTopSalaryStaff(int count){
        if(count<=0){
            System.out.println("Invalid employees number");
            return Collections.emptyList();
        }
        List<Employee> sEmp = new LinkedList<>(employees);
        Employee t;
        int i, j;
        for (i = 0; i < sEmp.size(); i++) {
            t = sEmp.get(i);
            for (j = i - 1; j >= 0 && sEmp.get(j).getEmployeeSalary() < t.getEmployeeSalary(); j--)
                sEmp.set(j+1,sEmp.get(j));
            sEmp.set(j+1,t);
        }
        return sEmp.subList(0,count);
    }
    List<Employee> getLowSalaryStaff(int count){
        if(count<=0){
            System.out.println("Invalid employees number");
            return Collections.emptyList();
        }
        List<Employee> sEmp = new LinkedList<>(employees);
        Employee t;
        int i, j;
        for (i = 0; i < sEmp.size(); i++) {
            t = sEmp.get(i);
            for (j = i - 1; j >= 0 && sEmp.get(j).getEmployeeSalary() > t.getEmployeeSalary(); j--)
                sEmp.set(j+1,sEmp.get(j));
            sEmp.set(j+1,t);
        }
        return sEmp.subList(0,count);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice7_8/Employee.java
```java
package practice7_8;

public class Employee{
    private String firstName,lastName;
    private double salary;
    private EmployeePosition position;
    private int id;

    public Employee(String firstName, String lastName, double salary, EmployeePosition position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getEmployeeSalary(){ return position.calcSalary(salary); }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + position.calcSalary(salary) +
                ", position=" + position +
                '}';
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice7_8/EmployeePosition.java
```java
package practice7_8;

public interface EmployeePosition {
    String getJobTitle();
    int calcSalary(double baseSalary);
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice7_8/Main.java
```java
package practice7_8;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company gogle = new Company();
        for (int i = 0; i < 180; i++) {
            EmployeePosition empPosition = new Operator(gogle);
            gogle.hire(new Employee("Michael", "Rykhlov", (int)(Math.random()*100000+50000),empPosition));
        }
        for (int i = 0; i < 80; i++) {
            EmployeePosition empPosition = new Manager(gogle);
            gogle.hire(new Employee("Micha", "Rykhlov", (int)(Math.random()*50000+50000),empPosition));
        }
        for (int i = 0; i < 10; i++) {
            EmployeePosition empPosition = new TopManager(gogle);
            gogle.hire(new Employee("Miki", "Rykhlov", (int)(Math.random()*200000+100000),empPosition));
        }
        System.out.println("\nTop salary staff:");
        List<Employee> tempEmployees = gogle.getTopSalaryStaff(15);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }

        System.out.println("\nLow salary staff:");
        tempEmployees = gogle.getLowSalaryStaff(30);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }

        int empSize = gogle.getEmployees().size();
        for (int i = 0; i < empSize; i++) {
            int id = gogle.getEmployeeId().get((int)(Math.random()*gogle.getEmployeeId().size()));
            gogle.fire(id);
        }

        System.out.println("\nTop salary staff after after dismissal:");
        tempEmployees = gogle.getTopSalaryStaff(15);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }

        System.out.println("\nLow salary staff after dismissal:");
        tempEmployees = gogle.getLowSalaryStaff(30);
        for (Employee emp: tempEmployees) {
            System.out.println(emp.getEmployeeSalary()+"   id = "+emp.getId() + "   "+emp.getPosition().getJobTitle());
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice7_8/Manager.java
```java
package practice7_8;

public class Manager implements EmployeePosition {
    private Company company;
    double income;
    public Manager(Company company) {
        income = Math.random()*25000+115000;
        this.company = company;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public int calcSalary(double baseSalary) {
        return (int)(baseSalary+0.05*income);
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice7_8/Operator.java
```java
package practice7_8;

public class Operator implements EmployeePosition {
    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }

    @Override
    public int calcSalary(double baseSalary) {
        return (int)baseSalary;
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice7_8/TopManager.java
```java
package practice7_8;

public class TopManager implements EmployeePosition {
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return getClass().getName();
    }

    @Override
    public int calcSalary(double baseSalary) {
        if(company.getIncome()>1e7) {
            return (int)(baseSalary*2.5);
        } else {
            return (int)baseSalary;
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice9/Company.java
```java
package practice9;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<>();
    public void hire(Employee employee){
        employees.add(employee);
    }
    public void hireAll(List<Employee> list){
        for (Employee emp:list) {
            hire(emp);
        }
    }

    public void fire(List<Employee> list){
        for (Employee emp:list) {
            employees.remove(emp);
        }
    }

    public void doSome(EmployeeSelector selector, EmployeeHandler handler){
        for (Employee emp:employees) {
            if (selector.isNeededEmployee(emp)) {
                handler.handleEmployees(emp);
            }
        }
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice9/Employee.java
```java
package practice9;

import java.time.LocalDate;

public class Employee {
    private final String firstName, lastName,address;
    private String phoneNumber;
    private int salary;
    private final LocalDate birthDate;

    public Employee(String firstName, String lastName, String address, String phoneNumber, int salary, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice9/EmployeeHandler.java
```java
package practice9;

import java.util.List;

public interface EmployeeHandler {
    void handleEmployees(Employee emp);
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice9/EmployeeSelector.java
```java
package practice9;

public interface EmployeeSelector {
    boolean isNeededEmployee(Employee emp);
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice9/Main.java
```java
package practice9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        List<Employee> testList = new ArrayList<>();
        Random rnd = new Random();
        String name;
        for (int i = 0; i < 100; i++) {
            name = "Katya";
            if(rnd.nextInt(10)>5) {
                name = "Angelina";
            }
            company.hire(new Employee( name,
                                       "Oronovskaya",
                                        "Moscow",
                                   "8920"+(rnd.nextInt(8999999)+1000000),
                                                rnd.nextInt(100000),
                                                LocalDate.of(rnd.nextInt(50)+1980,rnd.nextInt(11)+1, rnd.nextInt(27)+1)));
        }

        company.doSome(emp -> emp.getSalary()>10000, testList::add);
        for (Employee emp:testList) {
            System.out.println(emp);
        }

        company.doSome(new EmployeeSelector() {
            @Override
            public boolean isNeededEmployee(Employee emp) {
                return emp.getBirthDate().getYear() > 2000;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployees(Employee emp) {
                System.out.println("---.---");
                System.out.println(emp);
            }
        });

        company.doSome(new YearSelector(2010), new YearHandler());

    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice9/YearHandler.java
```java
package practice9;

public class YearHandler implements EmployeeHandler {

    @Override
    public void handleEmployees(Employee emp) {
        System.out.println(emp);
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/practice9/YearSelector.java
```java
package practice9;

public class YearSelector implements EmployeeSelector {
    private int year;

    public YearSelector(int year) {
        this.year = year;
    }

    @Override
    public boolean isNeededEmployee(Employee emp) {
        return emp.getBirthDate().getYear()>year;
    }
}
```
##### C:\Users\Admin\IdeaProjects\Java_IVBO-07/src/Sdacha/Main.java
```java
package Sdacha;

import java.util.Scanner;

public class Main {
    static int solve(int n) {
        int cnt = 0;
        for (int i = n / 5; i >= 0; i--) {
            for (int j = (n - i * 5) / 3; j >= 0; j--) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
```
