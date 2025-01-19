
import java.util.Scanner;

public class FlyKill3 {
    static int N,M;
    static int[][] arr;
    static int sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int max_val = Integer.MIN_VALUE;
            N = sc.nextInt();
            M = sc.nextInt();
            arr = new int[3 * N][3 * N];
            for (int i = N; i < 2 * N; i++)
            {
                for (int j = N; j < 2 * N; j++)
                    arr[i][j] = sc.nextInt();
            }

            for (int i = N; i < 2 * N; i++)
            {
                for (int j = N; j < 2 * N; j++)
                {
                    sum = 0;
                    for (int x = -M + 1; x <= M - 1; x++)
                    {
                        sum += arr[i][j + x];
                        sum += arr[i + x][j];
                    }
                    sum -= arr[i][j];
                    max_val = Math.max(max_val, sum);
                    sum = 0;
                    for (int x = -M + 1; x <= M - 1; x++)
                    {
                        sum += arr[i + x][j + x];
                        sum += arr[i - x][j + x];
                    }
                    sum -= arr[i][j];
                    max_val = Math.max(max_val, sum);
                }
                max_val = Math.max(max_val, sum);
            }
            System.out.println("#" + test_case + " " + max_val);
        }
    }
}