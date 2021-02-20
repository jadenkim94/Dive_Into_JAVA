package algorithm.programmers.highscorekit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
https://programmers.co.kr/learn/courses/30/lessons/49189
가장 먼 노드
문제 설명
n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

 */
public class Level3_49189 {
    static int numberOfFarthest = 0;

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
    // 구해야하는 것! 1번 노드로부터 가장 멀리떨어진 노드의 갯수.
    public static int solution(int n, int[][] edge) {

        Graph graph = new Graph(n);
        graph.addEdge(edge);
        graph.bfs(1);
        graph.saveNumberOfFarthest();

        return numberOfFarthest;
    }

    static class Graph {
        int nodeSize;
        ArrayList<ArrayList<Integer>> graph;
        boolean[] visited;
        int[] count;

        public Graph(int nodeSize) {
            this.nodeSize = nodeSize;
            count = new int[nodeSize + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= nodeSize; i++) {
                graph.add(new ArrayList<>());
            }
            visited = new boolean[nodeSize + 1];
        }

        public void addEdge(int[][] edge) {
            for (int i = 0; i < edge.length; i++) {
                int startNodeIdx = 0;
                int endNodeIdx = 0;
                for (int j = 0; j < edge[i].length; j++) {
                    if (j == 0) {
                        startNodeIdx = edge[i][j];
                    } else {
                        endNodeIdx = edge[i][j];
                    }
                }
                graph.get(startNodeIdx).add(endNodeIdx);
                graph.get(endNodeIdx).add(startNodeIdx);
            }
        }

        public void saveNumberOfFarthest() {
            int max = 0;
            int[] count = this.count;
            for (int i : count) {
                if (i >= max) {
                    max = i;
                }
            }
            for (int i : count) {
                if (i == max) {
                    numberOfFarthest++;
                }
            }
        }
        
        public void bfs(int nodeIdx) {
            Queue<Integer> queue = new LinkedList<>();
            visited[nodeIdx] = true;
            queue.add(nodeIdx); // queue 에 1
            while (!queue.isEmpty()) {
                int currentNode = queue.poll(); // 1 을 뽑아서
                for (int i = 0; i < graph.get(currentNode).size(); i++) { // 1 이랑 연결된 애들을 돌껀데
                    int adj = graph.get(currentNode).get(i); // adj 연결된에 인거고
                    if (!visited[adj]) { // 연결된애를 아직 체크한게 아니면
                        visited[adj] = true; // 체크처리하면서,
                        count[adj] = count[currentNode] + 1;
                        queue.add(adj);
                    }
                }
            }
        }
    }
}
