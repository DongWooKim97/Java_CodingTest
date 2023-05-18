import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String input = br.readLine();
            double res = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(num -> num != Arrays.stream(input.split(" "))
                            .mapToInt(Integer::parseInt)
                            .max()
                            .orElse(0))
                    .filter(num -> num != Arrays.stream(input.split(" "))
                            .mapToInt(Integer::parseInt)
                            .min()
                            .orElse(0))
                    .average()
                    .orElse(0);

            System.out.printf("#%d %d\n", tc, Math.round(res));
        }
    }
}
