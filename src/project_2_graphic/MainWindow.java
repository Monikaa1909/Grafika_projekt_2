package project_2_graphic;

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


public class MainWindow extends JFrame{
    private BufferedImage img, resizedImage;
    private ImageIcon imgIcon;
    Graphics2D graphics2D;
    private JPanel imgPanel;

    private static String comment = null;
    private static final List<Comment> comments = new ArrayList<Comment>();
    private static int file_type;   // 1 - jpg/jpeg, 3 - p3, 6 - p6
    private static int width, height, maks_color;
    int targetWidth, targetHeight;
    
    public MainWindow() {
        super("THE COOLEST COMPUTER GRAPHICS PROGRAM");
        doFrame();
    }
    
    private void doFrame() {
        setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new FlowLayout());
        JButton saveButton = new JButton("Save");
        JButton openButton = new JButton("Load");
        JButton increaseButton = new JButton("+");
        JButton reduceButton = new JButton("-");
        saveButton.addActionListener(new SaveListener());
        openButton.addActionListener(new LoadListener());
        increaseButton.addActionListener(new increaseListener());
        reduceButton.addActionListener(new reduceListener());
        buttons.add(openButton);
        buttons.add(saveButton);
        buttons.add(increaseButton);
        buttons.add(reduceButton);
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

                for (int y = 0; y < img.getHeight(); y++) {
                    for (int x = 0; x < img.getWidth(); x++) {
//                        System.out.println(img.getRGB(x, y));
//                        int RGBA = img.getRGB(x, y);
//                        int alpha = (RGBA >> 24) & 255;
//                        int red = (RGBA >> 16) & 255;
//                        int green = (RGBA >> 8) & 255;
//                        int blue = RGBA & 255;
                    }
                }
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

            fileChooser.addChoosableFileFilter(p3);
            fileChooser.addChoosableFileFilter(p6);
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

    private class increaseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            targetWidth = (int) (2 * img.getWidth());
            targetHeight = (int) (2 * img.getHeight());

            resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(img, 0, 0, targetWidth, targetHeight, null);
            graphics2D.dispose();

            img = resizedImage;
            imgIcon.setImage(img);
            pack();
            setLocationRelativeTo(null);
            repaint();
        }
    }

    private class reduceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            targetWidth = (int) (0.5 * img.getWidth());
            targetHeight = (int) (0.5 * img.getHeight());

            RenderingHints rh = new RenderingHints(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            graphics2D = resizedImage.createGraphics();
            graphics2D.setRenderingHints(rh);
            graphics2D.drawImage(img, 0, 0, targetWidth, targetHeight, null);
            graphics2D.dispose();

            img = resizedImage;
            imgIcon.setImage(img);
//            pack();
            setLocationRelativeTo(null);
            repaint();
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
                char[] dataParsed = new char[data.length];
                for (int j = 0; j < data.length; j++) {
                    dataParsed[j] = (char) data[j];
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

                if (file_type == 3) {
                    return p3(s, data, i);
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

    private static BufferedImage p3(String s, byte[] data, int currentIndex) {
        FileReader fileReader = null;
        BufferedImage bufferedImage = null;
        try {

            fileReader = new FileReader(s);
            BufferedReader br = new BufferedReader(fileReader);
            Scanner in = new Scanner(br);
            String temp = "";
            boolean isComment = false;
            int loadedParameters = 0;
            String currentComment = "";
            List<Integer> nextColors = new ArrayList<>();
            int currentColor = 0;
            int red = 0, green = 0, blue;
            int row = 0;
            int col = 0;
            while (loadedParameters < 4) {
                if ((char) data[currentIndex] == '#') {
                    isComment = true;
                    currentIndex++;
                    continue;
                }

                if (isComment && (char) data[currentIndex] != '\n') {
                    currentComment += (char) data[currentIndex++];
                    continue;
                } else if (isComment && (char) data[currentIndex] == '\n') {
                    currentIndex++;
                    comments.add(new Comment(currentComment, currentIndex));
                    currentComment = "";
                    isComment = false;
                    continue;
                }

                switch (loadedParameters) {
                    case 0:
                        while (Character.isDigit((char) data[currentIndex])) {
                            temp += (char) data[currentIndex++];
                        }

                        if ((!Character.isDigit((char) data[currentIndex]) || (char) data[currentIndex] == '\n') && temp != "") {
                            width = Integer.parseInt(temp);
                            temp = "";
                            loadedParameters++;
                            continue;
                        }

                        currentIndex++;
                        break;
                    case 1:
                        while (Character.isDigit((char) data[currentIndex])) {
                            temp += (char) data[currentIndex++];
                        }

                        if ((!Character.isDigit((char) data[currentIndex]) || (char) data[currentIndex] == '\n') && temp != "") {
                            height = Integer.parseInt(temp);
                            temp = "";
                            loadedParameters++;
                            continue;
                        }

                        currentIndex++;
                        break;
                    case 2:
                        while (Character.isDigit((char) data[currentIndex])) {
                            temp += (char) data[currentIndex++];
                        }

                        if ((!Character.isDigit((char) data[currentIndex]) || (char) data[currentIndex] == '\n') && temp != "") {
                            maks_color = Integer.parseInt(temp);
                            temp = "";
                            loadedParameters++;
                            continue;
                        }

                        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                        currentIndex++;
                        break;
                    case 3:
                        while (Character.isDigit((char) data[currentIndex])) {
                            temp += (char) data[currentIndex++];
                        }

                        if ((!Character.isDigit((char) data[currentIndex]) || (char) data[currentIndex] == '\n') && temp != "") {
                            if (currentColor == 0) {
                                red = Integer.parseInt(temp);
                                red *= 255;
                                red /= maks_color;
                                currentColor = (currentColor + 1) % 3;
                            } else if (currentColor == 1) {
                                green = Integer.parseInt(temp);
                                green *= 255;
                                green /= maks_color;
                                currentColor = (currentColor + 1) % 3;
                            } else if (currentColor == 2) {
                                blue = Integer.parseInt(temp);
                                blue *= 255;
                                blue /= maks_color;
                                currentColor = (currentColor + 1) % 3;

                                if (red > maks_color || green > maks_color || blue > maks_color) {
                                    JOptionPane.showMessageDialog(null, "Something is wrong with the file... " +
                                            "the colors exceed the maximum values :o");
                                    return null;
                                }

                                bufferedImage.setRGB(col, row, toRGB(red, green, blue));
                                if (col < width - 1)  ++col;
                                else col = 0;

                                if (row < height - 1)  ++row;
                                else row = 0;
                                if (currentIndex >= data.length - 1) loadedParameters++;
                            }

                            temp = "";
                            continue;
                        }

                        currentIndex++;
                        break;
                }
            }

//            for (int i = 0; i < height; i++) {
//                for (int j = 0; j < width; j++) {
//
//                    red = in.nextInt();
//                    red *= 255;
//                    red /= maks_color;
//
//                    green = in.nextInt();
//                    green *= 255;
//                    green /= maks_color;
//
//                    blue = in.nextInt();
//                    blue *= 255;
//                    blue /= maks_color;
//
//                    if (red > maks_color || green > maks_color || blue > maks_color) {
//                        JOptionPane.showMessageDialog(null, "Something is wrong with the file... " +
//                                "the colors exceed the maximum values :o");
//                        return null;
//                    }
//                    bufferedImage.setRGB(j, i, toRGB(red, green, blue));
//                }
//            }
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
        BufferedImage bufferedImage;
        String temp = "";
        boolean isComment = false;
        int loadedParameters = 0;
        String currentComment = "";

        while (loadedParameters < 3) {
            if ((char) data[start] == '#') {
                isComment = true;
                start++;
                continue;
            }

            if (isComment && (char) data[start] != '\n') {
                currentComment += (char) data[start++];
                continue;
            } else if (isComment && (char) data[start] == '\n') {
                start++;
//                        comments.add(currentComment);
                currentComment = "";
                isComment = false;
                continue;
            }

            switch (loadedParameters) {
                case 0:
                    while (Character.isDigit((char) data[start])) {
                        temp += (char) data[start++];
                    }

                    if ((!Character.isDigit((char) data[start]) || (char) data[start] == '\n') && temp != "") {
                        width = Integer.parseInt(temp);
                        temp = "";
                        loadedParameters++;
                        continue;
                    }

                    start++;
                    break;
                case 1:
                    while (Character.isDigit((char) data[start])) {
                        temp += (char) data[start++];
                    }

                    if ((!Character.isDigit((char) data[start]) || (char) data[start] == '\n') && temp != "") {
                        height = Integer.parseInt(temp);
                        temp = "";
                        loadedParameters++;
                        continue;
                    }

                    start++;
                    break;
                case 2:
                    while (Character.isDigit((char) data[start])) {
                        temp += (char) data[start++];
                    }

                    if ((!Character.isDigit((char) data[start]) || (char) data[start] == '\n') && temp != "") {
                        maks_color = Integer.parseInt(temp);
                        temp = "";
                        loadedParameters++;
                        continue;
                    }

                    start++;
                    break;
            }
        }

        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
//            System.out.println("");
        }
        return bufferedImage;
    }

    private static void saveAsP3(BufferedImage img, File f) {
        try {
            PrintWriter pw = new PrintWriter(f);
            // sprawdzenie komentarza i dodanie go
            pw.write("P3" + "\n");
            if (comment != null) {
                pw.write(comment + "\n");
            }

            pw.write(img.getWidth() + " ");
            // sprawdzenie komentarza i dodanie go
            pw.write(img.getHeight() + "\n");
            // sprawdzenie komentarza i dodanie go
            pw.write(255 + "\n");
            // sprawdzenie komentarza i dodanie go
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
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error while writing to file in ppm p3 format :(");
        }
    }

    private static void saveAsP6(BufferedImage img, File f) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            // sprawdzenie komentarza i dodanie go
            fos.write(("P6" + "\n").getBytes("US-ASCII"));
            // sprawdzenie komentarza i dodanie go
            fos.write((String.valueOf(img.getWidth()) + " ").getBytes("US-ASCII"));
            // sprawdzenie komentarza i dodanie go
            fos.write((String.valueOf(img.getHeight()) + "\n").getBytes("US-ASCII"));
            // sprawdzenie komentarza i dodanie go
            fos.write((String.valueOf(255) + "\n").getBytes("US-ASCII"));
            // sprawdzenie komentarza i dodanie go
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

    public static String readNotCommentedLine(Scanner scanner) {
        String readLine;
        try {
            do {
                readLine = scanner.nextLine();
            } while (readLine.startsWith("#"));
        } catch (NoSuchElementException e) {
            return null;
        }

        return readLine;
    }
}
