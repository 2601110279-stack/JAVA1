package ai0409;

import java.util.Scanner;

public class java_test {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("자바 점수 : ");
        double num1 = s.nextDouble();

        System.out.print("모바일 점수 : ");
        double num2 = s.nextDouble();

        System.out.print("엑셀 점수 : ");
        double num3 = s.nextDouble();

        double avg = (num1 * 3 + num2 * 3 + num3 * 2) / (3 + 3 + 2);

        System.out.printf("3과목 학점 평균 점수 : %.2f\n", avg);

        s.close();
    }
}