package practice5;

public class MovableCircle extends Circle implements Movable {
    private double x,y;
    MovablePoint center;

    public MovableCircle(double x, double y, double radius) {
        super(radius);
        this.x = x;
        this.y = y;
        center = new MovablePoint(x,y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void move(int dx,int dy) {
        center.move(dx,dy);
    }

}
