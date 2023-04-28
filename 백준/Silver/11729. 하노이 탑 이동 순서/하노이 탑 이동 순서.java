import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count;
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int disk, int start, int via, int end) {
        if (disk == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            count++;
            return;
        }

        hanoi(disk - 1, start, end, via);
        hanoi(1, start, via, end);
        hanoi(disk - 1, via, start, end);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        count = 0;
        int disk = Integer.parseInt(br.readLine());
        hanoi(disk, 1, 2, 3);

        System.out.println(count);
        System.out.println(sb.toString());
    }
}
