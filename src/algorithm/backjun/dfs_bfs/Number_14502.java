package algorithm.backjun.dfs_bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number_14502 {

    static int [] dRow = {-1,1,0,0};
    static int [] dCol = {0,0,-1,1};
    static int max = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int [][] map = new int[row][col];

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(row,col,map,0);

        System.out.println(max);

    }

    public static void makeWall(int row, int col, int [][] map, int depth){
        if(depth == 3){
            // 벽 3개 세웠으면 바이러스 끝까지 돌리고 안전가옥 수 확인
            spreadVirus(row, col, map);
            return;
        }
        for(int i = 0; i < row; i++ ){
            for(int j = 0; j < col; j++){
                if(map[i][j] == 0 ){
                    map[i][j] = 1;
                    makeWall(row, col, map, depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus(int row, int col, int [][] map) {
        int count = 0;
        int [][] copyWall = new int[row][col];
        for(int i = 0; i < row; i++ ){
            for(int j = 0 ; j < col; j++){
                copyWall[i][j] = map[i][j];
            }
        }
        Queue<Point> infected = new LinkedList<>();

        for(int i = 0; i < row; i++){ // 감염집 표시
           for(int j = 0; j < col; j++){
                if(copyWall[i][j] == 2){
                    infected.add(new Point(i,j));
                }
            }
        }



        while (!infected.isEmpty()){
            int r = infected.peek().x;
            int c = infected.poll().y;

            for(int i = 0; i < 4; i++){
                int nextRow = r + dRow[i];
                int nextCol = c + dCol[i];
                if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && copyWall[nextRow][nextCol] == 0){
                    copyWall[nextRow][nextCol] = 2;
                    infected.add(new Point(nextRow, nextCol));
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(copyWall[i][j] == 0){
                    count++;
                }
            }
        }

        max = Math.max(count, max);
    }
}
