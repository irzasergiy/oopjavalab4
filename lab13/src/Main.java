import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Меню");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        // -------- РАМКА --------
        JMenu frameMenu = new JMenu("Рамка");

        JMenuItem backgroundItem = new JMenuItem("Фон");
        JCheckBoxMenuItem borderItem = new JCheckBoxMenuItem("Межа");

        frameMenu.add(backgroundItem);
        frameMenu.add(borderItem);

        // -------- ТАБЛИЦЯ --------
        JMenu tableMenu = new JMenu("Таблиця");
        JMenu selectSubMenu = new JMenu("Виділити");

        JMenuItem selectTable = new JMenuItem("Таблицю");
        JMenuItem selectColumn = new JMenuItem("Стовпець");
        JMenuItem selectRow = new JMenuItem("Рядок");
        JMenuItem selectCell = new JMenuItem("Клітинку");

        selectSubMenu.add(selectTable);
        selectSubMenu.add(selectColumn);
        selectSubMenu.add(selectRow);
        selectSubMenu.add(selectCell);

        tableMenu.add(selectSubMenu);

        // Додаємо меню у рядок меню
        menuBar.add(frameMenu);
        menuBar.add(tableMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
