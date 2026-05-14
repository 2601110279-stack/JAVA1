package ai0514;

import java.util.Scanner;

public class WhileTest02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum;
        int num1, num2;

        while(true){
            System.out.print("숫자 1 ==>");
            num1 = s.nextInt();
            if(num1 == -1)
                break;

            System.out.print("숫자 2 ==>");
            num2 = s.nextInt();

            sum = num1 + num2;
            System.out.printf("%d + %d = %d\n", num1, num2, sum);
        }
        s.close();
    }
}
