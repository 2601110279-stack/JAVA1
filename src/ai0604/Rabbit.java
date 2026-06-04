package ai0604;

public class Rabbit {
//    private String shape;
//    private int x;
//    private int y;
    public static int count;
    public String shape;
    public int x;
    public int y;

    public Rabbit() {
        count++;
    }

//  default(생략) 제한자는 같은 패키지내에서만 접근이 가능
//    String shape;
//    int x;
//    int y;

//    public String getShape() {
//        return shape;
//    }

//    public void setShape(String shape) {
//        this.shape = shape;
//    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void printInfo(){
        System.out.printf("모양의 토끼는 (%d,%d)좌표에 있음.\n", shape, x, y);
    }
}
