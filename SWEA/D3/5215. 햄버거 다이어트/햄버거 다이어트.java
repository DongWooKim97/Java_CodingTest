import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static int N, L, maxScore;
    static int[][] ingred;

    static void cook(int level, int score, int cal) {
        if (cal > L) return;
        if (cal <= L) maxScore = Math.max(maxScore, score);
        if (level == N) return;

        cook(level + 1, score + ingred[level][0], cal + ingred[level][1]);
        cook(level + 1, score, cal);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingred = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                ingred[i][0] = Integer.parseInt(st.nextToken()); // 점수
                ingred[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
            }

            maxScore = 0;
            cook(0, 0, 0);

            System.out.printf("#%d %d\n", tc, maxScore);
        }
    }
}