import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static final int TEST_CASE = 10;

    static int recursive(int n, int m) {
        if (m == 0) return 1;
        if (m == 1) return n;
        return n * recursive(n, m - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= TEST_CASE; tc++) {
            int num = Integer.parseInt(br.readLine());
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = tmp[0];
            int m = tmp[1];
            System.out.printf("#%d %d\n", tc, recursive(n, m));
        }
    }
}