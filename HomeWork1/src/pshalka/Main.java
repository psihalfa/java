package pshalka;
public class Main {
    public static void main(String[] args) {

        System.out.println("a * (b + (c / d)) = " + Two(1,2,3,4));
        System.out.println(Three(5, 8));
        Four(5);
        System.out.println(Five(-3));
        Six("Ерлан");
        Seven(2016);
    }

    // Задание 3
    static double Two(double a, double b, double c, double d) {
        System.out.println("\nЗадание 3.");
        return a * (b + (c / d));
    }

    // Задание 4

    static boolean Three(int a, int b) {
        System.out.println("\nЗадание 4.");
        int sum = a + b;
        if (sum > 10 && sum < 20) return true;
        else return false;
    }

    // Задание 5
    static void Four(int a) {
        System.out.println("\nЗадание 5.");
        if (a >= 0) System.out.println("Число " + a + " положительное");
        else System.out.println("Число " + a + " отрицательное");
    }

    // Задание 6
    static boolean Five(int a) {
        System.out.println("\nЗадание 6.");
        if (a < 0) return true;
        return false;
    }

    // Задание 7
    static void Six(String name) {
        System.out.println("\nЗадание 7.");
        System.out.println("Привет, " + name + "!");
    }

    // Задание 8
    static void Seven(int year) {
        System.out.println("\nЗадание 8.");
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0)))
            System.out.println(year + " Не високосный");
        else
            System.out.println(year + " Високосный");
    }
}