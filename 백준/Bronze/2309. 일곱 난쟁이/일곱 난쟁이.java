import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N = 9, T = 7;
    static int target = 100;
    static int[] height, pm, ch;
    static StringBuilder sb = new StringBuilder();
    static boolean check = false;

    static void dfs(int level) {
        if (level > T) return;
        if (check) return;

        if (level == T) {
            int sum = Arrays.stream(pm).sum();
            if (target == sum) {
                for (int i : pm) {
                    if (i != 0)
                        sb.append(i).append("\n");
                }
                check = true;
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[level] = height[i];
                    dfs(level + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[N];
        ch = new int[N];
        pm = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(height);

        dfs(0);
        System.out.println(sb);
    }
}
