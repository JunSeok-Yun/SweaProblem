import java.util.*;
import java.io.*;

public class TwoNumArray {
	public static void	main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		int N, M;
		int[] A;
		int[] B;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max_val = Integer.MIN_VALUE;
			int sum;
			N = sc.nextInt();
			M = sc.nextInt();

			A = new int[N];
			B = new int[M];
			
			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			
			for (int i = 0; i < M; i++)
				B[i] = sc.nextInt();
			
			if (N <= M)
			{
				for (int i = 0; i <= M - N; i++)
				{
					sum = 0;
					for (int j = 0; j < N; j++)
						sum += A[j] * B[j + i];
					max_val = Math.max(max_val, sum); 
				}
			}
			else
			{
				for (int i = 0; i <= N - M; i++)
				{
					sum = 0;
					for (int j = 0; j < M; j++)
						sum += B[j] * A[j + i];
					max_val = Math.max(max_val, sum); 
				}
			}
			System.out.println("#" + test_case + " " + max_val);
		}
	}
}
