import java.awt.*;
import java.util.Random;


class Asteroids extends Game {
    private Ship ship;
    private Asteroid[] asteroid = new Asteroid[6];
    private Bullet[] bullets = new Bullet[30];
    private Star[] stars = new Star[50];
    Random random1 = new Random();
    Random random2 = new Random();



    public Asteroids() {
        super("Asteroids!", 800, 600);
        ship = new Ship(new Point[]{new Point(0, -45),
                new Point(15, 0),
                new Point(0, -10),
                new Point(-15, 0),
                new Point(0, -45),
        }
                , new Point(400, 400), 0, bullets);
        addKeyListener(ship);
        repaint();
        for(int i=0; i<asteroid.length; i++){
            asteroid[i] = new Asteroid(new Point[]{
                    new Point(0, -50), new Point(25, -45),
                    new Point(40, -30), new Point(30, -15),
                    new Point(20, 0), new Point(5, 10),
                    new Point(-15, 20), new Point(-30, 10),
                    new Point(-40, -20), new Point(-35, -40),
                    new Point(-30, -60), new Point(-10, -55),
                    new Point(0, -50)

            }, new Point(900, 700), 0);
            repaint();
        }

        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet(new Point(0, 0), 5, 0, 0);
        }
        for(int i =0; i<stars.length; i++){
            int starPositionX= random1.nextInt(800);
            int starPositionY= random2.nextInt(600);
            stars[i]= new Star(new Point(starPositionX,starPositionY), 2);
        }

    }

    public void paint(Graphics brush) {
        brush.setColor(Color.black);
        brush.fillRect(0, 0, width, height);
        if (ship != null) {
            ship.paint(brush);
            ship.move();
        }
        Point[] points;
        for (int i = 0; i < asteroid.length; i++) {
            if (asteroid[i] != null) {
                asteroid[i].paint(brush);
                asteroid[i].move();

                if (ship.intersect(asteroid[i])) {
                    ship.position = new Point(400, 400);

                }
            }
        }

         
       for(int i =0; i< bullets.length; i++) {
           if (bullets[i] != null && bullets[i].isFired) {
                   bullets[i].paint(brush);
                   bullets[i].move();
               }

               for (int j = 0; j < asteroid.length; j++) {
               if (asteroid[j] != null) {
                   points = asteroid[j].getPoints();
                   for (int k = 0; k < points.length; k++) {
                       if (bullets[i].contains(points[k])) {
                           asteroid[j] = null;
                       }
                   }
               }
           }
       }
       for(int i =0; i< stars.length; i++){
           if(stars[i]!=null) {
               stars[i].paint(brush);
           }
       }
    }

    public static void main (String[]args){
        new Asteroids();
    }
}


