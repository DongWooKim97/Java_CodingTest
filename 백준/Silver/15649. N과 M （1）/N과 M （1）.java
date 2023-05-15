import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static int N, M;
	static int[] combi;
	static boolean[] visited;
	static void dfs(int level, int start) {
		if(level == M) {
			for(int x : combi) System.out.print(x+" ");
			System.out.println();
			return;
		} else {
			for(int i=0; i<N;i++) {
				if(!visited[i] ) {
					visited[i] = true;
					combi[level] = i+1;
					dfs(level+1, i+1);
					visited[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = tmp[0];
		M = tmp[1];
		combi = new int[M];	
		visited = new boolean[N];
		dfs(0, 1);
	}
}