import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            String in = br.readLine();
            for (int j = 1; j <= in.length(); j++) {
                String b = in.substring(0, j);
                String c = in.substring(j, j + j);
                if (b.equals(c)) {
                    System.out.printf("#%d %d\n", i, b.length());
                    break;
                }
            }
        }
    }
}