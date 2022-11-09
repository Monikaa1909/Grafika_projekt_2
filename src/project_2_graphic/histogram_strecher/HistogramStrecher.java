package project_2_graphic.histogram_strecher;

import project_2_graphic.MainWindow;
import project_2_graphic.point_transformations.*;
import project_2_graphic.point_transformations.Panel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistogramStrecher extends javax.swing.JFrame implements ChangeListener {

    public HistogramStrecher() {
        initComponents();
    }

    private void initComponents() {
        panel = new Panel();
        JButton backButton = new JButton("Back");
        backButton.setVisible(true);
        backButton.addActionListener(new HistogramStrecher.BackListener());

        histogramEqualizationLabel = new javax.swing.JToggleButton();
        histogramExtension = new javax.swing.JButton();
        resetImage = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 636, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 476, Short.MAX_VALUE)
        );

        histogramEqualizationLabel.setText("Wyrównaj histogram");
        histogramEqualizationLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histogramEqualizationActionPerformed(evt);
            }
        });

        histogramExtension.setText("Rozszerz histogram");
        histogramExtension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extendHistogram(evt);
            }
        });

        resetImage.setText("Resetuj obrazek");
        resetImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetImageActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        openButton.setText("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    openButtonActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(PointTransformation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jMenu1.add(openButton);
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(histogramExtension, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(resetImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(histogramEqualizationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(22, Short.MAX_VALUE)
                                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(465, 465, 465)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(histogramEqualizationLabel)
                                                .addGap(8, 8, 8)
                                                .addComponent(histogramExtension)
                                                .addGap(8, 8, 8)
                                                .addComponent(resetImage)
                                                .addGap(8, 8, 8)
                                                .addComponent(backButton)))
                                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }

    public BufferedImage histogramEqualization(BufferedImage original) {

        int red;
        int green;
        int blue;
        int alpha;
        int newPixel;

        // lookup table
        ArrayList<int[]> histLUT = histogramEqualizationLUT(original);

        BufferedImage histogramEQ = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {

                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();

                // Set new pixel values using the histogram lookup table
                red = histLUT.get(0)[red];
                green = histLUT.get(1)[green];
                blue = histLUT.get(2)[blue];

                // Return back to original format
                newPixel = colorToRGB(alpha, red, green, blue);

                // Write pixels into image
                histogramEQ.setRGB(i, j, newPixel);
            }
        }

        return histogramEQ;
    }

    // Get the histogram equalization lookup table for separate R, G, B channels
    private ArrayList<int[]> histogramEqualizationLUT(BufferedImage input) {

        // Get an image histogram - calculated values by R, G, B channels
        ArrayList<int[]> imageHist = imageHistogram(input);

        // Create the lookup table
        ArrayList<int[]> imageLUT = new ArrayList<int[]>();

        // Fill the lookup table
        int[] rhistogram = new int[256];
        int[] ghistogram = new int[256];
        int[] bhistogram = new int[256];

        for (int i = 0; i < rhistogram.length; i++) rhistogram[i] = 0;
        for (int i = 0; i < ghistogram.length; i++) ghistogram[i] = 0;
        for (int i = 0; i < bhistogram.length; i++) bhistogram[i] = 0;

        long sumr = 0;
        long sumg = 0;
        long sumb = 0;

        // Calculate the scale factor
        float scale_factor = (float) (255.0 / (input.getWidth() * input.getHeight()));

        for (int i = 0; i < rhistogram.length; i++) {
            // red
            sumr += imageHist.get(0)[i];
            int valr = (int) (sumr * scale_factor);
            if (valr > 255) {
                rhistogram[i] = 255;
            } else rhistogram[i] = valr;

            // green
            sumg += imageHist.get(1)[i];
            int valg = (int) (sumg * scale_factor);
            if (valg > 255) {
                ghistogram[i] = 255;
            } else ghistogram[i] = valg;

            // blue
            sumb += imageHist.get(2)[i];
            int valb = (int) (sumb * scale_factor);
            if (valb > 255) {
                bhistogram[i] = 255;
            } else bhistogram[i] = valb;
        }

        imageLUT.add(rhistogram);
        imageLUT.add(ghistogram);
        imageLUT.add(bhistogram);

        return imageLUT;

    }

    // Return an ArrayList containing histogram values for separate R, G, B channels
    public ArrayList<int[]> imageHistogram(BufferedImage input) {

        int[] rhistogram = new int[256];
        int[] ghistogram = new int[256];
        int[] bhistogram = new int[256];

        for (int i = 0; i < rhistogram.length; i++) rhistogram[i] = 0;
        for (int i = 0; i < ghistogram.length; i++) ghistogram[i] = 0;
        for (int i = 0; i < bhistogram.length; i++) bhistogram[i] = 0;

        for (int i = 0; i < input.getWidth(); i++) {
            for (int j = 0; j < input.getHeight(); j++) {

                int red = new Color(input.getRGB(i, j)).getRed();
                int green = new Color(input.getRGB(i, j)).getGreen();
                int blue = new Color(input.getRGB(i, j)).getBlue();

                // Increase the values of colors
                rhistogram[red]++;
                ghistogram[green]++;
                bhistogram[blue]++;
            }
        }

        ArrayList<int[]> hist = new ArrayList<int[]>();
        hist.add(rhistogram);
        hist.add(ghistogram);
        hist.add(bhistogram);

        return hist;
    }

    // Convert R, G, B, Alpha to standard 8 bit
    private int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;
    }


    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("file" + file);
            String fileString = file.toString().substring(file.toString().length() - 3);
            System.out.println("plik: " + fileString);
            if ("ppm".equals(fileString)) {
                try {
                    choosePpm(file);
                } catch (FileNotFoundException ex) {
                    System.out.println("brak pliku");
                }
            } else {
                System.out.println("JPG");
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(file.toString()));
                    panel.setImg(img);
                    imageArray = img;
                } catch (IOException e) {
                    System.out.println("NIE DZIALA");
                }
            }
        }
    }

    private void choosePpm(File file) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new FileReader(file));
        System.out.println("Dostałem plik: " + file);
        String ppm = scanner.next();
        System.out.println(ppm + " ten ppm");
        nrPPM = Integer.parseInt(ppm.substring(ppm.length() - 1));
        System.out.println("otwieram plik PPM" + nrPPM);
        amountOfColumns = scanner.nextInt();
        System.out.println("Ilość kolum: " + amountOfColumns);
        amountOfRows = scanner.nextInt();
        System.out.println("Ilość wierszy: " + amountOfRows);
        maxRGB = scanner.nextInt();
        System.out.println("Max wartość RGB: " + maxRGB);

        if (nrPPM == 3) {
            System.out.println("ppm3");
            imageArray = new BufferedImage(amountOfColumns, amountOfRows, BufferedImage.TYPE_INT_RGB);
            while (scanner.hasNext()) {
                for (int i = 0; i < amountOfRows; i++) {
                    for (int j = 0; j < amountOfColumns; j++) {
                        int R = scanner.nextInt();
                        int G = scanner.nextInt();
                        int B = scanner.nextInt();

                        Color color = new Color(R, G, B);
                        int rgb = color.getRGB();
                        imageArray.setRGB(j, i, rgb);
                    }
                }
            }

            panel.setImg(imageArray);
            this.pack();
        } else {
            System.out.println("ppm6");
            FileInputStream input = new FileInputStream((file));
            amountOfColumns = amountOfColumns - amountOfColumns / 2;
            imageArray = new BufferedImage(amountOfColumns, amountOfRows, BufferedImage.TYPE_INT_RGB);
            double divider = 65536;
            for (int i = 0; i < amountOfRows; i++) {
                for (int j = 0; j < amountOfColumns; j++) {

                    double R1 = (input.read() << 8);
                    double R2 = input.read();

                    double G1 = (input.read() << 8);
                    double G2 = input.read();

                    double B1 = (input.read() << 8);
                    double B2 = input.read();

                    double pomR = R1 + R2;
                    double pomG = G1 + G2;
                    double pomB = B1 + B2;

                    double divideR = pomR / divider;
                    double divideG = pomG / divider;
                    double divideB = pomB / divider;

                    double R = divideR * 255;
                    double G = divideG * 255;
                    double B = divideB * 255;

                    Color color = new Color((int) G, (int) R, (int) B);
                    int rgb = color.getRGB();
                    imageArray.setRGB(j, i, rgb);
                }

                panel.setImg(imageArray);
                this.pack();
            }
        }
    }

    private void histogramEqualizationActionPerformed(java.awt.event.ActionEvent evt) {
        BufferedImage processedImage = histogramEqualization(imageArray);
        panel.setImg(processedImage);
    }

    private void extendHistogram(java.awt.event.ActionEvent evt) {
        //TODO miejsce na kod "rozciągania obrazka"
    }

    private void resetImageActionPerformed(java.awt.event.ActionEvent evt) {
        panel.setImg(imageArray);
    }

    @Override
    public void stateChanged(ChangeEvent e) {}

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainWindow o = new MainWindow();
            o.setVisible(true);
        }
    }


    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToggleButton histogramEqualizationLabel;
    private javax.swing.JButton histogramExtension;
    private javax.swing.JButton resetImage;
    private javax.swing.JMenuItem openButton;
    private Panel panel;
    private int amountOfRows;
    private int amountOfColumns;
    private int nrPPM;
    private int maxRGB;
    private BufferedImage imageArray;
}
