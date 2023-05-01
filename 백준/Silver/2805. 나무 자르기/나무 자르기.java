import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // number of trees
        int M = Integer.parseInt(st.nextToken()); // required length

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long lt = 0, rt = trees[N - 1];
        long maxLen = 0;
        while (lt <= rt) {
            long tmp = 0;
            long mid = (lt + rt) / 2;

            for (int i = 0; i < trees.length; i++) {
                tmp += Math.max(0, trees[i] - mid);
            }

            if (tmp >= M) {
                maxLen = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }
        System.out.println(maxLen);
    }
}
