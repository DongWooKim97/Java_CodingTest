import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] winner = {"SK", "CY"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) System.out.println("CY");
        else {
            int cnt = 1;
            while (N % 2 != 0) {
                N--;
                cnt++;
            }
            System.out.println(winner[cnt % 2]);
        }
    }
}
