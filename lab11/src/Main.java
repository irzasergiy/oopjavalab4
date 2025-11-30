import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    private final List<Point> points = new ArrayList<>();

    public Main() {
        setTitle("Малювання мишею");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Point p : points) {
                    g.fillOval(p.x - 3, p.y - 3, 6, 6);
                }
            }
        };

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                points.add(e.getPoint());
                panel.repaint();
            }
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                panel.repaint();
            }
        });

        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "clear");
        panel.getActionMap().put("clear", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                points.clear();
                panel.repaint();
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
