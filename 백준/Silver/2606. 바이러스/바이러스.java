import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] checked;
    static int pc, line;

    static int DFS(int node, int count) {
        checked[node] = true;
        for (int i : list[node]) {
            if(!checked[i]){
                count = DFS(i, count + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pc = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[pc + 1];
        checked = new boolean[pc + 1];

        for (int i = 1; i <= pc; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            list[to].add(from);
            list[from].add(to);
        }

        int start = 1;
        int result = DFS(start, 0);
        System.out.println(result);
    }
}
