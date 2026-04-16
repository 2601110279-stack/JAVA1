package ai0326;

import java.util.Scanner;

public class BMItest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);//문자열 입력용

        System.out.println(("이름을 입력하시오. : "));
        String name = s.nextLine();

        System.out.println(("체중(kg, 실수값)를 입력하시오. : "));
        double weight = s.nextDouble();

        System.out.println(("키(cm, 실수값)를 입력하시오. : "));
        double height = s.nextDouble();

        double bmi = weight / Math.pow(height/100, 2);//((height/100)*(height/100))

        System.out.printf("* %s님 BMI 지수 결과: %.2fkg/㎡", name, bmi);

        s.close();
        s1.close();
    }
}
