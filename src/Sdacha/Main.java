package Sdacha;

import java.util.Scanner;

public class Main {
    static int solve(int n) {
        int cnt = 0;
        for (int i = n / 5; i >= 0; i--) {
            for (int j = (n - i * 5) / 3; j >= 0; j--) {
                for (int k = n - j * 3 - i * 5; k >= 0; k--) {
                    if (i * 5 + j * 3 + k == n) cnt++;
                }
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