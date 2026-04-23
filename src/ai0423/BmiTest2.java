package ai0423;

import java.util.Scanner;

public class BmiTest2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String result;

        System.out.println(("이름을 입력하시오. : "));
        String name = s.nextLine();

        System.out.println(("체중(kg, 실수값)를 입력하시오. : "));
        double weight = s.nextDouble();

        System.out.println(("키(cm, 실수값)를 입력하시오. : "));
        double height = s.nextDouble();

        double bmi = weight / Math.pow(height/100, 2);//((height/100)*(height/100))

        if (bmi < 18.5) {
            result = "저체중";
        } else if (bmi <= 22.9) {
            result = "정상";
        } else if (bmi <= 24.9) {
            result = "위험체중";
        } else if (bmi <= 29.9) {
            result = "1단계 비만";
        } else {
            result = "2단계 비만";
        }

        System.out.printf("* %s님의 BMI 지수: %.2f (결과: %s)\n", name, bmi, result);

        s.close();
    }
}
