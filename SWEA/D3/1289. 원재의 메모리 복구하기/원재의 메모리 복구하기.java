import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			char[] c = br.readLine().toCharArray();
			char tmp = '0';
			int count =0;
			for(int i=0; i<c.length;i++) {
				if(c[i] != tmp) {
					tmp = c[i];
					count++;
				}
			}
			System.out.printf("#%d %d\n", tc, count);
		}
		br.close();
	}
}