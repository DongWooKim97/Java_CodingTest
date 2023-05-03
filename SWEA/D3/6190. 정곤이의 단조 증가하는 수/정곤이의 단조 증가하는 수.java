import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int max = -1;
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					int val = a[i] * a[j];
					String s = String.valueOf(val);
					int flag = 0;
					for(int k = 1; k < s.length(); k++) {
						if(s.charAt(k-1) > s.charAt(k)) {
							flag = 1;
							break;
						}
					}
					if(flag == 0)
						max = Math.max(max, val);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
}