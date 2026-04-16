package ai0402;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("정수1 입력 : ");
        int num1 = s.nextInt();
        System.out.print("정수2 입력 : ");
        int num2 = s.nextInt();

        System.out.print("======계산결과======\n");
        System.out.printf("Plus : %d + %d = %d\n", num1, num2, num1 + num2 );
        System.out.printf("Minus :  %d - %d = %d\n", num1, num2, num1 - num2 );
        System.out.printf("Multiply : %d × %d = %d\n", num1, num2, num1 * num2 );
        System.out.printf("Division :  %d ÷ %d = %.2f\n", num1, num2, (double)num1 / num2 );
        System.out.printf("Other :  %d %% %d = %d\n", num1, num2, num1 % num2 );
    }
}
