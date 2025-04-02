
import java.io.*;
import java.util.*;

public class Solution {
    static class Edge implements Comparable<Edge> {

        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int[] parents;
    static int V, E;
    static Edge[] edgeList;

    public static void make() {
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
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
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            long sum = 0;
            int cnt = 0;
            make();

            edgeList = new Edge[E];
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(start, end, weight);
            }
            Arrays.sort(edgeList);

            for (Edge edge : edgeList) {
                if (union(edge.start, edge.end)) {
                    sum += edge.weight;
                    if (++cnt == V - 1) {
                        break;
                    }
                }
            }
            sb.append("#" + test_case + " " + sum).append('\n');
        }
        System.out.println(sb.toString());
    }
}