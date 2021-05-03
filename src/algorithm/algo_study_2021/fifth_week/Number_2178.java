package algorithm.algo_study_2021.fifth_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Number_2178 {

    static int[][] map;
    static int N;
    static int M;
    static int[] dRow = {0,1,0,-1};
    static int[] dCol = {-1,0,1,0};
    static boolean[][] isVisited;

    static class Node{
        int row;
        int col;
        int level;

        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        int n = Integer.parseInt(firstLine.split(" ")[0]);
        N = n;
        int m = Integer.parseInt(firstLine.split(" ")[1]);
        M = m;

        map = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String lines = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(lines.split("")[j]);
                isVisited[i][j] = false;
            }
        }

        bfs(0,0);

    }

    private static void bfs(int n, int m) {
        Node start = new Node(n, m);
        start.level = 1;
        isVisited[n][m] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);


        while (!queue.isEmpty()){

            Node root = queue.poll();

            for(int i = 0; i < 4; i++){
                int newRow = root.row + dRow[i];
                int newCol = root.col + dCol[i];

                // 범위를 벗어난 곳이면 queue 에 넣지 않는다.
                if(newRow < 0 || newCol < 0 || newRow >= N || newCol >= M) continue;

                // 방문한 곳이면 queue 에 넣지 않는다.
                if(isVisited[newRow][newCol]) continue;

                // 0 이면 벽, queue 에 넣지 않는다.
                if(map[newRow][newCol] == 0) continue;

                Node adjacent = new Node(newRow, newCol);
                adjacent.level = root.level+1;
                if(adjacent.row == N-1 && adjacent.col == M-1){
                    System.out.println(adjacent.level);
                }

                queue.add(adjacent);
                isVisited[newRow][newCol] = true;
            }



        }

    }
}
