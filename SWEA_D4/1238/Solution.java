import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;// 입력받는 데이터의 길이, 시작점
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            adjList = new ArrayList<>();
            visited = new boolean[101];

            for (int i = 0; i <= 100; i++) {
                adjList.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                adjList.get(start).add(end);
            }
            sb.append("#" + test_case + " " + bfs(M)).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static int bfs(int root) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(root);
        visited[root] = true;
        int last = 0;
        int size = 0;
        while (!q.isEmpty()) {
            last = 0;
            size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                last = Math.max(last, cur);
                for (int num : adjList.get(cur)) {
                    if (!visited[num]) {
                        visited[num] = true;
                        q.add(num);
                    }
                }
            }
        }
        return last;
    }
}