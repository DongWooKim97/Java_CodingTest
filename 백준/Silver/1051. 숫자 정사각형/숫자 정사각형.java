import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int minLen, N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minLen = Math.min(N, M);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        while (minLen > 1) {
            for (int i = 0; i <= N - minLen; i++) {
                for (int j = 0; j <= M - minLen; j++) {
                    int num = arr[i][j];

                    if (num == arr[i][j + minLen - 1] && num == arr[i + minLen - 1][j] && num == arr[i + minLen - 1][j + minLen - 1]) {
                        System.out.println(minLen * minLen);
                        return;
                    }
                }
            }
            minLen--;
        }
        System.out.println(minLen * minLen);
    }
}
