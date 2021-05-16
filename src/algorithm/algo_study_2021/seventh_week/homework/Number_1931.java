package algorithm.algo_study_2021.seventh_week.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number_1931 {

    static int [][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        /*
        time[n][0] = n 번 회의의 시작 시간
        time[n][1] = n 번 회의의 종료 시간
         */

        time = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            time[i][0] = startTime;
            time[i][1] = endTime;
        }

        Arrays.sort(time, (o1, o2) -> {
            // 종료 시간이 같은 경우 시작 시간이 빠른 순으로 정렬
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int count = 0;
        int prev_end_time = 0;

        for(int i = 0; i<n; i++){
            if(prev_end_time <= time[i][0]){
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
