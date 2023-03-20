class Solution {
    static boolean[] prime;

    public int solution(int[] nums) {
        int answer = 0;

        make_prime();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if (!prime[tmp]) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }


    public static void make_prime() {
        prime = new boolean[3001];

        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}