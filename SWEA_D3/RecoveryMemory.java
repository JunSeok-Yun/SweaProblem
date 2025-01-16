import java.util.Scanner;

public class RecoveryMemory {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str = sc.next();
			int n = 0, cnt = 0;
			int[] arr = new int [str.length()];
			int[] check = new int[str.length()];
			for (int i = 0; i < str.length(); i++)
			{
				arr[i] = str.charAt(i) - '0';
				check[i] = 0;
			}

			while (n < str.length())
			{
				if (arr[n] != check[n])
				{
					for (int j = n; j < str.length(); j++)
						check[j] = arr[n];
					n++;
					cnt++;
				}
				else
					n++;
			}
			System.out.println("#" + test_case + " " + cnt);
		}
		sc.close();
	}
}
