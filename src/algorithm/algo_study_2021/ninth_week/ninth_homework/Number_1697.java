package algorithm.algo_study_2021.ninth_week.ninth_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number_1697 {

    static int [] visited;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new int[100_001];
        Arrays.fill(visited, 0);
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(visited[K]-1);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()){
            N = q.poll();

            if(N == K)
                break;

            if(N + 1 <= 100_000 && visited[N+1] == 0){
                q.add(N+1);
                visited[N+1] = visited[N]+1;
            }
            if(N - 1 >= 0 && visited[N-1] == 0){
                q.add(N-1);
                visited[N-1] = visited[N]+1;
            }
            if(N * 2 <= 100_000 && visited[N * 2] == 0){
                q.add(N*2);
                visited[N*2] = visited[N]+1;
            }
        }
    }
}
