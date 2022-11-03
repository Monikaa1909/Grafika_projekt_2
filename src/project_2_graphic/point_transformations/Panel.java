/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_2_graphic.point_transformations;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bartek
 */
public class Panel extends JPanel{
    
    BufferedImage img = null;

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
        this.repaint();
    }
    
    public Panel() {
        super();
    }
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(img != null){
            g2d.drawImage(img, null, 0,0);
        }
        
    }

    @Override
    public Dimension preferredSize() {
        if(img!=null)
            return new Dimension(img.getWidth(), img.getHeight());
        else
            return new Dimension(640 , 480);
    }
    
    
    
}

