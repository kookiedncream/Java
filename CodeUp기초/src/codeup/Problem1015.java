package codeup;

import java.util.Scanner;

public class Problem1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float f = sc.nextFloat();
        String str = String.format("%.2f", f);

        System.out.println(str);
    }
}
