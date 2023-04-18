import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        String min = String.valueOf(arr[0]);
        String max = String.valueOf(arr[arr.length - 1]);

        return  min + " " + max;
    }
}