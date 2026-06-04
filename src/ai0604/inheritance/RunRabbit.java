package ai0604.inheritance;

public class RunRabbit {
    public static void main(String[] args) {
        HouseRabbit hr1 = new HouseRabbit();
        hr1.shape = "동그라미";
        hr1.setLocation(30, 50);
        hr1.moveRightTen();
        hr1.printInfo();
        hr1.masterName = "폴리";
        hr1.eatFeed("아주 좋은");

        MountainRabbit hr2 = new MountainRabbit();
        hr2.shape = "네모";
        hr2.setLocation(30, 50);
        hr2.moveLeftTen();
        hr2.printInfo();
        hr2.mountainName = "정발산";
        hr2.eatGrass("잡초");
    }
}
