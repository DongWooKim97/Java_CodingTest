import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[T + 1];
        if (T == 1) {
            System.out.println(0);
        } else if (T <= 3) {
            System.out.println(1);
        } else {
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= T; i++) {
                dp[i] = dp[i - 1] + 1;
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                }
                if (i % 3 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                }
            }
            System.out.println(dp[T]);
        }
    }
}
