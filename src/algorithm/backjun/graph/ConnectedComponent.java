package algorithm.backjun.graph;

import java.util.ArrayList;
import java.util.Scanner;

/*
https://www.acmicpc.net/problem/11724
문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다.
(1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

 */
public class ConnectedComponent {

    private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] check, int startNode){
        if(check[startNode]){
            return;
        }
        check[startNode] = true;
        for(int i : graph.get(startNode)){
            if(check[i] == false){
                dfs(graph, check, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeSize = sc.nextInt();
        int addEdgeTimes = sc.nextInt();

        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < nodeSize+1; i++){
           nodes.add(new ArrayList<>());
        }

        for(int i = 0; i < addEdgeTimes; i++){
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            nodes.get(startNode).add(endNode);
            nodes.get(endNode).add(startNode);
        }

        boolean [] check = new boolean[nodeSize+1];

        int ans = 0;
        for(int i = 1; i <= nodeSize; i++){
            if(check[i] == false){
                dfs(nodes, check, i);
                ans ++;
            }
        }

        System.out.println(ans);

    }

}
