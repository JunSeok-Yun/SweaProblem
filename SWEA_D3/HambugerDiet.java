import java.util.Scanner;

public class HambugerDiet {
	static int[][] arr;
	static int N, L;
	static int maxVal = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N  = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];
			for (int i = 0; i < N; i++)
			{
				arr[i][0] = sc.nextInt(); // 점수
				arr[i][1] = sc.nextInt(); // 칼로리
			}
			dfs(0, 0 , 0);
			System.out.println("#" + test_case + " " + maxVal);
		}
		sc.close();
	}

	public static void dfs(int depth, int calories, int score)
	{
		if (calories > L)
			return ;
		if (depth == N)
		{
			if (calories <= L)
				maxVal = Math.max(maxVal, score);
			return ;
		}
		dfs(depth + 1, calories + arr[depth][1], score + arr[depth][0]);
		dfs(depth + 1, calories, score);
	}
}
