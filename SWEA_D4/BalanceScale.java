import java.io.*;
import java.util.*;
public class BalanceScale {
	static int N, resCnt;
	static int[] num;
	static int[] resArr;
	static boolean[] visited;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++){
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			resArr = new int[N];
			visited = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++){
				num[i] = Integer.parseInt(st.nextToken());
			}
			resCnt = 0;
			dfs(0);
			System.out.println("#" + test_case + " " + resCnt);
		}
	}

	public static void dfs(int depth) {
		if (depth == N) {
			solve(0, 0, 0);
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				resArr[depth] = num[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

	public static void solve(int depth, int left, int right) {
		if (left < right)
			return ;
		if (depth == N){
			resCnt++;
			return ;
		}

		solve(depth + 1, left + resArr[depth], right);
		solve(depth + 1, left, right + resArr[depth]);
	}
}
