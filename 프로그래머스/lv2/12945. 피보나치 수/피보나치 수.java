class Solution {
    public int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] arr = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) arr[i] = 0;
            else if (i == 1) arr[i] = 1;
            else {
                int aTmp = arr[i - 1] % 1234567;
                int bTmp = arr[i - 2] % 1234567;
                arr[i] = (aTmp + bTmp) % 1234567;
            }
        }


        return (arr[arr.length - 1] % 1234567);
    }
}