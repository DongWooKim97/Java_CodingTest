class Solution {
    public int solution(int n) {
        int basic = Integer.bitCount(n);
        int idx = n+1;
        while (true) {
            int tmp = Integer.bitCount(idx);
            if (tmp == basic) {
                break;
            }
            idx++;
        }
        return idx;
    }
}