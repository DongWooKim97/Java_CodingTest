import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int vertex = sc.nextInt();
        int start = sc.nextInt();

        int[][] arr = new int[node + 1][node + 1];
        for (int i = 0; i < vertex; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= node; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 1; j <= node; j++) {
                if (arr[i][j] == 1) {
                    tmp.add(j);
                }
            }
            map.put(i, tmp);
        }

        int[] checked = new int[node + 1];
        List<Integer> dfsResult = dfs(map, start, checked, new ArrayList<>());
        for (int item : dfsResult) {
            System.out.print(item + " ");
        }
        System.out.println();

        checked = new int[node + 1];
        List<Integer> bfsResult = bfs(map, start, checked, new LinkedList<>());
        for (int item : bfsResult) {
            System.out.print(item + " ");
        }
    }

    public static List<Integer> dfs(Map<Integer, List<Integer>> map, int node, int[] checked, List<Integer> list) {
        checked[node] = 1;
        list.add(node);
        for (int i : map.get(node)) {
            if (checked[i] == 0) {
                dfs(map, i, checked, list);
            }
        }
        return list;
    }

    public static List<Integer> bfs(Map<Integer, List<Integer>> map, int node, int[] checked, Queue<Integer> queue) {
        List<Integer> list = new ArrayList<>();
        checked[node] = 1;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int g : map.get(x)) {
                    if (checked[g] == 0) {
                        checked[g] = 1;
                        queue.offer(g);
                    }
                }
                list.add(x);
            }
        }
        return list;
    }
}
