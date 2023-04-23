import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int[][] graph;
    static int max;

    static int flapper(int x, int y, int M) {
        int sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sum += graph[x + i][y + j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 정사각형의 가로 세로
            int M = Integer.parseInt(st.nextToken()); // 파리채 크기 M x M

            graph = new int[N][N];
            max = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = flapper(i, j, M);
                    max = Math.max(sum, max);
                }
            }
            System.out.printf("#%d %d\n", tc, max);
        }
    }
}
