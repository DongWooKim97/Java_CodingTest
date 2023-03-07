import java.util.Scanner;

public class Main {

    public static boolean[][] arr;
    public static int min = 64;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();

        sc.nextLine();

        arr = new boolean[w][h];

        for (int i = 0; i < w; i++) {
            String tmp = sc.nextLine();
            for (int j = 0; j < h; j++) {

                if (tmp.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int n_row = w - 7;
        int m_col = h - 7;

        for (int i = 0; i < n_row; i++) {
            for (int j = 0; j < m_col; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != TF) {
                    count++;
                }

                TF = (!TF);
            }
            TF = !TF;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);

    }

}

