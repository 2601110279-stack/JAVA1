package ai0326;

import java.util.Calendar;
import java.util.Scanner;

public class AgeTest {
    public static void main(String[] args) {
        System.out.println("======나이 계산======");
        Scanner s = new Scanner(System.in);
        System.out.println("출생년도(4자리)를 입력하시요. :");
        int birthYear = s.nextInt();
        // 현재년도 구하기
        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);

        int age = nowYear - birthYear;

        System.out.print("당신의 나이는" + age + "입니다.");
        s.close();

    }
}
