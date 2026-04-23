package ai0423;

import java.util.Scanner;

public class AgeTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("PC방 사용가능 나이 입력 : ");
        int age = s.nextInt();

        if(age >= 19) {
            System.out.println("즐거운 시간 보내세요^^");
        }
        else {
            System.out.println("꺼저라 꼬맹아");
        }

        s.close();
    }
}
