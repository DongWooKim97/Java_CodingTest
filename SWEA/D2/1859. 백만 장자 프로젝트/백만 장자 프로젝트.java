import java.util.Scanner;

class Solution {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long diff = 0;
            int maxV = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > maxV) maxV = arr[j];
                diff += maxV - arr[j];
            }
            System.out.printf("#%d %d\n", i + 1, diff);
        }
        sc.close();
    }
}
