package ai0611.abstractTest;

abstract class Person {
    String name;
    int weight;
    int height;

    public void Person() {

    }

    public void eat(String food) {
        System.out.println(food + "를 먹는다.");
    }

    public void sleep(int hour) {
        System.out.println(hour + "시간 잔다.");
    }

    abstract void study();
}
