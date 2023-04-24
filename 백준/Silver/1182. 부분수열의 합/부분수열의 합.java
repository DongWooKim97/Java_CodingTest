import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] seq;
    static int N, M, answer;


    static void DFS(int level, int sum) {
        //공집합확인
        if (level == 0 && sum == M) {
            answer--;
        }
        if (level == N) {
            if (M == sum) {
                answer++;
            }
            return;
        }
        DFS(level + 1, sum + seq[level]);
        DFS(level + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        DFS(0, 0);
        System.out.println(answer);

    }
}