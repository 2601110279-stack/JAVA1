package ai0618;

public class Tank implements Car, Cannon {
    @Override
    public void fire() {
        System.out.println("발사한다.");
    }
    @Override
    public void move() {
        System.out.println("탱그가 이동한다.");
    }
}
