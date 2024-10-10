package pro.sky.HomeWork2_15;

import java.util.Random;

public class ComparisonOfSorts {
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] array1 = new int[100_000];
        int[] array2 = new int[100_000];
        int[] array3 = new int[100_000];
        Random random = new Random();

        for (int i = 0; i < 100_000; i++) {
            array1[i] = random.nextInt();
        }
        long start1 = System.currentTimeMillis();
        bubbleSort(array1);
        System.out.println(System.currentTimeMillis() - start1);

        for (int i = 0; i < 100_000; i++) {
            array2[i] = random.nextInt();
        }
        long start2 = System.currentTimeMillis();
        sortInsertion(array2);
        System.out.println(System.currentTimeMillis() - start2);

        for (int i = 0; i < 100_000; i++) {
            array3[i] = random.nextInt();
        }
        long start3 = System.currentTimeMillis();
        sortSelection(array3);
        System.out.println(System.currentTimeMillis() - start3);
    }
}
