import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tree = sc.nextInt();
        int need = sc.nextInt();

        int[] arr = new int[tree];

        int max = 0;
        int min = 0;

        for (int i = 0; i < tree; i++) {
            arr[i] = sc.nextInt();

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int mid = 0;
        while (min < max) {
            mid = (min + max) / 2;
            long take = 0;
            for (int x : arr) {
                if (x - mid > 0) {
                    take += (x - mid);
                }
            }

            if (take < need) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }
        System.out.println(min - 1);
    }
}
