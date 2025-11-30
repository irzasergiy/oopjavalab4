public class Main {
    private static final String KEY = "Ірза Сергій Іванович";

    private static String encode(String text, String key) {
        StringBuilder r = new StringBuilder();
        int k = key.length();
        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            char c = key.charAt(i % k);
            r.append((char)(t + c));
        }
        return r.toString();
    }

    private static String decode(String text, String key) {
        StringBuilder r = new StringBuilder();
        int k = key.length();
        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            char c = key.charAt(i % k);
            r.append((char)(t - c));
        }
        return r.toString();
    }

    public static void main(String[] args) {
        String source = "Важливими характеристиками мови Java є: розвинутий синтаксис; платформонезалежність; придатна для створення великих і складних програм; технологічною для реалізації програм опрацювання баз даних, аплетів, сервлетів для мережевих технологій.";

        String encoded = encode(source, KEY);
        String decoded = decode(encoded, KEY);

        System.out.println("Кодований текст:");
        System.out.println(encoded);
        System.out.println();
        System.out.println("Розкодований текст:");
        System.out.println(decoded);
    }
}
