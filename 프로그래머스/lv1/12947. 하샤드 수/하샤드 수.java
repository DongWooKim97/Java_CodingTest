class Solution {
    public boolean solution(int x) {
        String[] val = String.valueOf(x).split("");

        int sum = 0;

        for (String str : val) {
            sum += Integer.parseInt(str);
        }

        if (x % sum == 0) {
            return true;
        }
        return false;
    }
}