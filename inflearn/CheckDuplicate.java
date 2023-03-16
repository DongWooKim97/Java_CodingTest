package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class CheckDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        String result = "U";

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                result = "D";
                break;
            }
        }

        System.out.println(result);
    }
}

