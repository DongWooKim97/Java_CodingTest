import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] arr = br.readLine().split("");
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i].charAt(0) == alphabet.charAt(i)) {
                    count++;
                } else break;
            }

            System.out.printf("#%d %d\n", tc, count);
        }
    }
}
