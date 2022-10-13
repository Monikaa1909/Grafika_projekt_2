/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author patryk
 */
public class OpenAndSave {

    private static String comment;
    private static int type, width, height, maks;

    public static void zapisz(BufferedImage img, String s, String desc) {

        if (desc.charAt(desc.length() - 1) == 'G') {
            try {
                ImageIO.write(img, "jpg", new File(s + ".jpg"));
            } catch (IOException ex) {
                Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (desc.charAt(desc.length() - 1) == '3') {
            p3Save(img, new File(s + ".ppm"));
        }

        if (desc.charAt(desc.length() - 1) == '6') {
            p6Save(img, new File(s + ".ppm"));
        }

    }

    public static BufferedImage wczytaj(String s) {
        String extension = "";

        int i = s.lastIndexOf('.');
        if (i > 0) {
            extension = s.substring(i + 1);
        }

        BufferedImage bi = null;

        if (extension.equals("jpg") || extension.equals("jpeg")) {
            try {
                bi = ImageIO.read(new File(s));
                type = 1;
            } catch (IOException ex) {
                Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (extension.equals("ppm")) {

            try {
                Path path = Paths.get(s);
                byte[] data = Files.readAllBytes(path);
                if (((char) data[0]) != 'P' || ((char) data[1] != '3' && (char) data[1] != '6')) {
                    JOptionPane.showMessageDialog(null, "Plik jest nieprawidłowy.");
                    return null;
                }

                type = Integer.parseInt("" + (char) data[1]);

                i = 2;
                if ((char) data[i + 1] == '#') {
                    comment = "";
                    for (i = 3; data[i] != '\n' && data[i + 1] != '#'; i++) {
                        comment += (char) data[i];
                    }
                }
                String temp = "";

                while (Character.isDigit((char) data[++i])) {
                    temp += (char) data[i];
                }

                width = Integer.parseInt(temp);

                temp = "";
                while (Character.isDigit((char) data[++i])) {
                    temp += (char) data[i];
                }

                height = Integer.parseInt(temp);

                temp = "";
                while (Character.isDigit((char) data[++i])) {
                    temp += (char) data[i];
                }

                maks = Integer.parseInt(temp);

                if (type == 3) {
                    return p3(s);
                }

                return p6(data, i);

            } catch (IOException ex) {
                Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return bi;
    }

    private static BufferedImage p3(String s) {
        FileReader fr = null;
        BufferedImage bufferedImage = null;
        try {
            fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            Scanner in = new Scanner(br);
            in.nextLine();
            while (in.hasNext("#")) {
                in.nextLine();
            }
            in.nextLine();
            in.nextLine();

            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            int red, green, blue;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    red = in.nextInt();
                    red *= 255;
                    red /= maks;

                    green = in.nextInt();
                    green *= 255;
                    green /= maks;

                    blue = in.nextInt();
                    blue *= 255;
                    blue /= maks;

                    if (red > maks || green > maks || blue > maks) {
                        JOptionPane.showMessageDialog(null, "Plik jest nieprawidłowy.");
                        return null;
                    }
                    bufferedImage.setRGB(j, i, toRGB(red, green, blue));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return bufferedImage;
    }

    private static BufferedImage p6(byte[] data, int start) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        int red, green, blue;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                red = 0;
                green = 0;
                blue = 0;

                red = data[++start] & 0xFF;
                green = data[++start] & 0xFF;
                blue = data[++start] & 0xFF;

                if (maks > 255) {
                    red = (red << 8) | green;
                    green = (blue << 8) | (data[++start] & 0xFF);
                    blue = ((data[++start] & 0xFF) << 8) | (data[++start] & 0xFF);
                }

                if (red > maks || green > maks || blue > maks) {
                    JOptionPane.showMessageDialog(null, "Plik jest nieprawidłowy.");
                    return null;
                }
                bufferedImage.setRGB(j, i, toRGB(red, green, blue));
            }
            System.out.println("");
        }
        return bufferedImage;
    }

    private static void p3Save(BufferedImage img, File f) {
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.println("P3");
            if (type != 1 && comment != null) {
                pw.println(comment);
            }
            pw.println(img.getWidth() + " " + img.getHeight());
            pw.println(255);
            int rgb;
            for (int i = 0; i < img.getHeight(); i++) {
                for (int j = 0; j < img.getWidth(); j++) {
                    rgb = img.getRGB(j, i);
                    pw.println(getRed(rgb));
                    pw.println(getGreen(rgb));
                    pw.println(getBlue(rgb));

                }
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void p6Save(BufferedImage img, File f) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            String s = new String("P6\n" + String.valueOf(img.getWidth()) + " "
                    + String.valueOf(img.getHeight()) + "\n"
                    + String.valueOf(255) + "\n");

            fos.write(s.getBytes("US-ASCII"));
            int rgb;
            for (int i = 0; i < img.getHeight(); i++) {
                for (int j = 0; j < img.getWidth(); j++) {
                    rgb = img.getRGB(j, i);
                    fos.write((byte) getRed(rgb));
                    fos.write((byte) getGreen(rgb));
                    fos.write((byte) getBlue(rgb));

                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OpenAndSave.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static int toRGB(int r, int g, int b) {
        return (int) ((((r << 8) | g) << 8) | b);
    }

    public static int getRed(int rgb) {
        return (int) (rgb >> 16) & 0xff;
    }

    public static int getGreen(int rgb) {
        return (int) (rgb >> 8) & 0xff;
    }

    public static int getBlue(int rgb) {
        return (int) (rgb) & 0xff;
    }

}
