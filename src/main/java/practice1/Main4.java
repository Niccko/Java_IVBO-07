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