package ai0402;

import java.util.Scanner;

public class Pound {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("파운드(lb)를 입력하시오 :  ");
        int num1 = s.nextInt();

        System.out.printf("%d 파운드(lb)는 %.2f킬로그램(kg)입니다.\n", num1, num1 * 0.45359237);

        System.out.print("킬로그램(kg)를 입력하시오 :  ");
        int num2 = s.nextInt();

        System.out.printf("%d 킬로그램(kg)는 %.2f파운드(lb)입니다.\n", num2, num2 * 2.20462262);
    }
}
