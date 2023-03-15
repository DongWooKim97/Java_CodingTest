import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String width_tmp = Integer.toString(arr1[i], 2);
            width_tmp = String.format("%" + n + "s", width_tmp).replaceAll(" ", "0");

            String height_tmp = Integer.toString(arr2[i], 2);
            height_tmp = String.format("%" + n + "s", height_tmp).replaceAll(" ", "0");

            System.out.println(width_tmp + " " + height_tmp);

            for (int j = 0; j < n; j++) {
                if (width_tmp.charAt(j) == '1' || height_tmp.charAt(j) == '1') {
                    arr[i][j] = "#";
                } else {
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