import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Asteroid extends Polygon {
    Random random1 = new Random();
    Random random2 = new Random();
    Random random3 = new Random();
    Random random4 = new Random();
    double rotation1 = random1.nextDouble(800);
    double rotation2= random2.nextDouble(600);


    public void paint(Graphics brush) {
        brush.setColor(Color.white);
        int[] x = new int[getPoints().length];
        int[] y = new int[getPoints().length];
        Point[] points = getPoints();
        for (int i = 0; i < getPoints().length; i++) {
            x[i] = (int) points[i].x;
            y[i] = (int) points[i].y;
        }
        brush.fillPolygon(x, y, getPoints().length);
    }

    public void accelerate(double acceleration) {
        position.y -= (acceleration * Math.cos(Math.toRadians(rotation1)));
        position.x += (acceleration * Math.sin(Math.toRadians(rotation2)));
    }

    public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
        super(inShape, inPosition, inRotation);
    }
    public void move(){

        accelerate(2);
        if(position.x<-1){
            position.x= 800;
            position.y= random1.nextInt(800);
        } else if (position.x>801) {
            position.x=0;
            position.y= random2.nextInt(600);

        } else if (position.y < -1) {
            position.y= 600;
            position.x= random3.nextInt(600);
        } else if (position.y>600) {
            position.y = 0;
            position.x= random4.nextInt(800);
        }
    }

}