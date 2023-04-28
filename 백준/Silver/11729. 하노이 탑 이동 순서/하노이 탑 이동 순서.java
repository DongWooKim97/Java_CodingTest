import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int disk, int from, int goal) {
        boolean[] tower = new boolean[4];
        tower[from] = true;
        tower[goal] = true;

        int via = 0;
        for (int i = 1; i < 4; i++) {
            if (!tower[i]) {
                via = i;
                break;
            }
        }

        if (disk == 1) {
            sb.append(from).append(" ").append(goal).append("\n");
            count++;
            return;
        }

        hanoi(disk - 1, from, via);
        hanoi(1, from, goal);
        hanoi(disk - 1, via, goal);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = 0;
        int disk = Integer.parseInt(br.readLine());
        int from = 1;
        int goal = 3;
        hanoi(disk, from, goal);

        System.out.println(count);
        System.out.println(sb.toString());
    }
}
