package ai0514;

import java.util.Random;
import java.util.Scanner;

public class RandomTest01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = 1;
        int num = 0;
        int computerNum = 0;
        Random random = new Random();

        while(true){
            computerNum = random.nextInt(5) + 1;
            System.out.print("게임" + i + ": 컴퓨터가 생각한 숫자는? ");
            num = s.nextInt();
            if(computerNum == num){
                System.out.println("맞췄네요!!!");
                break;
            }
            System.out.println("아깝네요." + computerNum + "였는데... 다시 시도 하세요!!");
            i++;
        }
        System.out.println("게임을 마칩니다.");
        s.close();
    }
}
