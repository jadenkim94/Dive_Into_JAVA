package algorithm.algo_study_2021.july.fourth_week;

import java.util.Collections;
import java.util.PriorityQueue;

public class Number3 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{1,1}));
    }

    public static long solution(int n, int[] works){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w : works){
            pq.add(w);
        }
        while (n != 0){
            if(pq.peek() == 0) break;
            pq.add(pq.poll()-1);
            n--;
        }
        System.out.println(pq);

        long answer = 0l;

        while (!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }


        return answer;
    }
}
