import java.util.*;
import java.io.*;

public class Solution {
    static int[] parents;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void make() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            make();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }

            for (int i = 1; i <= N; i++) {
                if (parents[i] == i) {
                    cnt++;
                }
            }
            sb.append("#" + test_case + " " + cnt).append('\n');
        }
        System.out.println(sb.toString());
    }

}