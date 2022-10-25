package project_2_graphic.color_manager;


import project_2_graphic.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorManager extends javax.swing.JFrame implements ChangeListener {

    public ColorManager() {
        initComponents();
    }

    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        Container container = getContentPane();
        jPanel1 = new javax.swing.JPanel();
        JButton backButton = new JButton("Back");
        backButton.setVisible(true);
        backButton.addActionListener(new BackListener());
        yellow = new CMYKSlider();
        blue = new RGBSlider();
        jLabel2 = new javax.swing.JLabel();
        RGBpanel = new Panel();
        magenta = new CMYKSlider();
        cyan = new CMYKSlider();
        black = new CMYKSlider();
        green = new RGBSlider();
        red = new RGBSlider();

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        CMYKbox = new javax.swing.JRadioButton();
        RGBbox = new javax.swing.JRadioButton();
        blackText = new javax.swing.JTextField();
        cyanText = new javax.swing.JTextField();
        magentaText = new javax.swing.JTextField();
        yellowText = new javax.swing.JTextField();
        redText = new javax.swing.JTextField();
        greenText = new javax.swing.JTextField();
        blueText = new javax.swing.JTextField();

//        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
//        jPanel3.setLayout(jPanel3Layout);
//        jPanel3Layout.setHorizontalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );
//        jPanel3Layout.setVerticalGroup(
//                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGap(0, 100, Short.MAX_VALUE)
//        );
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RGBpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout RGBpanelLayout = new javax.swing.GroupLayout(RGBpanel);
        RGBpanel.setLayout(RGBpanelLayout);
        RGBpanelLayout.setHorizontalGroup(
                RGBpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 209, Short.MAX_VALUE)
        );
        RGBpanelLayout.setVerticalGroup(
                RGBpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 130, Short.MAX_VALUE)
        );

        blue.setMaximum(255);
        blue.setValue(255);

        green.setMaximum(255);
        green.setValue(255);

        red.setMaximum(255);
        red.setValue(255);

        black.setMaximum(100);
        black.setValue(0);

        cyan.setMaximum(100);
        cyan.setValue(0);

        magenta.setMaximum(100);
        magenta.setValue(0);

        yellow.setMaximum(100);
        yellow.setValue(0);

        jLabel3.setText("R:");

        jLabel4.setText("G:");

        jLabel5.setText("B:");

        jLabel6.setText("Black:");

        jLabel7.setText("Cyan:");

        jLabel8.setText("Magenta:");

        jLabel9.setText("Yellow:");

        CMYKbox.setText("CMYK to RGB");
        CMYKbox.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CMYKboxActionPerformed(evt);
            }
        });

        RGBbox.setText("RGB to CMYK");
        RGBbox.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RGBboxActionPerformed(evt);
            }
        });

        blackText.setText("0");

        cyanText.setText("0");

        magentaText.setText("0");

        yellowText.setText("0");

        redText.setText("255");

        greenText.setText("255");

        blueText.setText("255");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(green, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                )
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(37, 37, 37)
                                                                .addComponent(RGBbox)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2))
                                                        .addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(black, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(blueText)
                                                                        .addComponent(greenText)
                                                                        .addComponent(redText, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel7)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(cyan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel8)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(magenta, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(yellow, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cyanText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(blackText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(magentaText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(yellowText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(CMYKbox)
                                                .addGap(78, 78, 78))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(RGBpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(RGBpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(black, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel6)
                                                                                        .addComponent(blackText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(cyan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(jLabel7)
                                                                                                .addComponent(redText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(cyanText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(magenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(jLabel4)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel8)
                                                                                .addComponent(greenText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addComponent(magentaText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(yellow, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(blue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(blueText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel5)))
                                        .addComponent(yellowText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(CMYKbox)
                                        .addComponent(RGBbox))
                                        .addComponent(backButton)
                                .addContainerGap())
        );

        container.add(jPanel1);
        pack();
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainWindow o = new MainWindow();
            o.setVisible(true);
        }
    }

    private void CMYKboxActionPerformed(java.awt.event.ActionEvent evt) {
        cyan.addChangeListener(this);
        magenta.addChangeListener(this);
        yellow.addChangeListener(this);
        black.addChangeListener(this);
        red.removeChangeListener(this);
        green.removeChangeListener(this);
        blue.removeChangeListener(this);
    }

    private void RGBboxActionPerformed(java.awt.event.ActionEvent evt) {
        red.addChangeListener(this);
        green.addChangeListener(this);
        blue.addChangeListener(this);
        cyan.removeChangeListener(this);
        magenta.removeChangeListener(this);
        yellow.removeChangeListener(this);
        black.removeChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if ("RGBSlider".equals(e.getSource().getClass().getSimpleName())) {
            rgbToCmyk(red.getValue(), green.getValue(), blue.getValue());

        } else if ("CMYKSlider".equals(e.getSource().getClass().getSimpleName())) {
            cmykToRgb(cyan.getValue(), magenta.getValue(), yellow.getValue(), black.getValue());
        }
    }

    public void rgbToCmyk(int red, int green, int blue) {
        float b = Math.min(Math.min(255 - red, 255 - green), 255 - blue);

        if (b != 255) {
            float c = (255 - red - b) / (255 - b);
            float m = (255 - green - b) / (255 - b);
            float y = (255 - blue - b) / (255 - b);
            cyan.setValue((int) (c * 100));
            magenta.setValue((int) (m * 100));
            yellow.setValue((int) (y * 100));
            black.setValue((int) (b * 100));
            Color color = new Color(red, green, blue);
            RGBpanel.setColor(color);

            redText.setText("" + red);
            greenText.setText("" + green);
            blueText.setText("" + blue);
            blackText.setText("" + (int) (b * 100));
            cyanText.setText("" + (int) (c * 100));
            magentaText.setText("" + (int) (m * 100));
            yellowText.setText("" + (int) (y * 100));

        } else {
            float c = 255 - red;
            float m = 255 - green;
            float y = 255 - blue;
            cyan.setValue((int) (c * 100));
            magenta.setValue((int) (m * 100));
            yellow.setValue((int) (y * 100));
            black.setValue((int) (b * 100));

            Color color = new Color(red, green, blue);
            RGBpanel.setColor(color);

            redText.setText("" + red);
            greenText.setText("" + green);
            blueText.setText("" + blue);
            blackText.setText("" + (int) (b * 100));
            cyanText.setText("" + (int) (c * 100));
            magentaText.setText("" + (int) (m * 100));
            yellowText.setText("" + (int) (y * 100));
        }
    }

    public void cmykToRgb(int cyan, int magenta, int yellow, int black) {
        if (black != 255) {
            int R = ((255 - cyan) * (255 - black)) / 255;
            int G = ((255 - magenta) * (255 - black)) / 255;
            int B = ((255 - yellow) * (255 - black)) / 255;
            Color color = new Color(R, G, B);
            RGBpanel.setColor(color);
            red.setValue(R);
            green.setValue(G);
            blue.setValue(B);

            redText.setText("" + R);
            greenText.setText("" + G);
            blueText.setText("" + B);
            blackText.setText("" + black);
            cyanText.setText("" + cyan);
            magentaText.setText("" + magenta);
            yellowText.setText("" + yellow);

        } else {
            int R = 255 - cyan;
            int G = 255 - magenta;
            int B = 255 - yellow;
            Color color = new Color(R, G, B);
            RGBpanel.setColor(color);
            red.setValue(R);
            green.setValue(G);
            blue.setValue(B);
            redText.setText("" + R);
            greenText.setText("" + G);
            blueText.setText("" + B);
            blackText.setText("" + black);
            cyanText.setText("" + cyan);
            magentaText.setText("" + magenta);
            yellowText.setText("" + yellow);
        }
    }

    private javax.swing.JRadioButton CMYKbox;
    private javax.swing.JRadioButton RGBbox;
    private Panel RGBpanel;
    private javax.swing.JTextField blackText;
    private javax.swing.JTextField blueText;
    private javax.swing.JTextField cyanText;
    private javax.swing.JTextField greenText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField magentaText;
    private javax.swing.JTextField redText;
    private javax.swing.JTextField yellowText;
    private RGBSlider green;
    private RGBSlider red;
    private RGBSlider blue;
    private CMYKSlider black;
    private CMYKSlider yellow;
    private CMYKSlider magenta;
    private javax.swing.JPanel jPanel3;
    private CMYKSlider cyan;
}
