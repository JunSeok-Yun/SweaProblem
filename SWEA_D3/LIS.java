import java.util.Scanner;

public class LIS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int maxVal = Integer.MIN_VALUE;
			int[] arr = new int[N];
			int[] cntArr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			for (int i = 0; i < N; i++)
			{
				cntArr[i] = 1;
				for (int j = 0; j < i; j++)
				{
					if ((arr[j] < arr[i]) && (cntArr[i] <= cntArr[j]))
						cntArr[i] = cntArr[j] + 1;
				}
				maxVal = Math.max(maxVal, cntArr[i]);
			}
			System.out.println("#" + test_case + " " + maxVal);
		}
		sc.close();
	}
	
}
