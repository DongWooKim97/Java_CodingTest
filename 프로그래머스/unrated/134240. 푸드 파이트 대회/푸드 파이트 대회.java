class Solution {
    public String solution(int[] arr) {
        String water = "0";

        String tmp = "";
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] >= 2) {
                    tmp += String.valueOf(i).repeat(arr[i] / 2);
                }
            } else {
                tmp += String.valueOf(i).repeat(arr[i] / 2);
            }
        }

        StringBuilder sb = new StringBuilder(tmp);

        String rev = sb.reverse().toString();


        return tmp + water + rev;
    }
}