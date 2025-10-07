import java.util.Scanner;

// Абстрактний базовий клас
abstract class Solid {
    // Абстрактний метод
    public abstract double getVolume();

    // Метод порівняння об'єктів за об'ємом
    public boolean isSameVolume(Solid other) {
        return this.getVolume() == other.getVolume();
    }
}

// Клас Cube
class Cube extends Solid {
    private double a;                      // private поле — довжина ребра
    public static int count = 0;           // static поле — лічильник об'єктів

    // Конструктор з ключовим словом this
    public Cube(double a) {
        this.a = a;
        count++; // Підрахунок створених об'єктів
    }

    // Геттер (public)
    public double getA() {
        return a;
    }

    // Сеттер (public)
    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double getVolume() {
        return Math.pow(a, 3);
    }
}

// Клас RectSolid
class RectSolid extends Solid {
    private double c;           // довжина основи
    private double d;           // ширина
    protected double h;         // висота (protected для прикладу)

    // Конструктор з this
    public RectSolid(double c, double d, double h) {
        this.c = c;
        this.d = d;
        this.h = h;
    }

    // Геттери
    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getH() {
        return h;
    }

    // Сеттери
    public void setC(double c) {
        this.c = c;
    }

    public void setD(double d) {
        this.d = d;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public double getVolume() {
        return c * d * h;
    }
}

// Головний клас
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cube
        System.out.print("Введіть довжину ребра куба A: ");
        double A = scanner.nextDouble();
        Cube cube = new Cube(A);

        // RectSolid
        System.out.print("Введіть довжину C: ");
        double C = scanner.nextDouble();
        System.out.print("Введіть ширину D: ");
        double D = scanner.nextDouble();
        System.out.print("Введіть висоту H: ");
        double H = scanner.nextDouble();
        RectSolid rectSolid = new RectSolid(C, D, H);

        // Вивід об'ємів
        System.out.println("Об'єм куба: " + cube.getVolume());
        System.out.println("Об'єм прямокутного паралелепіпеда: " + rectSolid.getVolume());

        // Порівняння об'єктів
        if (cube.isSameVolume(rectSolid)) {
            System.out.println("Об'єми об'єктів однакові.");
        } else {
            System.out.println("Об'єми об'єктів різні.");
        }

        // Виведення кількості створених кубів
        System.out.println("Кількість створених об'єктів Cube: " + Cube.count);

        scanner.close();
    }
}
