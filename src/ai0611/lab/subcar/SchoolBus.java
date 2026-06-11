package ai0611.lab.subcar;

import ai0611.lab.car.Car;

public class SchoolBus extends Car {
    public SchoolBus(String carName, int initSpeed) {
        super(carName, initSpeed);
    }

    @Override
    public void upSpeed(int speed) {
        super.upSpeed(speed);
        if (this.speed > 200) {
            this.speed = 200;
        }
    }
}
