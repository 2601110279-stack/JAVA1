package ai0521.rabbit;

public class RunRabbit {
    public static void main(String[] args) {
        Rabbit rabbit1 = new Rabbit();
        Rabbit rabbit2 = new Rabbit("좁은 네모");

        rabbit1.setLocation(50, 50);
        rabbit2.setLocation(150, 70);

        rabbit1.setShape("기본");
        rabbit1.printInfo();
        rabbit2.printInfo();

        //기본 모양의 토끼를 다이아몬드 모양의 토끼로 변경, 위치는 현재 x좌표에서 오른쪽으로 60 이동, y좌표는 아래쪽으로 20 이동한 후 출력
        rabbit1.setShape("다이아몬드");
        rabbit1.setxPos(rabbit1.getxPos() + 60);
        rabbit1.setyPos(rabbit1.getyPos() + 20);
        rabbit1.printInfo();

        // 좁은 네모 모양의 토끼가 현재 위치에서 오른쪽으로 50만큼, 왼쪽으로 20만큼 이동
        rabbit2.printInfo();// 좁은 네모 현재위치 출력
        for (int i = 0; i < 5; i++){
            rabbit2.moveRightTen();// 10씩 5번 오른쪽 이돈
        }
        rabbit2.printInfo();// 좁은 네모 현재위치 출력

        for (int i = 0; i < 2; i++){
            rabbit2.moveLeftTen();// 10씩 2번 왼쪽 이동
        }
        rabbit2.printInfo();// 좁은 네모 현재위치 출력
    }
}
