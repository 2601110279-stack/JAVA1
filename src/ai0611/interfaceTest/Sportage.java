package ai0611.interfaceTest;

public class Sportage implements Car{
    public String carName = "스포티지";
    public int speed;

    @Override
    public void start() {
        System.out.println(carName + "자동차의 시동을 건다.");
    }

    @Override
    public void stop() {
        System.out.println(carName + "자동차를 멈춘다.");
    }

    @Override
    public void upSpeed(int speed) {
        this.speed += speed;
        System.out.println(carName + "자동차의 가속된 현재 속도는 " + this.speed + "입니다.");
    }

    @Override
    public void downSpeed(int speed) {
        this.speed -= speed;
        System.out.println(carName + "자동차의 감속된 현재 속도는 " + this.speed + "입니다.");
    }

    @Override
    public void rotate(String dir) {
        System.out.println(carName + "자동차의 현재 방향은 " + dir + "입니다.");
    }

    @Override
    public void forward() {

    }

    @Override
    public void backward() {

    }
}
