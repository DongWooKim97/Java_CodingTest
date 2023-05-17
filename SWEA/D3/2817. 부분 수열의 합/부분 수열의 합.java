import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int n, m, count = 0;
    static int[] pm, arr;
    static boolean[] visited;

    static void dfs(int level, int sum) {
        if (level >= n) {
            if (sum == m) count++;
            return;
        }
        dfs(level + 1, sum);
        dfs(level + 1, sum + arr[level]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] tmp = br.readLine().split(" ");
            n = Integer.parseInt(tmp[0]);
            m = Integer.parseInt(tmp[1]);
            count = 0;

            pm = new int[n];
            visited = new boolean[n];
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            dfs(0, 0);
            System.out.printf("#%d %d\n", tc, count);
        }
    }
}
