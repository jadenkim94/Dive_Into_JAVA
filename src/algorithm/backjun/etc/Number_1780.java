package algorithm.backjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/1780

9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1

10
12
11
 */
public class Number_1780 {

    static int [][] arr;
    static int [] cnt = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);

        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
        System.out.println(cnt[2]);

    }

    private static void divide(int row, int col, int n) {
        if(isOnePiece(row, col, n)){
            cnt[arr[row][col] + 1]++; // cnt[-1] 불가능 .. + 1 씩 해서 cnt[0] cnt[1] cnt[2]
        } else {
            int newN = n / 3;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    divide(row + newN * i, col + newN * j, newN);
                }
            }
        }
    }

    private static boolean isOnePiece(int row, int col, int n) {
        int t = arr[row][col];
        for(int i = row; i < row + n; i++){
            for(int j = col; j < col + n; j++){
                if(t != arr[i][j])
                    return false;
            }
        }
        return true;
    }

}
