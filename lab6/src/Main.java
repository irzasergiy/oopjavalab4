import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> studentMap = new HashMap<>();

        // Додаємо 10 початкових елементів
        studentMap.put("Іванов", "Київ");
        studentMap.put("Петренко", "Львів");
        studentMap.put("Сидоренко", "Одеса");
        studentMap.put("Коваль", "Харків");
        studentMap.put("Ткаченко", "Дніпро");
        studentMap.put("Шевченко", "Черкаси");
        studentMap.put("Мельник", "Житомир");
        studentMap.put("Бондар", "Вінниця");
        studentMap.put("Кравченко", "Полтава");
        studentMap.put("Гончар", "Тернопіль");

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
                    studentMap.put(surname, birthplace);
                    System.out.println("Елемент додано.");
                    break;

                case 2:
                    System.out.print("Введіть прізвище для пошуку: ");
                    String searchKey = scanner.nextLine();
                    if (studentMap.containsKey(searchKey)) {
                        System.out.println("Місце народження: " + studentMap.get(searchKey));
                    } else {
                        System.out.println("Студента з таким прізвищем не знайдено.");
                    }
                    break;

                case 3:
                    System.out.print("Введіть прізвище для видалення: ");
                    String removeKey = scanner.nextLine();
                    if (studentMap.remove(removeKey) != null) {
                        System.out.println("Елемент видалено.");
                    } else {
                        System.out.println("Елемент не знайдено.");
                    }
                    break;

                case 4:
                    System.out.println("Список студентів:");
                    for (Map.Entry<String, String> entry : studentMap.entrySet()) {
                        System.out.println(entry.getKey() + " — " + entry.getValue());
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
