class Solution {
    static int size;

    static void dfs(int[][] dp, int[][] triangle, int level) {
        if (level == 0) return;

        for (int i = 0; i < level; i++) {
            dp[level - 1][i] = triangle[level - 1][i] + Math.max(dp[level][i], dp[level][i + 1]);
        }
        
        dfs(dp, triangle, level - 1);
    }

    public int solution(int[][] triangle) {
        size = triangle.length;
        int[][] dp = new int[size][size];

        dp[size - 1] = triangle[size - 1];

        int level = size - 1;
        dfs(dp, triangle, level);

        int answer = dp[0][0];
        return answer;
    }
}