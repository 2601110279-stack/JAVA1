package ai0521.rabbit;

public class rabbit {
    private String shape;
    private int xPos;
    private int yPos;

    void setPsition(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public rabbit() {
    }

    public rabbit(String shape, int xPos, int yPos) {
        this.shape = shape;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}

