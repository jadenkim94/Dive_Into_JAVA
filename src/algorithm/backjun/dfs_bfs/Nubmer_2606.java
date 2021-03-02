package algorithm.backjun.dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;

/*
입력
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
7
6
1 2
2 3
1 5
5 2
5 6
4 7

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력
4
 */
class Graph {

    Node[] nodes;
    int count;
    boolean[] visited;


    public Graph(int size) {
        nodes = new Node[size + 1];
        visited = new boolean[size + 1];
        count = 0;
    }

    public void addEdge(int c1, int c2) {
        if (!nodes[c1].adjacent.contains(nodes[c2])) {
            nodes[c1].adjacent.add(nodes[c2]);
        }
        if (!nodes[c2].adjacent.contains(nodes[c1])) {
            nodes[c2].adjacent.add(nodes[c1]);
        }
    }

    public void dfs(int c1) {
        if (nodes[c1] == null) {
            return;
        }
        visited[c1] = true;
        for (int i = 0; i < nodes[c1].adjacent.size(); i++) {
            if (!visited[nodes[c1].adjacent.get(i).data]) {
                dfs(nodes[c1].adjacent.get(i).data);
                count++;
            }
        }
    }
}
class Node {
    int data;
    ArrayList<Node> adjacent;

    public Node(int data) {
        this.data = data;
        adjacent = new ArrayList<>();
    }
}

public class Nubmer_2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Graph graph = new Graph(n);

        for (int i = 1; i <= n; i++) {
            graph.nodes[i] = new Node(i);
        }

        for (int i = 0; i < m; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }

        graph.dfs(1);

        System.out.println(graph.count);
    }
}
