import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int T = 1; T <= tc; T++) {
            int size = sc.nextInt();
            int[][] arr = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) {
                        arr[i][j] = 1;
                    } else if (j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    }
                }
            }
            System.out.println("#" + T);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } // end of for-loop
    }
}
