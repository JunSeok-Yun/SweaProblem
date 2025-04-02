import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] parents;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void make(int num) {
        parents = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            parents[i] = i;
        }
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        if (rootX <= rootY) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            make(N);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int flag = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (flag == 0) {
                    union(x, y);
                } else {
                    if (find(x) == find(y)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}