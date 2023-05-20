import java.io.*;

public class Solution {
    static int result;

    static void dfs(int cnt, int start, char[] numbers) {
        if (cnt == 0) {
            int cur = charArrToInt(numbers);
            if (cur > result) {
                result = cur;
            }
            return;
        }

        for (int i = start; i < numbers.length - 1; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                int src = Integer.parseInt(String.valueOf(numbers[i]));
                int trg = Integer.parseInt(String.valueOf(numbers[j]));

                numbers[i] = (char) (trg + '0');
                numbers[j] = (char) (src + '0');
                dfs(cnt - 1, i, numbers);
                numbers[i] = (char) (src + '0');
                numbers[j] = (char) (trg + '0');
            }
        }
    }

    static int charArrToInt(char[] numbers) {
        return Integer.parseInt(new String(numbers));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] tmp = br.readLine().split(" ");
            int number = Integer.parseInt(tmp[0]);
            int cnt = Integer.parseInt(tmp[1]);

            char[] numbers = Integer.toString(number).toCharArray();
            result = 0;

            if (numbers.length < cnt) cnt = numbers.length;
            dfs(cnt, 0, numbers);

            bw.write("#" + tc + " " + result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
