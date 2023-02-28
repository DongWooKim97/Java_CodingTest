import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }

        int subCount = sc.nextInt();
        int[] subArr = new int[subCount];

        for (int i = 0; i < subCount; i++) {
            subArr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < subArr.length; i++) {
            System.out.println(binarySearch(arr, subArr[i]));
        }


    }

    public static int binarySearch(int[] arr, int key) {

        int lt = 0, rt = arr.length - 1;

        while (lt <= rt) {
            int mid_idx = (lt + rt) / 2;

            if (key < arr[mid_idx]) {
                rt = mid_idx - 1;

            } else if (key > arr[mid_idx]) {
                lt = mid_idx + 1;
            } else {
                return 1;
            }
        }
// 찾고자하는 값이 없을 때
        return 0;

    }
}
