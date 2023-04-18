class Solution {
    public int solution(int n) {

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) { // 2. i를 1부터 시작하도록 변경
            arr[i] = i;
        }

        int lt = 1; // 1. lt의 초기값을 1로 변경
        int rt = 1; // rt의 초기값을 1로 설정
        int count = 0;
        int sum = 0;

        while (lt <= rt && rt <= n) { // rt가 n보다 작거나 같은 경우에만 실행되도록 변경
            if (sum < n) {
                sum += arr[rt++];
            } else if (sum > n) {
                sum -= arr[lt++];
            } else {
                count++;
                sum -= arr[lt++];
            }
        }

        return ++count; // 마지막에 ++~ 을 하는 이유는 lt,rt로 구분할 수 없는 값이 있기 때문
    }
}
