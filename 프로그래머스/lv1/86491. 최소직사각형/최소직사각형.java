import java.util.Arrays;

public class Main {
		public static void main(String[] args) {
				int[][] arr = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
				System.out.println(new Solution().solution(arr));
		}
}


class Solution {
		public int solution(int[][] sizes) {
				int[] h = new int[sizes.length];
				int[] l = new int[sizes.length];

				for (int i = 0; i < sizes.length; i++) {
						for (int j = 0; j < sizes[i].length - 1; j++) {
								if (sizes[i][j] > sizes[i][j + 1]) {
										h[i] = sizes[i][j];
										l[i] = sizes[i][j + 1];
								} else {
										h[i] = sizes[i][j + 1];
										l[i] = sizes[i][j];
								}
						}
				}

				Arrays.sort(h);
				Arrays.sort(l);
				return h[h.length - 1] * l[l.length - 1];
		}
}



