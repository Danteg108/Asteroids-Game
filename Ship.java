import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class Ship extends Polygon implements KeyListener  {
    Bullet bullets[];
    public Ship(Point[] inShape, Point inPosition, double inRotation, Bullet bullets[]) {
        super(inShape, inPosition, inRotation);
        this.bullets = bullets;
    }


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

    double x_velocity=0;
    double y_velocity=0;
    double friction = 0.98;
    Point pull = new Point(0,0);

    public void accelerate(double acceleration) {
        pull.y -= (acceleration * Math.cos(Math.toRadians(rotation)));
        pull.x += (acceleration * Math.sin(Math.toRadians(rotation)));

    }

    Random random = new Random();

    boolean wPress;
    boolean aPress;
    boolean dPress;

    public void move() {

        if (wPress) {
            accelerate(0.8);
        }

        x_velocity += pull.x;
        y_velocity += pull.y;
        position.x += x_velocity;
        position.y += y_velocity;
        x_velocity *= friction;
        y_velocity *= friction;
        pull.x = 0;
        pull.y = 0;

        if(dPress){
            rotation+=10;
        }
        if(aPress)
            rotation-=10;


        if(position.x<0){
            position.x= 800;
        } else if (position.x>800) {
            position.x=0;

        } else if (position.y < 0) {
            position.y= 600;
        } else if (position.y>600) {
            position.y = 0;
        }
    }

    @Override
    public void keyTyped (KeyEvent e){

    }

    @Override
    public void keyPressed (KeyEvent e){
        int key = e.getKeyCode();
        switch (key) {
            case (KeyEvent.VK_W):
                wPress = true;
                break;
            case (KeyEvent.VK_A):
                aPress = true;
                break;
            case(KeyEvent.VK_D):
                dPress = true;
                break;

            case(KeyEvent.VK_SPACE):
                int bullet_XVelocity = (int) (5 * Math.sin(Math.toRadians(rotation)));
                int bullet_YVelocity = (int) (-5 * Math.cos(Math.toRadians(rotation)));

                for (int i = 0; i < bullets.length; i++) {
                    if (!bullets[i].isFired && bullets[i]!= null) {
                        bullets[i] = new Bullet(new Point(position.x, position.y), 5, bullet_XVelocity, bullet_YVelocity);
                        bullets[i].isFired = true;
                        break;
                    }
                }
        }
    }


    @Override
    public void keyReleased (KeyEvent e){
        int key = e.getKeyCode();
        switch (key) {
            case (KeyEvent.VK_W):
                wPress = false;
                break;
            case (KeyEvent.VK_A):
                aPress = false;
                break;
            case (KeyEvent.VK_D):
                dPress = false;
                break;
            case(KeyEvent.VK_SPACE):
                break;


        }
    }
}

