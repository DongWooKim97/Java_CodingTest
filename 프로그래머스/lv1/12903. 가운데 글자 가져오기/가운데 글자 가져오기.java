class Solution {
    public String solution(String s) {
        String[] result = s.split("");
        String tmp = "";
        if(s.length() % 2 == 0)  {
            tmp += result[result.length / 2 -1] + result[result.length / 2];
            return tmp;
        } else {
            return result[result.length / 2];
        }

    }
}