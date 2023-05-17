import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int TEST_CASE = 10;
    static final int SIZE = 8;
    static String[][] arr;
    static int len;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= TEST_CASE; tc++) {
            len = Integer.parseInt(br.readLine());
            arr = new String[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                String[] tmp = br.readLine().split("");
                arr[i] = tmp;
            }

            int count = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE - len + 1; j++) {
                    flag = true;
                    for (int h = 0; h < len / 2; h++) {
                        if (!arr[i][j + h].equals(arr[i][j - h + len - 1])) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) count++;


                    flag = true;
                    for (int h = 0; h < len / 2; h++) {
                        if (!arr[j + h][i].equals(arr[j - h + len - 1][i])) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) count++;
                }
            }
            System.out.printf("#%d %d\n", tc, count);
        }
    }
}