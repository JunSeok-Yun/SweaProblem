import java.util.*;
import java.io.*;

public class SpinNumArray 
{
	static String[][] str_arr;
    
	public static void	first_col(int[][] arr, int n)
	{
		String temp;

		for (int i = 0; i < n; i++)
		{
			temp = "";
			for (int j = n-1; j >= 0; j--)
				temp = temp + Integer.toString(arr[j][i]);
			str_arr[i][0] = temp;
		}
	}

	public static void	second_col(int[][] arr, int n)
	{
        int x = 0;
		String temp;

		for (int i = n-1; i >= 0; i--)
		{
			temp = "";
			for (int j = n-1; j >= 0; j--)
				temp = temp + Integer.toString(arr[i][j]);
			str_arr[x][1] = temp;
            x++;
		}
	}

	public static void	third_col(int[][] arr, int n)
	{
        int x = 0;
		String temp;

		for (int i = n - 1; i >= 0; i--)
		{
			temp = "";
			for (int j = 0; j < n; j++)
				temp = temp + Integer.toString(arr[j][i]);
			str_arr[x][2] = temp;
            x++;
		}
	}
    
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T, N;
		int[][] arr;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
			str_arr = new String[N][3];
			arr = new int[N][N];
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < N; j++)
					arr[i][j] = sc.nextInt();
			}
			first_col(arr, N);
			second_col(arr, N);
			third_col(arr, N);
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (j != 2)
						System.out.print(str_arr[i][j] + " ");
					else
						System.out.print(str_arr[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();
	}
	
}
