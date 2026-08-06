import java.awt.*;

public class Circle extends Shape {
    int radius =5;
    Point center = new Point(0,0);

    public boolean contains(Point point){
        for (int i = 0; i < 12; i++) {
            double theta = Math.toRadians(i * 30);
            int x = (int) (center.x + radius * Math.cos(theta));
            int y = (int) (center.y + radius * Math.sin(theta));

            if (point.x - x == 0 && point.y - y == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    boolean intersect(Shape shape) {
        return false;
    }

    public void paint(Graphics brush) {
        brush.setColor(Color.WHITE);
        for (int i = 0; i < 12; i++) {
            double theta = Math.toRadians(i * 30);
            int x = (int) (center.x + radius * Math.cos(theta));
            int y = (int) (center.y + radius * Math.sin(theta));
            brush.drawOval((int) (center.x), (int) (center.y), radius * 2, radius * 2);

        }
    }
}
