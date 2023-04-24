import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = line.charAt(j) - '0';
                }
            }

            int half = N / 2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = Math.abs(half - i); j < N - Math.abs(half - i); j++) {
                    sum += farm[i][j];
                }
            }

            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
