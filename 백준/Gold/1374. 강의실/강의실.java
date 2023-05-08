import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int s = Integer.parseInt(tmp[1]);
            int e = Integer.parseInt(tmp[2]);
            list.add(new Lecture(n, s, e));
        }
        Collections.sort(list);

        int max = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            while (!pq.isEmpty() && pq.peek() <= list.get(i).start) {
                pq.poll();
            }
            pq.add(list.get(i).end);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
    }
}

class Lecture implements Comparable<Lecture> {
    int num, start, end;

    public Lecture(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture target) {
        if (this.start == target.start) return this.end - target.end;
        return this.start - target.start;
    }
}