package practice5;

public class MovableCircle implements Movable {
    private double x,y,xSpeed,ySpeed,radius;
    MovablePoint center;

    public MovableCircle(double x, double y, double xSpeed, double ySpeed, double radius) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.radius = radius;
        center = new MovablePoint(x,y,xSpeed,ySpeed);
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }
}
