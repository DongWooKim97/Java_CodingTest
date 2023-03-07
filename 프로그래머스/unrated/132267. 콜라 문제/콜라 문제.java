class Solution {
    public int solution(int a, int b, int n) {
        int count = 0;

        while (n >= a) {
            count += (n / a) * b;
            n = (n / a) * b + (n % a);
        }

        return count;
    }
}