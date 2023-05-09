import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cmd, dis, speed, T;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            cmd = Integer.parseInt(br.readLine());
            dis = 0;
            speed = 0;
            for (int i = 0; i < cmd; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (input.length == 2) {
                    if (input[0] == 1) {
                        speed += input[1];
                    } else {
                        if (speed - input[1] <= 0) {
                            speed = 0;
                        } else {
                            speed -= input[1];
                        }
                    }
                }
                dis += speed;
            }
            System.out.printf("#%d %d\n", tc, dis);
        }
    }
}
