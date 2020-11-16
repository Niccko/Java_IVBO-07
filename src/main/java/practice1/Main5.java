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