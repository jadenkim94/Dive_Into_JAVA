package algorithm.algo_study_2021.jun.forth_week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Number_12978 {
    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int [] dis;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        int n = 5;
        int [][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int k = 3;
        System.out.println(solution(n, road, k)); // 4
    }

    public static int solution(int N, int[][] road, int K) {

        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < road.length; i++){
            int startNode = road[i][0];
            int endNode = road[i][1];
            int cost = road[i][2];

            graph.get(startNode).add(new Node(endNode, cost));
            graph.get(endNode).add(new Node(startNode, cost));
        }

        dijkstra();

        int count = 0;

        for(int i = 1; i <= N; i++){

            if(dis[i] <= K) count++;
        }

        return count;
    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()){
            Node node = pq.poll();
            int now = node.index;
            int nowCost = node.cost;

            if(dis[now] < nowCost) continue;
            for(Node n : graph.get(now)) {
                if(dis[n.index] > nowCost + n.cost){
                    dis[n.index] = nowCost + n.cost;
                    pq.offer(new Node(n.index, nowCost + n.cost));
                }
            }
        }
    }
}
