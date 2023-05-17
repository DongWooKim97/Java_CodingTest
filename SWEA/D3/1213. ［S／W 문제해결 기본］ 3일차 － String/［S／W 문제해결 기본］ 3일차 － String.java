import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int testCase = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= testCase; tc++) {
            int answer = 0;
            int num = Integer.parseInt(br.readLine());
            String split = br.readLine();
            String target = br.readLine();
            String[] arr = target.split(split);
            if (target.substring(target.length() - split.length()).equals(split)) {
                answer = arr.length;
            } else {
                answer = arr.length - 1;
            }
            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
