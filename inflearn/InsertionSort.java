package inflearn;

import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i < size; i++) {
            int tmp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else break;

                arr[j] = tmp;
            }
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }


    }
}