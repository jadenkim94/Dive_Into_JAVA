package algorithm.algo_study_2021.ninth_week.ninth_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number_18243 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int d [][] = new int[n+1][n+1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            d[p1][p2] = 1;
            d[p2][p1] = 1;
        }


        for(int x = 0; x < n+1; x++){
            for(int i = 0; i < n+1; i++){
                for(int j = 0; j < n+1; j++){
                    if(i==j) continue;
                    if(d[i][x] != 0 && d[x][j] != 0){
                        if (d[i][j] == 0 || d[i][j] > d[i][x] + d[x][j]){
                            d[i][j] = d[i][x] + d[x][j];
                        }
                    }
                }
            }
        }

        boolean isBig = false;

        for(int i = 0; i < n+1; i++){
            for(int j =0; j < n+1; j++){
                if (d[i][j] == 0 && i != j || d[i][j] > 6){
                    isBig = true;
                    break;
                }
            }
        }

        if(isBig) System.out.println("Big World!");
        else System.out.println();




    }
}
