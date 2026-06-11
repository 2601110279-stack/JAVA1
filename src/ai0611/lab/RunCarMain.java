package ai0611.lab;

import ai0611.lab.subcar.SchoolBus;
import ai0611.lab.subcar.SportsCar;

import java.util.Scanner;

public class RunCarMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int speed = 0;

        SchoolBus schoolBus = new SchoolBus("스쿨버스", 0);
        SportsCar sportsCar = new SportsCar("스포츠카", 0);

        while (true) {
            System.out.print("가속할 속도 입력(종료는 -1 입력): ");
            speed = scanner.nextInt();

            if (speed == -1) {
                break;
            }

            schoolBus.upSpeed(speed);
            sportsCar.upSpeed(speed);

            System.out.printf("☆ 스쿨버스의 현재 속도: %d\n", schoolBus.getSpeed());
            System.out.printf("☆ 스포츠카의 현재 속도: %d\n", sportsCar.getSpeed());
        }

        scanner.close();
    }
}
