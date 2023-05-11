import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] building = new int[15][15];
        for (int i = 0; i < 15; i++) { // 0층만들기
            building[0][i] = i + 1;
            building[i][0] = 1;
        }

        for (int i = 1; i < 15; i++) { // 그 뒤로 dp배열만들기
            for (int j = 1; j < 15; j++) {
                building[i][j] = building[i][j - 1] + building[i - 1][j];
            }
        }

        for (int tc = 1; tc <= T; tc++) {
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());
            System.out.println(building[floor][room - 1]);
        }
    }
}