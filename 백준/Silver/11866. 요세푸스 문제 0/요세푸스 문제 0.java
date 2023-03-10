import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int people = sc.nextInt();
        int target = sc.nextInt();

        for (int i = 1; i <= people; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            for (int i = 0; i < target - 1; i++) {
                q.offer(q.poll());
            }
            answer.add(q.poll());
        }

        String str = answer.toString().replace("[", "<").replace("]", ">");
        System.out.println(str);
    }
}