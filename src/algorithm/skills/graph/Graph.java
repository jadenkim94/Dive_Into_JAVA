package algorithm.skills.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int nodes;
    ArrayList<ArrayList<Integer>> graph;
    boolean [] visitedArr;

    public Graph(int nodeSize){
        nodes = nodeSize;
        graph = new ArrayList<>();
        for(int i = 0; i < nodeSize; i++){
            graph.add(new ArrayList<>());
        }
        visitedArr = new boolean[nodeSize];
    }

    // 양방향 간선 추가
    public void addEdge(int startNodeIndex, int endNodeIndex){
        graph.get(startNodeIndex).add(endNodeIndex);
        graph.get(endNodeIndex).add(startNodeIndex);
    }

    // 단방향 간선 추가
    public void addSingleEdge(int startNodeIndex, int endNodeIndex){
        graph.get(startNodeIndex).add(endNodeIndex);
    }


    public void dfs(int nodeIndex){
        visitedArr[nodeIndex] = true;
        System.out.print(nodeIndex + " ");
        for(int i = 0; i < graph.get(nodeIndex).size(); i++){
                int adj = graph.get(nodeIndex).get(i);
                if(visitedArr[adj] == false){
                    dfs(adj);
            }
        }
    }
    // 인자가 없는경우 0번 노드부터 dfs
    public void dfs(){
        dfs(0);
    }

    public void bfs(int nodeIndex){
        Queue<Integer> queue = new LinkedList<>();
        visitedArr[nodeIndex] = true;
        queue.add(nodeIndex);
        while (!queue.isEmpty()){
            int next = queue.poll();
            System.out.print(next + " ");
            for(int i = 0 ; i < graph.get(next).size(); i++){
                int adj = graph.get(next).get(i);
                if(visitedArr[adj] == false){
                    visitedArr[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }
    // 인자가 없는 경우 0번 노드부터 bfs
    public void bfs(){
        bfs(0);
    }

    // 그래프 출력
    public void showGraph(){
        for(int i = 0 ; i < nodes; i++){
            System.out.print(i + " 노드에 연결된 노드 : ");
            for(int j = 0; j < graph.get(i).size(); j++){
                System.out.print(" " + graph.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }

}
