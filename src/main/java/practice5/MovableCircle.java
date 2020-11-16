package practice5;

public class MovableCircle extends Circle implements Movable {
    MovablePoint center;

    public MovableCircle(double x, double y, double radius) {
        super(radius);
        center = new MovablePoint(x,y);
    }

    public double getX() {
        return center.getX();
    }

    public void setX(double x) {
        center.setX(x);
    }

    public double getY() {
        return center.getY();
    }

    public void setY(double y) {
        center.setY(y);
    }

    @Override
    public void move(int dx,int dy) {
        center.move(dx,dy);
    }

}
