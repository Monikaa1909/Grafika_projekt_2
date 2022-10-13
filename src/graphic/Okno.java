package graphic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Okno extends JFrame{
    private BufferedImage img;
    private ImageIcon imgIcon;
    private JPanel imgPanel;
    
    public Okno() {
        super("PPM Grafika");
        doFrame();
    }
    
    private void doFrame() {
        setLayout(new BorderLayout());
        JPanel panelPrzyciski = new JPanel(new FlowLayout());
        JButton save = new JButton("Zapisz");
        JButton open = new JButton("Wczytaj");
        save.addActionListener(new ZapiszListener());
        open.addActionListener(new WczytajListener());
        panelPrzyciski.add(open);
        panelPrzyciski.add(save);
        setSize(800, 600);
        setDefaultCloseOperation(Okno.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        imgPanel = new JPanel();
        add(panelPrzyciski, BorderLayout.NORTH);
        imgIcon = new ImageIcon();
        
        imgPanel.add(new JLabel(imgIcon));
        add(imgPanel, BorderLayout.CENTER);
        
    }
    
    private class WczytajListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                img = OpenAndSave.wczytaj(selectedFile.getAbsolutePath());
                if(img==null)
                    return;
                imgIcon.setImage(img);
                pack();
                setLocationRelativeTo(null);
                repaint();
                
            }
        }
        
    }
    
    private class ZapiszListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(img==null)
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
                OpenAndSave.zapisz(img, file.getAbsolutePath(), fileChooser.getFileFilter().getDescription());
            }
        }
        
    }
}
