import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = tmp[0];
            int M = tmp[1];
            System.out.println(combi(M, N));
        }
    }

    private static int combi(int N, int M) {
        if (dp[N][M] > 0) return dp[N][M];
        if (N == M || M == 0) return dp[N][M] = 1;
        return dp[N][M] = combi(N - 1, M - 1) + combi(N - 1, M);
    }
}
