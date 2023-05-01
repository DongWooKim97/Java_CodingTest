import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan = new int[K];

        long rt = 0;

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            rt = Math.max(lan[i], rt);
        }

        rt++;
        long mid = 0;
        long lt = 0;

        while (lt < rt) {
            mid = (rt + lt) / 2;
            long take = 0;

            for (int x : lan) {
                take += (x / mid);
            }

            if (take < N) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(lt - 1);
    }
}
