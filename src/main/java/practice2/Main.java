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
