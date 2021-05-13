package practice.day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Number_1753 {
    static class Node implements Comparable<Node>{
        int adjIndex, weight;

        public Node(int adjIndex, int weight){
            this.adjIndex = adjIndex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }



    static int V;
    static int E;
    static int startNode;
    static List<Node> [] list; // [i] 노드와 인접한 노드 list
    static int [] dist; // 특정 노드로 부터의 거리를 저장할 테이블
    static boolean [] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 갯수
        V = Integer.parseInt(st.nextToken());
        // 간선의 갯수
        E = Integer.parseInt(st.nextToken());
        // 시작점
        startNode = Integer.parseInt(br.readLine());


        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        check = new boolean[V+1];

        Arrays.fill(dist, Integer.MAX_VALUE); // 거리 테이블 초기화
        Arrays.fill(check, false);

        // 각 노드와 연결된 노드들을 저장할 배열을 초기화
        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int adjIndex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(adjIndex, weight));
        }

        dijkstra(startNode);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();

    }

    private static void dijkstra(int startNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));
        dist[startNode] = 0;

        while (!queue.isEmpty()){
            /*
            큐에서 최소 경로를 가진 노드를 뽑는데 PriorityQueue 임으로 최소 경로로 정렬 되어있다.
             */
            Node curNode = queue.poll();

            // 뽑은 노드에서 탐색하려는 노드를 방문했다면 재방문 x
            if(check[curNode.adjIndex])
                continue;

            // 탐색하려는 노드 방문처리
            check[curNode.adjIndex] = true;

            for(Node node : list[curNode.adjIndex]){
                if(dist[curNode.adjIndex] + node.weight < dist[node.adjIndex]){
                    dist[node.adjIndex] =  node.weight + dist[curNode.adjIndex] ;
                    queue.add(new Node(node.adjIndex, dist[node.adjIndex]));
                }
            }

        }
    }
}
