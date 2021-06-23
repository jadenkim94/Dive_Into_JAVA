package algorithm.algo_study_2021.jun.third_week.inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // n = 4 m = 3 :::
        // n 은 학생 수
        // m 은 시험 수
        int [][] arr = new int [m][n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){    // 멘토 학생 i  1 ~ n
            for(int j = 1; j<= n; j++){ // 멘티 학생 j  1 ~ n
                int count = 0;
                for(int k = 0; k < m; k++){ // 시험 k
                    int pi = 0, pj = 0;
                    for(int s = 0; s < n; s++){ // 순위 s
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }
                    if(pi > pj) count++;
                }
                if(count == m) answer++;
            }
        }

        System.out.println(answer);





    }
}
