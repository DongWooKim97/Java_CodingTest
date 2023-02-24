import java.util.*;

class Solution {
    public long solution(long n) {

        String val = String.valueOf(n);
        int[] arr = new int[val.length()];

        for (int i = 0; i < val.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(val.charAt(i)));
        }
        int[] answer = new int[val.length()];

        Arrays.sort(arr);
        for (int i = 0; i< answer.length; i++) {
            answer[i] = arr[arr.length-i-1];
        }

        String result = "";
        for (int x : answer) {
            result += (x+"");
        }


        long a = Long.valueOf(result);
        System.out.println(a);
        return a;
    }
}