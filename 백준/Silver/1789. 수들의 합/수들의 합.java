import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        System.out.println(search(S));
        br.close();
    }

    public static int search(long S) {
        int N = 0;
        long sum = 0L;
        int idx = 0;
        while (true) {
            sum += ++idx;
            if (sum > S) return N;
            else N++;
        }
    }
}
