package pshalka;
import java.util.Random;
import java.util.Scanner;
public class Main {

    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int TO_WIN = 4;

    private static final char[][] field = new char[SIZE_Y][SIZE_X];

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static void initFields() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    public static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X (от 1 до " + SIZE_X + ")   Y  (от 1 до " + SIZE_Y + ")");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSym(y, x, DOT_X);
    }

            //Задание 4
    public static void aiStep() {
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, DOT_O);
                    if (checkWin(DOT_O)) return;
                    setSym(i, j, DOT_EMPTY);
                }
            }
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, DOT_X);
                    if (checkWin(DOT_X)) {
                        setSym(i, j, DOT_O);
                        return;
                    }
                    setSym(i, j, DOT_EMPTY);
                }
            }
        int x;
        int y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));
        setSym(y, x, DOT_O);
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == DOT_EMPTY;
    }

    public static boolean isFuelFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Задание 2-3
    private static boolean checkWin(char sym) {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (checkLine(i, j, 0, 1, sym)) return true;
                if (checkLine(i, j, 1, 1, sym)) return true;
                if (checkLine(i, j, 1, 0, sym)) return true;
                if (checkLine(i, j, -1, 1, sym)) return true;
            }
        }
        return false;
    }

    private static boolean checkLine(int y, int x, int vy, int vx, char sym) {
        int wayX = x + (TO_WIN - 1) * vx;
        int wayY = y + (TO_WIN - 1) * vy;
        if (wayX < 0 || wayY < 0 || wayX > SIZE_X - 1 || wayY > SIZE_Y - 1) return false;
        for (int i = 0; i < TO_WIN; i++) {
            int itemY = y + i * vy;
            int itemX = x + i * vx;
            if (field[itemY][itemX] != sym) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        initFields();
        printField();

        while (true) {
            playerStep();
            printField();
            if (checkWin(DOT_X)) {
                System.out.println("Победил игрок!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiStep();
            printField();
            if (checkWin(DOT_O)) {
                System.out.println("Победил ИИ!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("Ничья!");
                break;
            }
        }

    }

}

