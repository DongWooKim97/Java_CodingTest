import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, d;
    static int[][] arr, clone;

    static void rotate() {
        for (int i = 0; i < n; i++) {
            clone[i][n / 2] = arr[i][i];
            clone[i][i] = arr[n / 2][i];
            clone[n / 2][i] = arr[n - i - 1][i];
            clone[n - i - 1][i] = arr[n - i - 1][n / 2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = clone[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            clone = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    clone[i][j] = arr[i][j];
                }
            }

            if (d < 0)
                d += 360;
            d /= 45;

            while (d-- > 0)
                rotate();

            for (int[] ints : arr) {
                for (int anInt : ints) {
                    sb.append(anInt + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
