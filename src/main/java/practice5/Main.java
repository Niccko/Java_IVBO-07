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
