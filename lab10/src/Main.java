import javax.swing.*;

public class Main {

    // Спосіб 1 — клас-нащадок JFrame
    static class Win1 extends JFrame {
        public Win1() {
            setTitle("Центральне вікно");
            setSize(600, 300);
            setLocationRelativeTo(null);
            setExtendedState(JFrame.ICONIFIED);
            setVisible(true);

            System.out.println("Спосіб 1:");
            System.out.println("Size: " + getSize());
            System.out.println("Location: " + getLocation());
            System.out.println("State: " + getExtendedState());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Спосіб 1
        new Win1();

        // Спосіб 2 — створення JFrame без наслідування
        JFrame f = new JFrame();
        f.setTitle("Центральне вікно");
        f.setSize(600, 300);
        f.setLocationRelativeTo(null);
        f.setExtendedState(JFrame.ICONIFIED);
        f.setVisible(true);

        System.out.println("Спосіб 2:");
        System.out.println("Size: " + f.getSize());
        System.out.println("Location: " + f.getLocation());
        System.out.println("State: " + f.getExtendedState());
    }
}
