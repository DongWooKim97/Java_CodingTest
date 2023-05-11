import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Paint[] arr = new Paint[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Paint(r, g, b);
        }

        int[][] dp = new int[N][3];
        dp[0][0] = arr[0].red;
        dp[0][1] = arr[0].green;
        dp[0][2] = arr[0].blue;

        for (int i = 1; i < N; i++) {
            dp[i][0] = arr[i].red + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i].green + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i].blue + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int answer = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]);
        System.out.println(answer);
    }
}

class Paint {
    int red;
    int green;
    int blue;

    public Paint(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
