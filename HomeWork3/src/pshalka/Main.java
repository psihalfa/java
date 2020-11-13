package pshalka;
import java.util.*;
import java.io.*;
public class Main {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Сделайте выбор:\n" +
                    "1. Угадайте число\n2. Угадайте слово\n3. Выход\n: ");
            switch (sc.next()) {
                case "1":
                    guessTheNumber();
                    break;
                case "2":
                    guessTheWord();
                    break;
                default:
                    return;
            }
        }
    }

    //          Задание 1
    static void guessTheNumber() {
        do {
            int count = 0;
            int guess = -1;
            int number = random.nextInt(10);
            while (count < 3 && guess != number) {
                System.out.print(
                        "Угадать [" + (count + 1) + "] число (0-9): ");
                try {
                    guess = sc.nextInt();
                    if (number == guess) {
                        System.out.println("\n" + "Ты победил(а)!");
                    } else {
                        System.out.println("\n" + "Ваш номер " + ((guess > number) ?  "больше" : "Меньше."));
                        count++;
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("\n" + "Исключение несоответствия ввода!");
                    sc.next();
                }
            }
            if (count == 3)
                System.out.println("\n" + "Ты проиграла(а)!");
            System.out.print("Повторить игру?\n[1 - да / 0 - нет]: ");
        } while (sc.next().equals("1"));
    }

    //          Задание 2
    static void guessTheWord() {
        String[] words = readFromFile(new File("text.txt"));
         /*{"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};
            */
        String guess = null;
        String word = words[random.nextInt(words.length)];
        System.out.println(Arrays.toString(words));
        do {
            System.out.print("Угадай слово: ");
            guess = sc.next();
            for (int i = 0; i < 15; i++)
                if (i < word.length() && i < guess.length() &&
                        word.charAt(i) == guess.charAt(i))
                    System.out.print(word.charAt(i));
                else
                    System.out.print((word.equals(guess)) ? "" : "#");
            System.out.println();
        } while (!word.equals(guess));
    }

    static String[] readFromFile(File file) {
        String str = "";
        try (Scanner read = new Scanner(file))
        {
            while (read.hasNext())
                str += read.nextLine() + "\n";
        }
        catch (IOException ex) {
        }
        return str.split("\n");
    }
}