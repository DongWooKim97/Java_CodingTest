import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] arr;
    static int T;
    static StringBuilder sb = new StringBuilder();

    static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(arr[row][col]);
            return;
        } else {
            sb.append("(");
            int newSize = size / 2;

            partition(row, col, newSize);
            partition(row, col + newSize, newSize);
            partition(row + newSize, col, newSize);
            partition(row + newSize, col + newSize, newSize);
            sb.append(")");
        }


    }

    static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        arr = new int[T][T];

        for (int i = 0; i < T; i++) {
            int[] tmp = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < T; j++) {
                arr[i] = tmp;
            }
        }

        partition(0, 0, T);
        System.out.println(sb.toString());
    }
}
