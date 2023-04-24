class Solution {
    static boolean[] visited;

    static void DFS(int i, int[][] computers) {
        visited[i] = true;
        for (int x = 0; x < computers[i].length; x++) {
            if (computers[i][x] == 1 && i != x && !visited[x]) {
                DFS(x, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i, computers);
            }
        }
        
        return count;
    }
}