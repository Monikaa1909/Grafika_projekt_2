
package project_2_graphic.point_transformations;

import project_2_graphic.MainWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PointTransformation extends javax.swing.JFrame implements ChangeListener {

    public PointTransformation() {
        initComponents();
    }

    private void initComponents() {

        panel = new Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JButton backButton = new JButton("Back");
        backButton.setVisible(true);
        backButton.addActionListener(new BackListener());
        addRed = new AdditionSlider();
        multiplyRed = new MultiplicationSlider();
        addGreen = new AdditionSlider();
        addBlue = new AdditionSlider();
        multiplyGreen = new MultiplicationSlider();
        multiplyBlue = new MultiplicationSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        shadeOfGrey1 = new javax.swing.JToggleButton();
        shadeOfGrey2 = new javax.swing.JButton();
        resetImage = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        brightness = new BrightnessSlider();
        jLabel11 = new javax.swing.JLabel();
        contrast = new Contrast();
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

        jLabel1.setText("Dodawanie / Odejmowanie");

        jLabel2.setText("Mnożenie / Dzielenie");

        jLabel3.setText("R:");

        jLabel4.setText("G:");

        jLabel5.setText("B:");

        addRed.setMaximum(255);
        addRed.setMinimum(-255);
        addRed.setValue(0);

        addGreen.setMaximum(255);
        addGreen.setMinimum(-255);
        addGreen.setValue(0);

        addBlue.setMaximum(255);
        addBlue.setMinimum(-255);
        addBlue.setValue(0);
        
        multiplyRed.setMaximum(400);
        multiplyRed.setMinimum(1);
        multiplyRed.setValue(200);

        multiplyGreen.setMaximum(400);
        multiplyGreen.setMinimum(1);
        multiplyGreen.setValue(200);

        multiplyBlue.setMaximum(400);
        multiplyBlue.setMinimum(1);
        multiplyBlue.setValue(200);

        jLabel6.setText("R:");

        jLabel7.setText("G:");

        jLabel8.setText("B:");

        shadeOfGrey1.setText("Odcień szarości 1");
        shadeOfGrey1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shadeOfGrey1ActionPerformed(evt);
            }
        });

        shadeOfGrey2.setText("Odcień szarości 2");
        shadeOfGrey2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shadeOfGrey2ActionPerformed(evt);
            }
        });

        resetImage.setText("Resetuj obrazek");
        resetImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetImageActionPerformed(evt);
            }
        });

        jLabel9.setText("Odcienie szarości");

        jLabel10.setText("Jasność");

//        brightness.setMaximum(255);
//        brightness.setMinimum(-255);
        brightness.setMaximum(128);
        brightness.setMinimum(0);
        brightness.setValue(2);

        jLabel11.setText("Kontrast");

        contrast.setMaximum(400);
        contrast.setMinimum(1);
        contrast.setValue(200);

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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(72, 72, 72)
                                                        .addComponent(jLabel2))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel6)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(multiplyRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel7)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(multiplyGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel8)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(multiplyBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(61, 61, 61)
                                                        .addComponent(jLabel1))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(addBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel4))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(addRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(addGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(70, 70, 70)
                                                        .addComponent(jLabel9))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(92, 92, 92)
                                                        .addComponent(jLabel10))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(94, 94, 94)
                                                        .addComponent(jLabel11))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(contrast, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(brightness, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(shadeOfGrey2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(resetImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(shadeOfGrey1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(addRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(addGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(addBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(multiplyRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(multiplyGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(multiplyBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(brightness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(contrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(shadeOfGrey1)
                                        .addGap(8, 8, 8)
                                        .addComponent(shadeOfGrey2)
                                        .addGap(8, 8, 8)
                                        .addComponent(resetImage)
                                        .addGap(8, 8, 8)
                                        .addComponent(backButton)))
                        .addGap(0, 12, Short.MAX_VALUE))
        );

        addRed.addChangeListener(this);
        addGreen.addChangeListener(this);
        addBlue.addChangeListener(this);
        multiplyBlue.addChangeListener(this);
        multiplyGreen.addChangeListener(this);
        multiplyRed.addChangeListener(this);
        brightness.addChangeListener(this);
        contrast.addChangeListener(this);
        pack();
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

    private void shadeOfGrey1ActionPerformed(java.awt.event.ActionEvent evt) {
        int w = imageArray.getWidth();
        int h = imageArray.getHeight();
        resetAllSliders();

        int[] dataBuffInt = imageArray.getRGB(0, 0, w, h, null, 0, w);
        int index = 0;

        BufferedImage temporaryImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color c = new Color(dataBuffInt[index]);
                float R = c.getRed();
                float B = c.getBlue();
                float G = c.getGreen();

                float tmp = (R + G + B) / 3;
                R = tmp;
                G = tmp;
                B = tmp;


                Color newColor = new Color((int) R, (int) G, (int) B);
                int rgb = newColor.getRGB();
                temporaryImage.setRGB(j, i, rgb);
                index++;
            }
        }
        panel.setImg(temporaryImage);

    }

    private void shadeOfGrey2ActionPerformed(java.awt.event.ActionEvent evt) {
        int w = imageArray.getWidth();
        int h = imageArray.getHeight();
        resetAllSliders();
        int[] dataBuffInt = imageArray.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage temporaryImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
         for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    float R = c.getRed();
                    float B = c.getBlue();
                    float G = c.getGreen();
                    
                    R *= 0.299;
                    G *= 0.587;
                    B *= 0.114;
                    
                    float tmp = (R + G + B);
                    R = tmp;
                    G = tmp;
                    B = tmp;

                    Color newColor = new Color((int) R, (int) G, (int) B);
                    int rgb = newColor.getRGB();
                    temporaryImage.setRGB(j, i, rgb);
                    index++;
                }
            }

            panel.setImg(temporaryImage);
    }
    private void resetImageActionPerformed(java.awt.event.ActionEvent evt) {
        resetAllSliders();
        panel.setImg(imageArray);
    }

    public void additionSubtracion() {
        int w = imageArray.getWidth();
        int h = imageArray.getHeight();
        resetMultiplication();
        resetBrightness();
        resetContrast();

        int[] dataBuffInt = imageArray.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage temporaryImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color c = new Color(dataBuffInt[index]);
                int R = c.getRed();
                int B = c.getBlue();
                int G = c.getGreen();

                if (addBlue.getValue() != 0) {
                    B = B + addBlue.getValue();
                    if (B > 255) {
                        B = 255;
                    }
                    if (B < 0) {
                        B = 0;
                    }
                }

                if (addRed.getValue() != 0) {
                    R = R + addRed.getValue();
                    if (R > 255) {
                        R = 255;
                    }
                    if (R < 0) {
                        R = 0;
                    }
                }

                if (addGreen.getValue() != 0) {
                    G = G + addGreen.getValue();
                    if (G > 255) {
                        G = 255;
                    }
                    if (G < 0) {
                        G = 0;
                    }
                }

                Color newColor = new Color(R, G, B);
                int rgb = newColor.getRGB();
                temporaryImage.setRGB(j, i, rgb);
                index++;
            }
        }
        index = 0;
        panel.setImg(temporaryImage);
    }
       
    public void multiplicationDivision() {
        int w = imageArray.getWidth();
        int h = imageArray.getHeight();
        resetAddition();
        resetBrightness();
        resetContrast();

        int[] dataBuffInt = imageArray.getRGB(0, 0, w, h, null, 0, w);
        int index = 0;

        BufferedImage temporaryImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color c = new Color(dataBuffInt[index]);
                float R = c.getRed();
                float B = c.getBlue();
                float G = c.getGreen();

                if (multiplyRed.getValue() != 0) {
                    float tmp =(float) multiplyRed.getValue();
                    tmp = tmp /100;
                    R =R * tmp;
                    if (R > 255) {
                        R = 255;
                    }
                    if (R < 0) {
                        R = 0;
                    }
                }
                if (multiplyGreen.getValue() != 0) {
                    float tmp2 =(float) multiplyGreen.getValue();
                    tmp2 = tmp2 /100;
                    G =G * tmp2;
                    if (G > 255) {
                        G = 255;
                    }
                    if (G < 0) {
                        G = 0;
                    }
                }
                if (multiplyBlue.getValue() != 0) {
                    float tmp3 =(float) multiplyBlue.getValue();
                    tmp3 = tmp3 /100;
                    B = B * tmp3;
                    if (B > 255) {
                        B = 255;
                    }
                    if (B < 0) {
                        B = 0;
                    }
                }

                Color newColor = new Color((int)R,(int) G,(int) B);
                int rgb = newColor.getRGB();
                temporaryImage.setRGB(j, i, rgb);
                index++;
            }
        }
        panel.setImg(temporaryImage);
    }
    
    public void brightness() {
        int w = imageArray.getWidth();
        int h = imageArray.getHeight();
        resetAddition();
        resetMultiplication();
        resetContrast();

        int[] dataBuffInt = imageArray.getRGB(0, 0, w, h, null, 0, w);
        int index = 0;

        BufferedImage temporaryImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
         for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    int R = c.getRed();
                    int B = c.getBlue();
                    int G = c.getGreen();

                    double b = brightness.getValue() / 128d;
                    R = (int) (b * (R * R));
                    B = (int) (b * (B * B));
                    G = (int) (b * (G * G));

//                    R = R + brightness.getValue();
//                    G = G + brightness.getValue();
//                    B = B + brightness.getValue();
                    if(R > 255){
                        R = 255;
                    }
                    if(R < 0 ){
                        R =0;
                    }
                    
                    if (G > 255) {
                        G = 255;
                    }
                    if (G < 0) {
                        G = 0;
                    }
                    if(B>255){
                        B=255;
                    }
                    if(B < 0){
                        B = 0;
                    }

                    Color newColor = new Color(R, G, B);
                    int rgb = newColor.getRGB();
                    temporaryImage.setRGB(j, i, rgb);
                    index++;
                }
            }
            panel.setImg(temporaryImage);
        
    }
    
    public void contrast(){
        int w = imageArray.getWidth();
        int h = imageArray.getHeight();
        resetAddition();
        resetMultiplication();
        resetBrightness();

        int[] dataBuffInt = imageArray.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage temporaryImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
         for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    float R = c.getRed();
                    float B = c.getBlue();
                    float G = c.getGreen();
                    float tmp =(float) contrast.getValue();
                    tmp = tmp /100;
                    R = R * tmp;
                    G = G * tmp;
                    B = B * tmp;
                    if(R > 255){
                        R = 255;
                    }
                    if(R < 0 ){
                        R =0;
                    }
                    
                    if (G > 255) {
                        G = 255;
                    }
                    if (G < 0) {
                        G = 0;
                    }
                    if(B>255){
                        B=255;
                    }
                    if(B < 0){
                        B = 0;
                    }

                    Color newColor = new Color((int)R,(int) G,(int) B);
                    int rgb = newColor.getRGB();
                    temporaryImage.setRGB(j, i, rgb);
                    index++;
                }
            }
            panel.setImg(temporaryImage);
    }
    
     @Override
    public void stateChanged(ChangeEvent e) {

        if ("AdditionSlider".equals(e.getSource().getClass().getSimpleName())) {
            // System.out.println("dodawanie / odejmowanie");
            new Thread(new Runnable() {
                public void run() {
                    additionSubtracion();
                }
            }).start();

        } else if ("MultiplicationSlider".equals(e.getSource().getClass().getSimpleName())) {
            //System.out.println("mnozenie / dzielenie");
            new Thread(new Runnable() {
                public void run() {
                    multiplicationDivision();
                }
            }).start();
            
        } else if ("BrightnessSlider".equals(e.getSource().getClass().getSimpleName())) {
            //System.out.println("jasnosc");
            new Thread(new Runnable() {
                public void run() {
                    brightness();
                }
            }).start();
        } else if ("Contrast".equals(e.getSource().getClass().getSimpleName())) {
            //System.out.println("kontrast");
            new Thread(new Runnable() {
                public void run() {
                    contrast();
                }
            }).start();
        }

    }

    public static void main(String args[]) {

        new PointTransformation().setVisible(true);

    }

    public void resetAddition() {
        if (addGreen != null) addGreen.setValue(0);
        if (addRed != null) addRed.setValue(0);
        if (addBlue != null) addBlue.setValue(0);
    }

    public void resetMultiplication() {
        if (multiplyBlue != null) multiplyBlue.setValue(200);
        if (multiplyRed != null) multiplyRed.setValue(200);
        if (multiplyGreen != null) multiplyGreen.setValue(200);
    }

    public void resetBrightness() {
        if (brightness != null) brightness.setValue(0);
    }

    public void resetContrast() {
        if (contrast != null) contrast.setValue(200);
    }

    public void resetAllSliders() {
        resetAddition();
        resetMultiplication();
        resetContrast();
        resetBrightness();
    }

    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            MainWindow o = new MainWindow();
            o.setVisible(true);
        }
    }

    private AdditionSlider addBlue;
    private AdditionSlider addGreen;
    private AdditionSlider addRed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private BrightnessSlider brightness;
    private Contrast contrast;
    private MultiplicationSlider multiplyBlue;
    private MultiplicationSlider multiplyGreen;
    private MultiplicationSlider multiplyRed;
    private javax.swing.JToggleButton shadeOfGrey1;
    private javax.swing.JButton shadeOfGrey2;
    private javax.swing.JButton resetImage;
    private javax.swing.JMenuItem openButton;
    private Panel panel;
    private int amountOfRows;
    private int amountOfColumns;
    private int nrPPM;
    private int maxRGB;
    private BufferedImage imageArray;
    int poprzedniDodanyR = 0;
    int poprzedniDodanyG = 0;
    int poprzedniDodanyB = 0;
    int poprzedniMnozonyR = 200;
    int poprzedniMnozonyG = 200;
    int poprzedniMnozonyB = 200;
                   

}
