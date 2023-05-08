import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> maxPq, minPq;
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
        minPq = new PriorityQueue<>();

        boolean isOdd = true;
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if (isOdd) {
                maxPq.offer(num);
            } else {
                minPq.offer(num);
            }

            if (!minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
                maxPq.offer(minPq.poll());
                minPq.offer(maxPq.poll());
            }

            isOdd = !isOdd;
            sb.append(maxPq.peek()).append("\n");
        }
        System.out.print(sb.toString());
    }
}
