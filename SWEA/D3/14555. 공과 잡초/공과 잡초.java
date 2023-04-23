import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String tmp = br.readLine();

            int count = 0;
            boolean flag = false;
            
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == ')' && flag) {
                    flag = false;
                } else if (tmp.charAt(i) == ')' && !flag) {
                    count++;
                }
                if (tmp.charAt(i) == '(') {
                    count++;
                    flag = true;
                } else {
                    flag = false;
                }
            }

            System.out.printf("#%d %d\n", tc, count);
        }
    }
}