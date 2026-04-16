package ai0402;

import java.util.Scanner;

public class true_or_false {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("운전면허 시점 점수 : ");
        int num1 = s.nextInt();

        String result = "";

        if(num1 >= 70)
            result = "합격";
        else
            result = "불합격";

        System.out.println("====운전면허 시점 결과====");

        System.out.printf("%s입니다.", result);
        s.close();
    }
}
