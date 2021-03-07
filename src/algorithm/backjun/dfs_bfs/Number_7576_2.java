package algorithm.backjun.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/7576
 */
public class Number_7576_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] input = br.readLine().split(" ");
        int col = Integer.parseInt(input[0]);
        int low = Integer.parseInt(input[1]);

        int [][] box = new int[low][col];

        for(int i = 0 ; i < low; i++){
            input = br.readLine().split(" ");
            for(int j = 0 ; j < col; j++){
                box[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(box, low, col);

    }

    static int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private static void bfs(int[][] box, int low, int col) {

        Queue<GoodTomato> queue = new LinkedList<>();

        for(int i = 0 ; i < low; i++){
            for(int j = 0 ; j < col; j++){
                if(box[i][j] == 1){
                    queue.add(new GoodTomato(i, j));
                }
            }
        }

        while (!queue.isEmpty()){
            GoodTomato tomato = queue.poll();
            for(int [] dir : dirs){
                int nx = tomato.x + dir[0];
                int ny = tomato.y + dir[1];
                if(nx < 0 || ny < 0 || nx >= low || ny >= col){
                    continue;
                }
                if(box[nx][ny] != 0){
                    continue;
                }

                box[nx][ny] = box[tomato.x][tomato.y] + 1;
                queue.add(new GoodTomato(nx, ny));
            }
        }

        int max = 0;

        for(int i = 0; i < low; i++){
            for(int j = 0; j < col; j ++){
                if(box[i][j] == 0 ){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        }

        System.out.println(max - 1);

    }


}

class GoodTomato {
    int x;
    int y;

    GoodTomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}
