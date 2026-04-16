package ai0326;

import java.util.Scanner;

public class LAB1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        System.out.println("##  택배 보내기입니다. 다음을 각각 입력하세요  ##");

        System.out.println(("받는 사람 : "));
        String name = s.nextLine();

        System.out.println(("주소 : "));
        String add = s.nextLine();

        System.out.println(("무게 : "));
        int weight = s.nextInt();


        System.out.println("** 받는 사람 ==> " + name);
        System.out.println("** 주소 ==> " + add);
        System.out.println("** 배송비 ==> " + (weight*5));

        s.close();
        s1.close();
    }
}
