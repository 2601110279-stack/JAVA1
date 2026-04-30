package ai0430;

import java.util.Scanner;

public class LAB_Switch {
    public static void main(String[] args) {
        //출생년도를 입력받는다.
        Scanner s = new Scanner(System.in);
        System.out.println("====== 출생년도에 따른 12간지 ======");
        System.out.print("출생년도 입력 : ");
        int birthYear = s.nextInt();
        String animal = "";

        switch (birthYear%12){
            case 0 :
                animal = "원숭이 띠"; break;
            case 1 :
                animal = "닭 띠"; break;
            case 2 :
                animal = "개 띠"; break;
            case 3 :
                animal = "돼지 띠"; break;
            case 4 :
                animal = "쥐 띠"; break;
            case 5 :
                animal = "소 띠"; break;
            case 6 :
                animal = "호랑이 띠"; break;
            case 7 :
                animal = "토끼 띠"; break;
            case 8 :
                animal = "용 띠"; break;
            case 9 :
                animal = "뱀 띠"; break;
            case 10 :
                animal = "말 띠"; break;
            case 11 :
                animal = "양 띠"; break;
            default:
                animal = "잘못된 출생년도입니다.";
        }

        System.out.printf("출생년도 %d생은 %s 입니다.", birthYear, animal);

        s.close();
    }
}
