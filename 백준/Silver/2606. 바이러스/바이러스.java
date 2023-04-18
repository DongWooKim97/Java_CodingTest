import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int twin = sc.nextInt();

        int[][] graph = new int[size + 1][size + 1];
        int[] check = new int[size + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();

//        그래프 형성
        for (int i = 0; i < twin; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

//        map에다가 해당하는 노드 연결
        for (int i = 1; i <= size; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 1; j <= size; j++) {
                if (graph[i][j] == 1) {
                    tmp.add(j);
                }
            }
            map.put(i, tmp);
        }

        int count = dfs(map, check, 1, 0);
        System.out.println(count);
    }

    public static int dfs(Map<Integer, List<Integer>> map, int[] check, int node, int count) {
        check[node] = 1;
        for (int i : map.get(node)) {
            if (check[i] == 0) {
                count = dfs(map, check, i, count+1);
            }
        }
        return count;
    }
}