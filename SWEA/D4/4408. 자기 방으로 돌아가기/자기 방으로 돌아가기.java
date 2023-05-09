import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            visited = new int[201];

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int from = (Integer.parseInt(input[0]) + 1) / 2;
                int to = (Integer.parseInt(input[1]) + 1) / 2;

                // from이 to보다 큰 경우 swap
                if (from > to) {
                    int tmp = from;
                    from = to;
                    to = tmp;
                }

                // 각 구간에 방문하는 사람 수를 더해줌
                for (int j = from; j <= to; j++) {
                    visited[j]++;
                }
            }

            // 가장 많은 사람이 방문한 구간을 구함
            int max = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] > max) {
                    max = visited[i];
                }
            }

            System.out.printf("#%d %d\n", tc, max);
        }
    }
}
