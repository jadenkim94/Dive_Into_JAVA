package algorithm.algo_study_2021.seventh_week.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Number_1916 {

    static class Node implements Comparable<Node>{
        int end, cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int [] costs;
    static boolean [] visitied;
    static List<Node> [] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수
        int n = Integer.parseInt(st.nextToken());

        costs = new int[n+1];
        visitied = new boolean[n+1];
        lists = new ArrayList[n+1];
        for(int i = 1; i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }

        Arrays.fill(costs, Integer.MAX_VALUE);
        Arrays.fill(visitied, false);

        st = new StringTokenizer(br.readLine());
        // 버스의 개수
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i <m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lists[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        dijkstra(startPoint);

        System.out.println(costs[endPoint]);

    }

    private static void dijkstra(int startPoint) {
        costs[startPoint] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startPoint, 0));

        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            if(visitied[curNode.end]) continue;
            visitied[curNode.end] = true;

            for(Node node : lists[curNode.end]){
                if(costs[node.end] > costs[curNode.end] + node.cost){
                    costs[node.end] = costs[curNode.end] + node.cost;
                    pq.add(new Node(node.end, costs[node.end]));
                }
            }
        }
    }
}
