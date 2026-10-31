import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel {

    public Main() {
        setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Square Fractal");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setLocationRelativeTo(null);
        frame.add(new Main());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1.5f));

        int size = 180*2;
        int depth = 7;

        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        drawSquare(g2, x, y, size, depth, -1);
    }

    static void drawSquare(Graphics2D g, double x, double y, double size, int depth, int parentDirection) {

        if (depth > 0 && size >= 2) {
            double newSize = size / 2;

            // дочерние квадраты
            double[][] positions = {
                {x - size / 4,    y - size / 4},       // верхний левый
                {x + size * 0.75, y - size / 4},       // верхний правый
                {x + size * 0.75, y + size * 0.75},    // нижний правый
                {x - size / 4,    y + size * 0.75}     // нижний левый
            };

            for (int i = 0; i < 4; i++) {
                if (parentDirection != -1 && // пропускаем угол от родителя
                    i == (parentDirection + 2) % 4) {
                    continue;
                }

                drawSquare(
                    g,
                    positions[i][0],
                    positions[i][1],
                    newSize,
                    depth - 1,
                    i
                );
            }
        }


        g.setColor(g.getBackground());
        g.fillRect((int) x, (int) y, (int) size, (int) size);

        g.setColor(Color.BLACK);
        g.drawRect((int) x, (int) y, (int) size, (int) size);
    }
}
