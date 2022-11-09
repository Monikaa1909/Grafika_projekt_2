package project_2_graphic;

import project_2_graphic.color_manager.ColorManager;
import project_2_graphic.color_manager.CubeFrame;
import project_2_graphic.histogram_strecher.HistogramStrecher;
import project_2_graphic.point_transformations.PointTransformation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow extends JFrame {

    public MainWindow() {
        super("THE COOLEST COMPUTER GRAPHICS PROGRAM");
        doFrame();
    }

    private void doFrame() {
        setLayout(new GridBagLayout());
        JPanel buttons = new JPanel(new GridLayout(4, 0, 25,25 ));
        JButton readAndWriteFileButton = new JButton("Read and write file");
        JButton convertColorsButton = new JButton("Convert colors");
        JButton drawRGBCubeButton = new JButton("Draw a RGB cube");
        JButton drawHSVConeButton = new JButton("Draw a HSV cone");
        JButton pointTransformation = new JButton("Point transformations:v");
        JButton stretchHistogramButton = new JButton("Stretch the histogram");
        readAndWriteFileButton.addActionListener(new ReadAndLoadFileListener());
        convertColorsButton.addActionListener(new ConvertColorsListener());
        drawRGBCubeButton.addActionListener(new DrawRGBCubeListener());
        drawHSVConeButton.addActionListener(new DrawHSVConeListener());
        pointTransformation.addActionListener(new PointTransformationListener());
        stretchHistogramButton.addActionListener(new stretchHistogramListener());
        buttons.add(readAndWriteFileButton);
        buttons.add(convertColorsButton);
        buttons.add(drawRGBCubeButton);
        buttons.add(drawHSVConeButton);
        buttons.add(pointTransformation);
        buttons.add(stretchHistogramButton);

        setSize(750, 700);
        setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(buttons, new GridBagConstraints());
    }

    private class stretchHistogramListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            HistogramStrecher o = new HistogramStrecher();
            o.setVisible(true);
        }
    }

    private class ReadAndLoadFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            FileLoaderAndWriter o = new FileLoaderAndWriter();
            o.setVisible(true);
        }
    }

    private class PointTransformationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            PointTransformation o = new PointTransformation();
            o.setVisible(true);
        }
    }

    private class ConvertColorsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            ColorManager o = new ColorManager();
            o.setVisible(true);
        }
    }

    private class DrawRGBCubeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            CubeFrame o = new CubeFrame();
            o.setVisible(true);
        }
    }

    private class DrawHSVConeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            FileLoaderAndWriter o = new FileLoaderAndWriter();
            o.setVisible(true);
        }
    }
}




