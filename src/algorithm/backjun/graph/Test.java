package algorithm.backjun.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private static void dfs(ArrayList<ArrayList<Integer>> nodes, boolean[] check, int startNode){
        if(check[startNode])
            return;

        check[startNode] = true;
        for(int i : nodes.get(startNode)){
            if(check[i] == false){
                System.out.println("i : " + i);
                dfs(nodes, check, i);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodesSize = sc.nextInt();
        int addEdgeTimes = sc.nextInt();

        // 정점에 0 은 없고 1부터 시작
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < nodesSize+1; i++){
            nodes.add(new ArrayList<>());
        }

        // edge 연결
        for(int i = 0 ; i < addEdgeTimes; i++){
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            nodes.get(startNode).add(endNode);
            nodes.get(endNode).add(startNode);
        }

        boolean[] check = new boolean[nodesSize+1];
        int count = 0;
        for(int i = 1 ; i <= nodesSize; i++){
            if(check[i] == false){
                dfs(nodes, check, i);
                count ++;
            }
        }

        System.out.println(count);
    }
}
