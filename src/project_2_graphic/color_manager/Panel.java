package project_2_graphic.color_manager;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel extends JPanel {

    public Panel() {
        super();
    }

    Color color = new Color(255, 255, 255);

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g){
        repaint();
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0,this.getWidth() , this.getHeight());
    }
}

