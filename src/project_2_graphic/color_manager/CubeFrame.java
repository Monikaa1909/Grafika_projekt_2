package project_2_graphic.color_manager;

import project_2_graphic.FileLoaderAndWriter;
import project_2_graphic.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CubeFrame extends javax.swing.JFrame {

    private JPanel jPanel3;
    private Cube cube;
    private JPanel mainPanel;

    public CubeFrame() {
        initComponents();
    }

    public void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        cube = new Cube();
        mainPanel = new javax.swing.JPanel();
        Container contentPane = getContentPane();
        JButton backButton = new JButton("Back");
        backButton.setVisible(true);
        backButton.addActionListener(new BackListener());

        javax.swing.GroupLayout cubeLayout = new javax.swing.GroupLayout(cube);
        cube.setLayout(cubeLayout);
        cubeLayout.setHorizontalGroup(
                cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 513, Short.MAX_VALUE)
        );
        cubeLayout.setVerticalGroup(
                cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 347, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addComponent(cube, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backButton)
                        .addComponent(cube, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        contentPane.add(mainPanel);
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainWindow o = new MainWindow();
            o.setVisible(true);
        }
    }

}
