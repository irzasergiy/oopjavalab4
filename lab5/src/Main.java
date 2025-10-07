import java.util.Scanner;

// Інтерфейс з поведінкою
interface IVolumetric {
    double getVolume();
    boolean isSameVolume(IVolumetric other);
}

// Абстрактний клас, що реалізує інтерфейс
abstract class Solid implements IVolumetric {
    @Override
    public boolean isSameVolume(IVolumetric other) {
        return this.getVolume() == other.getVolume();
    }
}

// Клас Cube
class Cube extends Solid {
    private final double a;            // довжина ребра
    public static int count = 0;       // статичне поле

    public Cube(double a) {
        this.a = a;
        count++;
    }

    @Override
    public double getVolume() {
        return Math.pow(a, 3);
    }

    public double getA() {
        return a;
    }
}

// Клас прямокутного паралелепіпеда
class RectSolid extends Solid {
    private final double c;    // довжина
    private final double d;    // ширина
    protected double h;        // висота

    public RectSolid(double c, double d, double h) {
        this.c = c;
        this.d = d;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return c * d * h;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getH() {
        return h;
    }
}

// Основний клас
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Створення куба (тип класу)
        System.out.print("Введіть довжину ребра ПЕРШОГО куба: ");
        double a1 = scanner.nextDouble();
        Cube cube1 = new Cube(a1);  // тип класу

        // 2. Створення прямокутного паралелепіпеда (тип батьківського класу)
        System.out.print("Введіть довжину прямокутного паралелепіпеда (C): ");
        double c = scanner.nextDouble();
        System.out.print("Введіть ширину прямокутного паралелепіпеда (D): ");
        double d = scanner.nextDouble();
        System.out.print("Введіть висоту прямокутного паралелепіпеда (H): ");
        double h = scanner.nextDouble();
        Solid rectSolid = new RectSolid(c, d, h);  // тип батьківського класу

        // 3. Створення другого куба (тип інтерфейсу)
        System.out.print("Введіть довжину ребра ДРУГОГО куба (через інтерфейс): ");
        double a2 = scanner.nextDouble();
        IVolumetric cube2 = new Cube(a2);  // тип інтерфейсу

        System.out.println("\n=== Результати ===");
        System.out.println("Об'єм ПЕРШОГО куба (тип класу): " + cube1.getVolume());
        System.out.println("Об'єм прямокутного паралелепіпеда (тип батьківський клас): " + rectSolid.getVolume());
        System.out.println("Об'єм ДРУГОГО куба (тип інтерфейс): " + cube2.getVolume());

        // Порівняння об'єктів
        System.out.println();
        if (cube1.isSameVolume(rectSolid)) {
            System.out.println("Об'єм ПЕРШОГО куба і прямокутного паралелепіпеда однаковий.");
        } else {
            System.out.println("Об'єм ПЕРШОГО куба і прямокутного паралелепіпеда різний.");
        }

        if (cube1.isSameVolume(cube2)) {
            System.out.println("Об'єм ПЕРШОГО і ДРУГОГО кубів однаковий.");
        } else {
            System.out.println("Об'єм ПЕРШОГО і ДРУГОГО кубів різний.");
        }

        // Статичне поле
        System.out.println("\nКількість створених кубів: " + Cube.count);

        scanner.close();
    }
}
