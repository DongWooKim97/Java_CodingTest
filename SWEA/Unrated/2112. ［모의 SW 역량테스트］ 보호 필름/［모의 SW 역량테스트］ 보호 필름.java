import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int[][] map;
    static int[] selected;
    static int D, W, K, MIN;

    static void dfs(int row, int injection) {
        if (injection >= MIN) {
            return;
        }
        if (row == D) {
            if (check()) {
                MIN = Math.min(injection, MIN);
            }
            return;
        }

        for (int i = -1; i < 2; i++) {
            selected[row] = i;
            if (i == -1) {
                dfs(row + 1, injection);
            } else {
                dfs(row + 1, injection + 1);
            }
        }
    }

    static boolean check() {
        int count = 0;
        int cur, next;

        for (int i = 0; i < W; i++) {
            count = 1;

            for (int j = 0; j < D - 1; j++) {
                cur = selected[j] == -1 ? map[j][i] : selected[j];
                next = selected[j + 1] == -1 ? map[j + 1][i] : selected[j + 1];

                if (cur == next) {
                    count++;
                    if (count >= K) {
                        break;
                    }
                } else {
                    count = 1;
                }
            }

            if (count < K) {
                return false;
            }

        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            selected = new int[D];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                selected[i] = -1;
            }

            MIN = Integer.MAX_VALUE;
            dfs(0, 0);

            System.out.printf("#%d %d\n", tc, MIN);
        }

        br.close();
    }
}
