class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] p = new int[n];

        for (int l : lost) {
            p[l - 1]--;
        }
        for (int r : reserve) {
            p[r - 1]++;
        }

        for (int i = 0; i < p.length; i++) {
            if (p[i] == -1) {
                if (i - 1 >= 0 && p[i - 1] == 1) {
                    p[i]++;
                    p[i - 1]--;
                } else if (i + 1 < p.length && p[i + 1] == 1) {
                    p[i]++;
                    p[i + 1]--;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }
}