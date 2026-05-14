package ai0514;

import java.util.Scanner;

public class BmiTest2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        String result;

        while (true) {
            System.out.println(("이름을 입력하시오.(exit : 프로그램 종료) : "));
            String name = s.nextLine();
            if (name.equals("exit"))
                break; // 이제 while문 안이므로 정상 작동합니다.


            System.out.println(("체중(kg, 실수값)를 입력하시오. : "));
            double weight = s.nextDouble();

            System.out.println(("키(cm, 실수값)를 입력하시오. : "));
            double height = s.nextDouble();

            double bmi = weight / Math.pow(height / 100, 2);//((height/100)*(height/100))

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
            s1.close();
        }
    }
}
