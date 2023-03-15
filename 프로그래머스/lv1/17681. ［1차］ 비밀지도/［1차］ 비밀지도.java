import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String tmp1 = Integer.toString(arr1[i], 2);
            String tmp2 = Integer.toString(arr2[i], 2);

            if (tmp1.length() < n) {
                tmp1 = "0".repeat(n - tmp1.length()) + tmp1;
            }
            if (tmp2.length() < n) {
                tmp2 = "0".repeat(n - tmp2.length()) + tmp2;
            }

            String[] wTmp = tmp1.split("");
            String[] hTmp = tmp2.split("");

            for (int j = 0; j < n; j++) {
                if (hTmp[j].equals("1") || wTmp[j].equals("1")) {
                    arr[i][j] = "#";
                } else if (hTmp[j].equals("0") && wTmp[j].equals("0")) {
                    arr[i][j] = " ";
                }
            }
        }

        int count = 0;
        for (String[] outerArray : arr) {
            answer[count++] = Arrays.stream(outerArray).collect(Collectors.joining());
        }

        return answer;
    }
}