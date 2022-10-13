package project_2_graphic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MainWindow extends JFrame{
    private BufferedImage img;
    private ImageIcon imgIcon;
    private JPanel imgPanel;

    private static String comment = null;
    private static int file_type;   // 1 - jpg/jpeg, 3 - p3, 6 - p6
    private static int width, height, maks_color;
    
    public MainWindow() {
        super("THE COOLEST COMPUTER GRAPHICS PROGRAM");
        doFrame();
    }
    
    private void doFrame() {
        setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Load");
        saveButton.addActionListener(new SaveListener());
        openButton.addActionListener(new LoadListener());
        buttons.add(openButton);
        buttons.add(saveButton);
        setSize(750, 700);
        setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        imgPanel = new JPanel();
        add(buttons, BorderLayout.NORTH);
        imgIcon = new ImageIcon();
        
        imgPanel.add(new JLabel(imgIcon));
        add(imgPanel, BorderLayout.CENTER);
    }
    
    private class LoadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                img = load(selectedFile.getAbsolutePath());
                if (img == null)
                    return;
                imgIcon.setImage(img);
                pack();
                setLocationRelativeTo(null);
                repaint();
            }
        }
    }
    
    private class SaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(img == null)
                return;
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter p3 = new FileNameExtensionFilter("Obraz PPM P3", "ppm");
            FileNameExtensionFilter p6 = new FileNameExtensionFilter("Obraz PPM P6", "ppm");
            FileNameExtensionFilter jpg = new FileNameExtensionFilter("Obraz JPG", "jpg");

            if (file_type != 1) {
                fileChooser.addChoosableFileFilter(p3);
                fileChooser.addChoosableFileFilter(p6);
            }
            fileChooser.addChoosableFileFilter(jpg);
            fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file == null) {
                    return;
                }
                save(img, file.getAbsolutePath(), fileChooser.getFileFilter().getDescription());
            }
        }
    }

    public static void save(BufferedImage img, String s, String desc) {

        if (desc.charAt(desc.length() - 1) == 'G') {
            try {
                ImageIO.write(img, "jpg", new File(s + ".jpg"));
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (desc.charAt(desc.length() - 1) == '3') {
            saveAsP3(img, new File(s + ".ppm"));
        }

        if (desc.charAt(desc.length() - 1) == '6') {
            saveAsP6(img, new File(s + ".ppm"));
        }
    }

    public static BufferedImage load(String s) {
        String extension = "";

        int i = s.lastIndexOf('.');
        if (i > 0) {
            extension = s.substring(i + 1);
        }

        BufferedImage bufferedImage = null;

        if (extension.equals("jpg") || extension.equals("jpeg")) {
            try {
                bufferedImage = ImageIO.read(new File(s));
                file_type = 1;
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else if (extension.equals("ppm")) {

            try {
                Path path = Paths.get(s);

                byte[] data = Files.readAllBytes(path);

                for (int j = 0; j < data.length; j++) {
                    System.out.println((char) data[j]);
                }
                if (((char) data[0]) != 'P' || ((char) data[1] != '3' && (char) data[1] != '6')) {
                    JOptionPane.showMessageDialog(null, "Plik jest nieprawidłowy.");
                    return null;
                }

                file_type = Integer.parseInt("" + (char) data[1]);

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

                maks_color = Integer.parseInt(temp);

                if (file_type == 3) {
                    return p3(s);
                }

                return p6(data, i);

            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        else {
            JOptionPane.showMessageDialog(null, "The file has an inappropriate extension :(");
        }

        return bufferedImage;
    }

    private static BufferedImage p3(String s) {
        FileReader fileReader = null;
        BufferedImage bufferedImage = null;
        try {
            fileReader = new FileReader(s);
            BufferedReader br = new BufferedReader(fileReader);
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
                    red /= maks_color;

                    green = in.nextInt();
                    green *= 255;
                    green /= maks_color;

                    blue = in.nextInt();
                    blue *= 255;
                    blue /= maks_color;

                    if (red > maks_color || green > maks_color || blue > maks_color) {
                        JOptionPane.showMessageDialog(null, "Something is wrong with the file... " +
                                "the colors exceed the maximum values :o");
                        return null;
                    }
                    bufferedImage.setRGB(j, i, toRGB(red, green, blue));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
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

                if (maks_color > 255) {
                    red = (red << 8) | green;
                    green = (blue << 8) | (data[++start] & 0xFF);
                    blue = ((data[++start] & 0xFF) << 8) | (data[++start] & 0xFF);
                }

                if (red > maks_color || green > maks_color || blue > maks_color) {
                    JOptionPane.showMessageDialog(null, "Plik jest nieprawidłowy.");
                    return null;
                }
                bufferedImage.setRGB(j, i, toRGB(red, green, blue));
            }
            System.out.println("");
        }
        return bufferedImage;
    }

    private static void saveAsP3(BufferedImage img, File f) {
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.println("P3");
            System.out.println("p3");
            if (comment != null) {
//                System.out.println(comment);
                pw.println(comment);
            }
            pw.println(img.getWidth() + " " + img.getHeight());
            System.out.println("img.getWidth() + \" \" + img.getHeight()" + img.getWidth() + " " + img.getHeight());
            pw.println(255);
            System.out.println("255");
            int rgb;
            for (int i = 0; i < img.getHeight(); i++) {
                for (int j = 0; j < img.getWidth(); j++) {
                    rgb = img.getRGB(j, i);
                    pw.println(getRed(rgb));
                    System.out.println("getRed(rgb)" + getRed(rgb));
                    pw.println(getGreen(rgb));
                    System.out.println("getGreen(rgb)"+ getGreen(rgb));
                    pw.println(getBlue(rgb));
                    System.out.println("getBlue(rgb)" + getBlue(rgb));

                }
            }
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "BŁĄDMFDJKHVNEFK");
        }

    }

    private static void saveAsP6(BufferedImage img, File f) {
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
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
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
