package project_2_graphic.histograms_and_binarization;

import javafx.embed.swing.SwingFXUtils;
import project_2_graphic.MainWindow;
import project_2_graphic.point_transformations.*;
import project_2_graphic.point_transformations.Panel;

import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static sun.awt.X11.XConstants.GrayScale;

public class HistogramsAndBinarizations extends javax.swing.JFrame implements ChangeListener {

    public HistogramsAndBinarizations() {
        initComponents();
    }

    private void initComponents() {
        panel = new Panel();
        JButton backButton = new JButton("Back");
        backButton.setVisible(true);
        backButton.addActionListener(new HistogramsAndBinarizations.BackListener());

        histogramEqualizationButton = new javax.swing.JToggleButton();
        histogramExtensionbutton = new javax.swing.JButton();
        manualBinarizationButton = new javax.swing.JButton();
        percentBlackSelectionButton = new javax.swing.JButton();
        meanIterativeSelectionButton = new javax.swing.JButton();
        niblackBinarizationButton = new javax.swing.JButton();
        minimumErrorButton = new javax.swing.JButton();
        fuzzyMinimumErrorButton = new javax.swing.JButton();

        manualBinarizationValueSlider = new javax.swing.JSlider();
        manualBinarizationValueSlider.setMaximum(255);
        manualBinarizationValueSlider.setMinimum(0);
        manualBinarizationValueSlider.setValue(200);

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

        histogramEqualizationButton.setText("Wyr??wnaj histogram");
        histogramEqualizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histogramEqualizationActionPerformed(evt);
            }
        });

        histogramExtensionbutton.setText("Rozszerz histogram");
        histogramExtensionbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extendHistogramActionPerformed(evt);
            }
        });

        manualBinarizationButton.setText("Binaryzacja manualna");
        manualBinarizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualBinarizationActionPerformed(evt);
            }
        });

        percentBlackSelectionButton.setText("Metoda selekcji procentowej czarnego");
        percentBlackSelectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentBlackSelectionActionPerformed(evt);
            }
        });

        niblackBinarizationButton.setText("Binaryzacja Nibclack");
        niblackBinarizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                niblackBinarizationActionPerformed(evt);
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
                                                        .addComponent(histogramExtensionbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(resetImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(histogramEqualizationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(manualBinarizationValueSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(manualBinarizationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(percentBlackSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(meanIterativeSelectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(niblackBinarizationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(minimumErrorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(fuzzyMinimumErrorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                )
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
                                                .addComponent(histogramEqualizationButton)
                                                .addGap(8, 8, 8)
                                                .addComponent(histogramExtensionbutton)
                                                .addGap(8, 8, 8)
                                                .addComponent(resetImage)
                                                .addGap(8, 8, 8)
                                                .addComponent(manualBinarizationButton)
                                                .addGap(8, 8, 8)
                                                .addComponent(percentBlackSelectionButton)
                                                .addGap(8, 8, 8)
                                                .addComponent(meanIterativeSelectionButton)
                                                .addGap(8, 8, 8)
                                                .addComponent(niblackBinarizationButton)
                                                .addGap(8, 8, 8)
                                                .addComponent(minimumErrorButton)
                                                .addGap(8, 8, 8)
                                                .addComponent(fuzzyMinimumErrorButton)
                                                .addGap(8, 8, 8)
                                                .addComponent(manualBinarizationValueSlider)
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

    public BufferedImage histogramStreching(BufferedImage original) {

        BufferedImage histogramST = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());

        int max = new Color(original.getRGB(0, 0)).getRed();
        int min = new Color(original.getRGB(0, 0)).getRed();

        for(int i=0 ; i <original.getWidth(); i++) {
            for(int j =0; j<original.getHeight(); j++) {
                Color color = new Color(original.getRGB(i, j));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                if(red > max) max = red;
                if(green > max) max = green;
                if(blue > max) max = blue;

                if(red < min) min = red;
                if(green < min) min = green;
                if(blue < min) min = blue;
            }
        }

        System.out.println("Max=");
        System.out.println(max);
        System.out.println("Min=");
        System.out.println(min);

        int[] table = strechLookupTable(min, max, 256);

        for(int i=0 ; i <original.getWidth(); i++){
            for(int j =0; j<original.getHeight(); j++){
                Color color = new Color(original.getRGB(i, j));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                red = table[red];
                if(red<0)
                    red =0;
                if(red>255)
                    red=255 ;

                green = table[green];
                if(green<0)
                    green =0;
                if(green>255)
                    green=255 ;

                blue = table[blue];
                if(blue<0)
                    blue =0;
                if(blue>255)
                    blue=255 ;

                color = new Color(red, green, blue);
                histogramST.setRGB(i, j, color.getRGB());
            }
        }
        System.out.println("Max=");
        System.out.println(max);
        System.out.println("Min=");
        System.out.println(min);
        return histogramST;
    }

    public BufferedImage manualImageBinarization(BufferedImage original, int threshold) {

        int h = original.getHeight();
        int w = original.getWidth();


        BufferedImage manuallyBinarizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {

                Color color = new Color(original.getRGB(i, j));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int sum = (red + green + blue);
                if (red < threshold) {
                    red = 0;
                } else {
                    red = 255;
                }

                if (green < threshold) {
                    green = 0;
                } else {
                    green = 255;
                }

                if (blue < threshold) {
                    blue = 0;
                } else {
                    blue = 255;
                }

                color = new Color(red, green, blue);
                manuallyBinarizedImg.setRGB(i, j, color.getRGB());
            }
        }

        return manuallyBinarizedImg;
    }

    public BufferedImage niblackBinarization(BufferedImage bi) {

        BufferedImage resultImage = new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
        int width  = bi.getWidth();
        int height = bi.getHeight();
        int neighbourWindowBound = 2;
        int neighbourWindowSize = 2 * neighbourWindowBound + 1;
        double k = -0.1;

        for (int i = neighbourWindowBound; i < width - neighbourWindowBound; i++) {
            for (int j = neighbourWindowBound; j < height - neighbourWindowBound; j++) {
                double mean  = 0;
                double[][] neighbourWindowLuminances = new double[neighbourWindowSize][neighbourWindowSize];
                for (int a = -neighbourWindowBound; a <= neighbourWindowBound; a++) {
                    for (int b = -neighbourWindowBound; b <= neighbourWindowBound; b++) {
                        double luminance = getRGBLuminance(bi.getRGB(i + a, j + b));
                        mean += luminance;
                        neighbourWindowLuminances[a + neighbourWindowBound][b + neighbourWindowBound] = luminance;
                    }
                }
                mean /= pow(neighbourWindowSize, 2);
                double standardDeviation = 0;
                for (int a = 0; a < neighbourWindowSize; a++) {
                    for (int b = 0; b < neighbourWindowSize; b++) {
                        standardDeviation += pow(neighbourWindowLuminances[a][b] - mean, 2);
                    }
                }
                standardDeviation = sqrt(standardDeviation / (neighbourWindowSize * neighbourWindowSize));

                if(neighbourWindowLuminances[neighbourWindowBound][neighbourWindowBound] > mean + k * standardDeviation){
                    resultImage.setRGB(i, j, Color.WHITE.getRGB());
                }
                else{
                    resultImage.setRGB(i, j, Color.BLACK.getRGB());
                }
            }
        }

        return resultImage;
    }

    private double getRGBLuminance(int rgb) {
        Color color = new Color(rgb);
        return (color.getRed() * 0.2126 + color.getGreen() * 0.7152 + color.getBlue() * 0.0722);
    }

    public BufferedImage percentBlackSelectionImageBinarization(BufferedImage imageArray, double percentage) {
        int h = imageArray.getHeight();
        int w = imageArray.getWidth();
        int amountOfPixels = w * h;

        int[] pixelTable = new int[amountOfPixels];
//        HashMap<Integer, Integer> pixelTable2 = new HashMap<>();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int val = imageArray.getRGB(i, j);
                int r = (0x00ff0000 & val) >> 16;
                int g = (0x0000ff00 & val) >> 8;
                int b = (0x000000ff & val);
                int sum = (r + g + b);
                if (sum == 0) sum = 1;
                pixelTable[sum - 1] += 1;
            }
        }

        int[] LUT = new int[768];
        double limes = ((double) percentage / 100) * ((double) amountOfPixels);
        int nextSum = 0;
        for (int i = 0; i < 768; ++i) {
            nextSum = nextSum + pixelTable[i];
            if (nextSum < limes) {
                LUT[i] = 0;
            } else {
                LUT[i] = 1;
            }
        }

        BufferedImage blackPercentageMethodImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int val = imageArray.getRGB(i, j);
                int r = (0x00ff0000 & val) >> 16;
                int g = (0x0000ff00 & val) >> 8;
                int b = (0x000000ff & val);
                int sum = (r + g + b);
                if (LUT[sum] == 0) blackPercentageMethodImage.setRGB(i, j, Color.BLACK.getRGB());
                else blackPercentageMethodImage.setRGB(i, j, Color.WHITE.getRGB());
            }
        }

        return blackPercentageMethodImage;
    }


    private static int[] strechLookupTable(int a, int b, int maxI){
        int[] lookup = new int[maxI];
        for(int i=0; i<lookup.length; i++){
            lookup[i] = ((maxI)/(b-a))*(i-a);
            if(lookup[i]<0)
                lookup[i] =0;
            if(lookup[i]>maxI)
                lookup[i]=maxI ;
        }
        return lookup;
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
        System.out.println("Dosta??em plik: " + file);
        String ppm = scanner.next();
        System.out.println(ppm + " ten ppm");
        nrPPM = Integer.parseInt(ppm.substring(ppm.length() - 1));
        System.out.println("otwieram plik PPM" + nrPPM);
        amountOfColumns = scanner.nextInt();
        System.out.println("Ilo???? kolum: " + amountOfColumns);
        amountOfRows = scanner.nextInt();
        System.out.println("Ilo???? wierszy: " + amountOfRows);
        maxRGB = scanner.nextInt();
        System.out.println("Max warto???? RGB: " + maxRGB);

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

    private void extendHistogramActionPerformed(java.awt.event.ActionEvent evt) {
        BufferedImage processedImage = histogramStreching(imageArray);
        panel.setImg(processedImage);
    }

    private void manualBinarizationActionPerformed(java.awt.event.ActionEvent evt) {
        BufferedImage processedImage = manualImageBinarization(imageArray, manualBinarizationValueSlider.getValue());
        panel.setImg(processedImage);
    }

    private void percentBlackSelectionActionPerformed(java.awt.event.ActionEvent evt) {
        BufferedImage processedImage = percentBlackSelectionImageBinarization(imageArray, 58);
        panel.setImg(processedImage);
    }

    private void niblackBinarizationActionPerformed(java.awt.event.ActionEvent evt) {
        BufferedImage processedImage = niblackBinarization(imageArray);
        panel.setImg(processedImage);
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
    private javax.swing.JToggleButton histogramEqualizationButton;
    private javax.swing.JButton histogramExtensionbutton;
    private javax.swing.JButton manualBinarizationButton;
    private javax.swing.JButton resetImage;
    private javax.swing.JMenuItem openButton;

    // TODO: doda?? do layoutu
    private javax.swing.JSlider manualBinarizationValueSlider;
    private javax.swing.JButton percentBlackSelectionButton;
    private javax.swing.JButton meanIterativeSelectionButton;
    private javax.swing.JButton niblackBinarizationButton;
    private javax.swing.JButton minimumErrorButton;
    private javax.swing.JButton fuzzyMinimumErrorButton;

    private Panel panel;
    private int amountOfRows;
    private int amountOfColumns;
    private int nrPPM;
    private int maxRGB;
    private BufferedImage imageArray;
}
