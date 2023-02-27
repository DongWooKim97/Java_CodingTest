class Solution {
    public int[] solution(long n) {
        String tmp = String.valueOf(n);
        int[] answer = new int[tmp.length()];
        for(int i=0; i<tmp.length(); i++) {
            answer[i] = Integer.parseInt(String.valueOf(tmp.charAt(tmp.length()-i-1)));
        }
        return answer;
    }
}