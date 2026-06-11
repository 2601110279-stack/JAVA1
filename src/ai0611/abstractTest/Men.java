package ai0611.abstractTest;

public class Men extends Person {
    // 추상 클래스를 상속 받으려면
    // - 추상 메소드를 구현하거나 현재 클래스가 추상클래스여야한다.
    @Override
    void study() {
        System.out.println("딸이 공부를 열심히 한다.");
    }
}
