import java.awt.*;

public class Bullet extends Circle{

    private int x_velocity, y_velocity;
    public boolean isFired;

    public Bullet(Point point, int radius, int x_velocity, int y_velocity) {
        this.center = point;
        this.radius = radius;
        this.x_velocity = x_velocity;
        this.y_velocity = y_velocity;
        this.isFired= false;
    }

    public void move() {
        if(isFired){
            center.x += x_velocity;
            center.y += y_velocity;
        }

    }

    public void paint(Graphics brush) {
        super.paint(brush);
    }


}
