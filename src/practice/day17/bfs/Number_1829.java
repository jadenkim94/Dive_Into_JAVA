package practice.day17.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Number_1829 {

    static int M;
    static int N;
    static int [][] map;
    static boolean [][] checked;
    static int [] dRow = {0,-1,0,1};
    static int [] dCol = {-1,0,1,0};

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int [][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        solution(m, n, picture);

    }

    public static int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        map = picture;
        checked = new boolean[m][n];
        int region = 0;
        int maxCount = 0;

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(!checked[i][j] && map[i][j] != 0){
                    region++;
                    int count = bfs(i, j);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        System.out.println(region + " " + maxCount);
        return new int[]{region, maxCount};
    }

    private static int bfs(int i, int j) {

        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        checked[i][j] = true;
        int count = 1;

        while (!q.isEmpty()){
            int [] location = q.poll();

            for(int dir = 0; dir < 4; dir++){
                int r = location[0] + dRow[dir];
                int c = location[1] + dCol[dir];

                if( r >= 0 && c >= 0 && r < M && c < N){
                    if(map[r][c] == map[location[0]][location[1]] && !checked[r][c]){
                        q.add(new int[]{r, c});
                        checked[r][c] = true;
                        count++;
                    }
                }
            }

        }
        return count;
    }
}
