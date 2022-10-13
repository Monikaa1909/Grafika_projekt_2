package graphic;

import java.awt.EventQueue;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Okno o = new Okno();
                o.setVisible(true);
            }
        });
    }
}
