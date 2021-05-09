package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 */

public class Level2_42624_priorityQueue {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {

        int [] scoville = {1, 2, 3, 9, 12, 10};
        int k = 7;

        System.out.println(solution(scoville, k)); // 2
    }

    public static int solution(int[] scoville, int k) {
        int answer = 0;

        for (int i : scoville) {
            pq.add(i);
        }

        if (pq.size() <= 0)
            return -1;

        int count = 0;
        while (pq.peek() < k){
            int first = pq.poll();

            if(pq.size() == 0)
                return -1;

            int second = pq.poll();

            pq.add(first + second*2);
            count++;
        }


        return count;
    }
}
