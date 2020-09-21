package practice5;

public class MovableRectangle implements Movable {
    private MovablePoint lUp, rDown;

    public MovableRectangle(double x1, double y1, double x2, double y2) {
        lUp = new MovablePoint(x1,y1);
        rDown = new MovablePoint(x2,y2);
    }

    public double getWidth(){
        return rDown.getX()-lUp.getX();
    }

    public double getHeight(){
        return rDown.getY()-lUp.getY();
    }

    public void setWidth(double width){
        rDown.setX(lUp.getX()+width);
    }

    public void setHeight(double height){
        rDown.setY(lUp.getY()+height);
    }

    @Override
    public void move(int dx, int dy) {
        lUp.move(dx,dy);
        rDown.move(dx,dy);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "lUp=" + lUp +
                ", rDown=" + rDown +
                '}';
    }
}
