package project_2_graphic.color_manager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Cube extends JPanel {
    public Cube() {
        super();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;

        int a = 280;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                Color c = new Color(255, j, i);
                g.setColor(c);
                g.fillRect(j + 25, getHeight() - (i + 25), 1, 1);

                c = new Color(i, j, 255);
                g.setColor(c);
                g.fillRect(j + 13 + a / 2, getHeight() - (408 - i / 2), 1, 1);

                c = new Color(255 - j, 255, i);
                g.setColor(c);
                g.fillRect(j / 2 + 280, getHeight() - (i + j / 2 + 25), 1, 1);
            }

            a--;
        }
    }
}
