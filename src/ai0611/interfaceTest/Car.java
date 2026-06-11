package ai0611.interfaceTest;

public interface Car {
    // 상수 필드, public static final 생략 가능(JVM이 없으면 알아서 자동으로 붙여서 사용)
    public static final String PRODUCT = "기아";
    String ADDRESS = "서울시 서초구 양재동 기아빌딩";

    public void start();
    public void stop();
    public void upSpeed(int speed);
    public void downSpeed(int speed);
    public void rotate(String dir);
    public void forward();
    public void backward();
}
