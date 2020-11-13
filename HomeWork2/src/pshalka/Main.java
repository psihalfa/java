package pshalka;

public class Main {
    public static void main(String[] args) {

        // Задание 1

        System.out.println("\n1 - Задание");
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int x = 0; x < arr1.length; x++) {
            arr1[x] = arr1[x] == 1 ? 0 : 1;
            System.out.print(arr1[x] + " ");
        }

        // Задание 2

        System.out.println("\n2 - задание");
        int[] arr2 = new int[8];
        for (int i = 1, j = 0; i < arr2.length; i++) arr2[i] = j += 3;
        for (int x : arr2)
            System.out.print(x + " ");

        // Задание 3

        System.out.println("\n3 - задание");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
            System.out.print(arr3[i] + " ");
        }

        // Задание 4

        System.out.println("\n4 - задание");
        int[][] arr4 = new int[7][7];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0, j2 = arr4[i].length; j < arr4[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1)) arr4[i][j] = 1;
                System.out.print(arr4[i][j] + " ");
            }
            System.out.print("\n");
        }

        // Задание 5

        System.out.println("\n5 - задание");
        int[] arr5 = {8, 7, 10, 3, 1, 4, 5, 11, 6, 5, 9, 2};
        int min = arr5[0], max = arr5[0], indMax = 0, indMin = 0;
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > max) {
                max = arr5[i];
                indMax = i;
            }
            if (arr5[i] < min) {
                min = arr5[i];
                indMin = i;
            }
        }
        System.out.println("Максимальный элемент находится в массиве под индексом " + indMax + " со значением  = " + max);
        System.out.println("Минимальный элемент находится в массиве под индексом " + indMin + " со значением  = " + min);
    }
}

