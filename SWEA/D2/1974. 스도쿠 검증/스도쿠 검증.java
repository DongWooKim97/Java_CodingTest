import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int N = 9, sum = 45;
    static int[][] arr;

    static int check() {
        int tmpSumE;
        for (int i = 0; i < 9; i++) {
            tmpSumE = 0;
            for (int j = 0; j < 9; j++) {
                tmpSumE += arr[j][i];
            }
            if (sum - tmpSumE != 0) return 0;
        }

        for (int i = 0; i < N; i += 3) {
            int tmpSumA = 0;
            int tmpSumB = 0;
            int tmpSumC = 0;
            int tmpSumD;
            for (int j = i; j < i + 3; j++) {
                tmpSumD = 0;
                for (int k = 0; k < 3; k++) { // 3등분의 첫덩어리
                    tmpSumA += arr[j][k];
                }
                for (int k = 3; k < 6; k++) { // 3등분의 두번째 덩어리
                    tmpSumB += arr[j][k];
                }
                for (int k = 6; k < 9; k++) { // 3등분의 세번째덩어리
                    tmpSumC += arr[j][k];
                }
                for (int k = 0; k < 9; k++) {
                    tmpSumD += arr[j][k];
                }
                if (sum - tmpSumD != 0) return 0;
            }
            if (sum - tmpSumA != 0) return 0;
            if (sum - tmpSumB != 0) return 0;
            if (sum - tmpSumC != 0) return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.printf("#%d %d\n", tc, check());
        }
    }
}
