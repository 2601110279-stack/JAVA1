package ai0611.interfaceTest;

public class RunCar {
    public static void main(String[] args) {
        // 인터페이스는 추상 클래스처럼 new 연산자로 객체(인스턴스) 생성이 불가능 합니다.
        Sportage sportage = new Sportage();

        System.out.println(Car.PRODUCT);
        System.out.println(Car.ADDRESS);
        sportage.start();
        sportage.upSpeed(50);
        sportage.downSpeed(10);
        sportage.rotate("우");
        sportage.stop();
    }
}
