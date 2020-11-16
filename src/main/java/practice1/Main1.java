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
