import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            List<Integer> list = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(toList());
            int res = 0;
            for (int i = 0; i < dump; i++) {
                int max = Collections.max(list);
                int min = Collections.min(list);
                int maxIdx = list.indexOf(max);
                int minIdx = list.indexOf(min);

                list.set(maxIdx, max - 1);
                list.set(minIdx, min + 1);
                res = Collections.max(list) - Collections.min(list);
            }
            System.out.printf("#%d %d\n", tc, res);
        }
    }
}
