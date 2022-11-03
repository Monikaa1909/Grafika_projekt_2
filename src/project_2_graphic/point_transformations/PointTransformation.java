
package project_2_graphic.point_transformations;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
        dodawanieRed = new DodawanieSlider();
        mnozenieRed = new MnozenieSlider();
        dodawanieGreen = new DodawanieSlider();
        dodawanieBlue = new DodawanieSlider();
        mnozenieGreen = new MnozenieSlider();
        mnozenieBlue = new MnozenieSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        odcienSzarosci1 = new javax.swing.JToggleButton();
        odcienSzarosci2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jasnosc = new JasnoscSlider();
        jLabel11 = new javax.swing.JLabel();
        kontrast = new Kontrast();
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

        dodawanieRed.setMaximum(255);
        dodawanieRed.setMinimum(-255);
        dodawanieRed.setValue(0);

        dodawanieGreen.setMaximum(255);
        dodawanieGreen.setMinimum(-255);
        dodawanieGreen.setValue(0);

        dodawanieBlue.setMaximum(255);
        dodawanieBlue.setMinimum(-255);
        dodawanieBlue.setValue(0);
        
        mnozenieRed.setMaximum(400);
        mnozenieRed.setMinimum(1);
        mnozenieRed.setValue(200);

        mnozenieGreen.setMaximum(400);
        mnozenieGreen.setMinimum(1);
        mnozenieGreen.setValue(200);

        mnozenieBlue.setMaximum(400);
        mnozenieBlue.setMinimum(1);
        mnozenieBlue.setValue(200);

        jLabel6.setText("R:");

        jLabel7.setText("G:");

        jLabel8.setText("B:");

        odcienSzarosci1.setText("Odcień szarości 1");
        odcienSzarosci1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odcienSzarosci1ActionPerformed(evt);
            }
        });

        odcienSzarosci2.setText("Odcień szarości 2");
        odcienSzarosci2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odcienSzarosci2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Odcienie szarości");

        jLabel10.setText("Jasność");

        jasnosc.setMaximum(255);
        jasnosc.setMinimum(-255);
        jasnosc.setValue(0);

        jLabel11.setText("Kontrast");

        kontrast.setMaximum(400);
        kontrast.setMinimum(1);
        kontrast.setValue(200);

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
                                                                        .addComponent(mnozenieRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel7)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(mnozenieGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addComponent(jLabel8)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(mnozenieBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(61, 61, 61)
                                                        .addComponent(jLabel1))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(dodawanieBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel4))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(dodawanieRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(dodawanieGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                                        .addComponent(kontrast, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jasnosc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(odcienSzarosci2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(odcienSzarosci1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                                                .addComponent(dodawanieRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3))
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(dodawanieGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dodawanieBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(mnozenieRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(mnozenieGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(mnozenieBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jasnosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kontrast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(odcienSzarosci1)
                                        .addGap(8, 8, 8)
                                        .addComponent(odcienSzarosci2)))
                        .addGap(0, 12, Short.MAX_VALUE))
        );

        dodawanieRed.addChangeListener(this);
        dodawanieGreen.addChangeListener(this);
        dodawanieBlue.addChangeListener(this);
        mnozenieBlue.addChangeListener(this);
        mnozenieGreen.addChangeListener(this);
        mnozenieRed.addChangeListener(this);
        jasnosc.addChangeListener(this);
        kontrast.addChangeListener(this);
        pack();
    }

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("file" + file);
            String plik = file.toString().substring(file.toString().length() - 3);
            System.out.println("plik: " + plik);
            if ("ppm".equals(plik)) {
                try {
                    wybierzKtoryPpm(file);
                } catch (FileNotFoundException ex) {
                    System.out.println("brak plika");
                }
            } else {
                System.out.println("JPG");
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(file.toString()));
                    panel.setImg(img);
                    tablicaZdjecia = img;

                } catch (IOException e) {
                    System.out.println("NIE DZIALA");
                }

            }
        }
    }

    private void wybierzKtoryPpm(File file) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new FileReader(file));
        System.out.println("Dostałem plik: " + file);
        String ppm = scanner.next();
        System.out.println(ppm + " ten ppm");
        nrPPM = Integer.parseInt(ppm.substring(ppm.length() - 1));
        System.out.println("otwieram plik PPM" + nrPPM);
        ileKolumn = scanner.nextInt();
        System.out.println("Ilość kolum: " + ileKolumn);
        ileWierszy = scanner.nextInt();
        System.out.println("Ilość wierszy: " + ileWierszy);
        maxRGB = scanner.nextInt();
        System.out.println("Max wartość RGB: " + maxRGB);

        if (nrPPM == 3) {
            System.out.println("ppm3");
            tablicaZdjecia = new BufferedImage(ileKolumn, ileWierszy, BufferedImage.TYPE_INT_RGB);
            while (scanner.hasNext()) {
                for (int i = 0; i < ileWierszy; i++) {
                    for (int j = 0; j < ileKolumn; j++) {
                        int R = scanner.nextInt();
                        int G = scanner.nextInt();
                        int B = scanner.nextInt();

                        Color color = new Color(R, G, B);
                        int rgb = color.getRGB();
                        tablicaZdjecia.setRGB(j, i, rgb);
                    }
                }
            }

            panel.setImg(tablicaZdjecia);
            this.pack();

        } else {
            System.out.println("ppm6");
            FileInputStream input = new FileInputStream((file));
            ileKolumn = ileKolumn - ileKolumn / 2;
            tablicaZdjecia = new BufferedImage(ileKolumn, ileWierszy, BufferedImage.TYPE_INT_RGB);
            double dzielnik = 65536;
            for (int i = 0; i < ileWierszy; i++) {
                for (int j = 0; j < ileKolumn; j++) {

                    double R1 = (input.read() << 8);
                    double R2 = input.read();

                    double G1 = (input.read() << 8);
                    double G2 = input.read();

                    double B1 = (input.read() << 8);
                    double B2 = input.read();

                    double pomR = R1 + R2;
                    double pomG = G1 + G2;
                    double pomB = B1 + B2;

                    double podzielR = pomR / dzielnik;
                    double podzielG = pomG / dzielnik;
                    double podzielB = pomB / dzielnik;

                    double R = podzielR * 255;
                    double G = podzielG * 255;
                    double B = podzielB * 255;

                    Color color = new Color((int) G, (int) R, (int) B);
                    int rgb = color.getRGB();
                    tablicaZdjecia.setRGB(j, i, rgb);
                }

                panel.setImg(tablicaZdjecia);
                this.pack();
            }

        }
    }

    private void odcienSzarosci1ActionPerformed(java.awt.event.ActionEvent evt) {
        int w = tablicaZdjecia.getWidth();
        int h = tablicaZdjecia.getHeight();

        int[] dataBuffInt = tablicaZdjecia.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage pomocnicze = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
         for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    float R = c.getRed();
                    float B = c.getBlue();
                    float G = c.getGreen();
                    
                    float tmp =(R + G + B)/3;
                    R = tmp;
                    G = tmp;
                    B = tmp;
                    
                   

                    Color nowy = new Color((int)R,(int) G,(int) B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            panel.setImg(pomocnicze);
    
    }

    private void odcienSzarosci2ActionPerformed(java.awt.event.ActionEvent evt) {
        int w = tablicaZdjecia.getWidth();
        int h = tablicaZdjecia.getHeight();

        int[] dataBuffInt = tablicaZdjecia.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage pomocnicze = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
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
                    
                   

                    Color nowy = new Color((int)R,(int) G,(int) B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }

            panel.setImg(pomocnicze);
    }

    public void dodawanieOdejmowanie() {
        int w = tablicaZdjecia.getWidth();
        int h = tablicaZdjecia.getHeight();

        int[] dataBuffInt = tablicaZdjecia.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage pomocnicze = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        if (dodawanieBlue.getValue() != poprzedniDodanyB) {

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    int R = c.getRed();
                    int B = c.getBlue();
                    int G = c.getGreen();
                    // System.out.println("R:" +R+" G:"+G+" B:"+B +" dodawanie teraz="+ dodawanieRed.getValue());;
                    B = B + dodawanieBlue.getValue();
                    if (B > 255) {
                        B = 255;
                    }
                    if (B < 0) {
                        B = 0;
                    }

                    // System.out.println("R"+R + " stare R"+ c.getRed());
                    Color nowy = new Color(R, G, B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            poprzedniDodanyB = dodawanieBlue.getValue();
            panel.setImg(pomocnicze);
            dodawanieGreen.setValue(0);
            dodawanieRed.setValue(0);

        }
        if (dodawanieGreen.getValue() != poprzedniDodanyG) {

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    int R = c.getRed();
                    int B = c.getBlue();
                    int G = c.getGreen();

                    G = G + dodawanieGreen.getValue();
                    if (G > 255) {
                        G = 255;
                    }
                    if (G < 0) {
                        G = 0;
                    }

                    Color nowy = new Color(R, G, B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            poprzedniDodanyG = dodawanieGreen.getValue();
            panel.setImg(pomocnicze);
            dodawanieBlue.setValue(0);
            dodawanieRed.setValue(0);
        }
        if (dodawanieRed.getValue() != poprzedniDodanyR) {

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    int R = c.getRed();
                    int B = c.getBlue();
                    int G = c.getGreen();
                    //System.out.println("R:" +R+" G:"+G+" B:"+B +" dodawanie teraz="+ dodawanieRed.getValue());
                    R = R + dodawanieRed.getValue();
                    if (R > 255) {
                        R = 255;
                    }
                    if (R < 0) {
                        R = 0;
                    }
                    Color nowy = new Color(R, G, B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            poprzedniDodanyR = dodawanieRed.getValue();
            panel.setImg(pomocnicze);
            dodawanieBlue.setValue(0);
            dodawanieGreen.setValue(0);

        }

    }
       
    public void mnozenieDzielenie(){
        int w = tablicaZdjecia.getWidth();
        int h = tablicaZdjecia.getHeight();

        int[] dataBuffInt = tablicaZdjecia.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage pomocnicze = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        if (mnozenieRed.getValue() != poprzedniMnozonyR) {

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    float R = c.getRed();
                    float B = c.getBlue();
                    float G = c.getGreen();
                    float tmp =(float) mnozenieRed.getValue();
                    tmp = tmp /100;
                    R =R * tmp;
                    if (R > 255) {
                        R = 255;
                    }
                    if (R < 0) {
                        R = 0;
                    }
                    Color nowy = new Color((int)R,(int) G,(int) B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            poprzedniMnozonyR = mnozenieRed.getValue();
            panel.setImg(pomocnicze);
            mnozenieGreen.setValue(200);
            mnozenieBlue.setValue(200);
        }
        
        if (mnozenieGreen.getValue() != poprzedniMnozonyG) {

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    float R = c.getRed();
                    float B = c.getBlue();
                    float G = c.getGreen();
                    // System.out.println("R:" +R+" G:"+G+" B:"+B +" dodawanie teraz="+ dodawanieRed.getValue());;
                    float tmp =(float) mnozenieGreen.getValue();
                    tmp = tmp /100;
                    G =G * tmp;
                    if (G > 255) {
                        G = 255;
                    }
                    if (G < 0) {
                        G = 0;
                    }

                    // System.out.println("R"+R + " stare R"+ c.getRed());
                    Color nowy = new Color((int)R,(int) G,(int) B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            poprzedniMnozonyG = mnozenieGreen.getValue();
            panel.setImg(pomocnicze);
            mnozenieRed.setValue(200);
            mnozenieBlue.setValue(200);
        }
        
        
        if (mnozenieBlue.getValue() != poprzedniMnozonyB) {

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    float R = c.getRed();
                    float B = c.getBlue();
                    float G = c.getGreen();
                    // System.out.println("R:" +R+" G:"+G+" B:"+B +" dodawanie teraz="+ dodawanieRed.getValue());;
                    float tmp =(float) mnozenieBlue.getValue();
                    tmp = tmp /100;
                    B = B * tmp;
                    if (B > 255) {
                        B = 255;
                    }
                    if (B < 0) {
                        B = 0;
                    }

                    // System.out.println("R"+R + " stare R"+ c.getRed());
                    Color nowy = new Color((int) R,(int) G,(int) B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            poprzedniMnozonyB = mnozenieBlue.getValue();
            panel.setImg(pomocnicze);
            mnozenieRed.setValue(200);
            mnozenieGreen.setValue(200);
        }
        
    }
    
    public void jasnosc(){
        int w = tablicaZdjecia.getWidth();
        int h = tablicaZdjecia.getHeight();

        int[] dataBuffInt = tablicaZdjecia.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage pomocnicze = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
         for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    int R = c.getRed();
                    int B = c.getBlue();
                    int G = c.getGreen();
                    R = R + jasnosc.getValue();
                    G = G + jasnosc.getValue();
                    B = B + jasnosc.getValue();
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

                    Color nowy = new Color(R, G, B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            panel.setImg(pomocnicze);
        
    }
    
    public void kontrast(){
    int w = tablicaZdjecia.getWidth();
        int h = tablicaZdjecia.getHeight();

        int[] dataBuffInt = tablicaZdjecia.getRGB(0, 0, w, h, null, 0, w);

        int index = 0;

        BufferedImage pomocnicze = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        
         for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    Color c = new Color(dataBuffInt[index]);
                    float R = c.getRed();
                    float B = c.getBlue();
                    float G = c.getGreen();
                    float tmp =(float) kontrast.getValue();
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

                    Color nowy = new Color((int)R,(int) G,(int) B);
                    int rgb = nowy.getRGB();
                    pomocnicze.setRGB(j, i, rgb);
                    index++;
                }
            }
            panel.setImg(pomocnicze);
    }
    
     @Override
    public void stateChanged(ChangeEvent e) {

        if ("DodawanieSlider".equals(e.getSource().getClass().getSimpleName())) {
            // System.out.println("dodawanie / odejmowanie");
            new Thread(new Runnable() {
                public void run() {
                    dodawanieOdejmowanie();
                }
            }).start();

        } else if ("MnozenieSlider".equals(e.getSource().getClass().getSimpleName())) {
            //System.out.println("mnozenie / dzielenie");
            new Thread(new Runnable() {
                public void run() {
                    mnozenieDzielenie();
                }
            }).start();
            
        } else if ("JasnoscSlider".equals(e.getSource().getClass().getSimpleName())) {
            //System.out.println("jasnosc");
            new Thread(new Runnable() {
                public void run() {
                    jasnosc();
                }
            }).start();
        } else if ("Kontrast".equals(e.getSource().getClass().getSimpleName())) {
            //System.out.println("kontrast");
            new Thread(new Runnable() {
                public void run() {
                    kontrast();
                }
            }).start();
        }

    }

    public static void main(String args[]) {

        new PointTransformation().setVisible(true);

    }

    // Variables declaration - do not modify                     
    private DodawanieSlider dodawanieBlue;
    private DodawanieSlider dodawanieGreen;
    private DodawanieSlider dodawanieRed;
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
    private JasnoscSlider jasnosc;
    private Kontrast kontrast;
    private MnozenieSlider mnozenieBlue;
    private MnozenieSlider mnozenieGreen;
    private MnozenieSlider mnozenieRed;
    private javax.swing.JToggleButton odcienSzarosci1;
    private javax.swing.JButton odcienSzarosci2;
    private javax.swing.JMenuItem openButton;
    private Panel panel;
    private int ileWierszy;
    private int ileKolumn;
    private int nrPPM;
    private int maxRGB;
    private BufferedImage tablicaZdjecia;
    int poprzedniDodanyR = 0;
    int poprzedniDodanyG = 0;
    int poprzedniDodanyB = 0;
    int poprzedniMnozonyR = 200;
    int poprzedniMnozonyG = 200;
    int poprzedniMnozonyB = 200;
                   

}
