import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    static int N, M, K;
    static int[] guest;

    static String isPossible() {
        int count = 0;
        int idx = 0;
        int time = 0;
        while (true) {
            while (time + M > guest[idx]) {
                if (count-- == 0) {
                    return "Impossible";
                }
                if (idx++ >= N - 1) {
                    return "Possible";
                }
            }
            time += M;
            count += K;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            guest = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                guest[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(guest);


            System.out.printf("#%d %s\n", tc, isPossible());
        }
    }
}
