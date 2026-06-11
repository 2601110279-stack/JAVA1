package ai0611.lab.car;

public class Car {
    final String carName;
    protected int speed;

    public Car(String carName, int initSpeed) {
        this.carName = carName;
        this.speed = initSpeed;
    }

    public String getCarName() {
        return carName;
    }

    public int getSpeed() {
        return speed;
    }

    public void upSpeed(int speed) {
        this.speed += speed;
    }
}
