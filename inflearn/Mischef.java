package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mischef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int people = sc.nextInt();
        int[] arr = new int[people];
        int[] arr2 = new int[people];
        int l, r;

        for (int i = 0; i < people; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
            arr2[i] = tmp;
        }

        Arrays.sort(arr2);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            if (arr[i] != arr2[i]) {
                list.add(i + 1);
            }
        }

        System.out.println(list.get(0) +" "+list.get(1));
    }
}
