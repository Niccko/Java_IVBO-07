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
