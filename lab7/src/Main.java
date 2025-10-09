import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String surname;
    String birthplace;

    Student(String surname, String birthplace) {
        this.surname = surname;
        this.birthplace = birthplace;
    }

    @Override
    public String toString() {
        return surname + " — " + birthplace;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Додаємо 10 початкових елементів
        students.add(new Student("Іванов", "Київ"));
        students.add(new Student("Петренко", "Львів"));
        students.add(new Student("Сидоренко", "Одеса"));
        students.add(new Student("Коваль", "Харків"));
        students.add(new Student("Ткаченко", "Дніпро"));
        students.add(new Student("Шевченко", "Черкаси"));
        students.add(new Student("Мельник", "Житомир"));
        students.add(new Student("Бондар", "Вінниця"));
        students.add(new Student("Кравченко", "Полтава"));
        students.add(new Student("Гончар", "Тернопіль"));

        int choice;

        do {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Додати елемент");
            System.out.println("2. Пошук елемента");
            System.out.println("3. Видалити елемент");
            System.out.println("4. Вивести всі записи");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // очистити буфер

            switch (choice) {
                case 1:
                    System.out.print("Введіть прізвище студента: ");
                    String surname = scanner.nextLine();
                    System.out.print("Введіть місце народження: ");
                    String birthplace = scanner.nextLine();
                    students.add(new Student(surname, birthplace));
                    System.out.println("Елемент додано.");
                    break;

                case 2:
                    System.out.print("Введіть прізвище для пошуку: ");
                    String searchSurname = scanner.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.surname.equalsIgnoreCase(searchSurname)) {
                            System.out.println("Знайдено: " + s);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Студента з таким прізвищем не знайдено.");
                    }
                    break;

                case 3:
                    System.out.print("Введіть прізвище для видалення: ");
                    String removeSurname = scanner.nextLine();
                    boolean removed = students.removeIf(s -> s.surname.equalsIgnoreCase(removeSurname));
                    if (removed) {
                        System.out.println("Елемент видалено.");
                    } else {
                        System.out.println("Елемент не знайдено.");
                    }
                    break;

                case 4:
                    System.out.println("Список студентів:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;

                case 0:
                    System.out.println("Завершення роботи.");
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }

        } while (choice != 0);

        scanner.close();
    }
}
