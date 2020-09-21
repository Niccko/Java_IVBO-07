package practice5;

public class MovableRectangle implements Movable {
    private MovablePoint lUp, rDown;

    public MovableRectangle(double x1, double y1, double x2, double y2) {
        lUp = new MovablePoint(x1,y1);
        rDown = new MovablePoint(x2,y2);
    }

    @Override
    public void move(int dx, int dy) {
        lUp.move(dx,dy);
        rDown.move(dx,dy);
    }
}
