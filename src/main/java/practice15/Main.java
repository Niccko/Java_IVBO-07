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
