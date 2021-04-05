package algorithm.algo_study_2021.first_week.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://programmers.co.kr/learn/courses/30/lessons/42586
 */

public class FirstWeekThird {
    public static void main(String[] args) {
        int [] progress = {95, 90, 99, 99, 80, 99};
        int [] speeds = {1, 1, 1, 1, 1, 1};
        int [] answer = solution(progress, speeds);
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Integer> waitingDays = new Stack<>();
        List<Integer> releseSize = new ArrayList<>();

        for(int i = progresses.length-1 ; i >= 0; i--){
            int days = 0;
            while (progresses[i] < 100){
                progresses[i] += speeds[i];
                days++;
            }
            waitingDays.add(days);
        }


        // 7 3 9
        int basePoint = waitingDays.peek(); // 첫번째 기술이 개발되는데 필요한 날짜.
        int count = 0;
        while (!waitingDays.isEmpty()){
            if(basePoint >= waitingDays.peek()){ // 다음 기술이 개발되는데 필요한 날짜가 더 적다면
                waitingDays.pop();
                count++;                         // 같이 배포되겠지
                if(waitingDays.isEmpty()){
                    releseSize.add(count);
                }
            } else {                             // 다음 기술이 개발되는데 필요한 날짜가 더 크다면
                releseSize.add(count);           // 우선 앞에 배포될 것들부터 배포.
                basePoint = waitingDays.peek();
                count = 0;
            }
        }

        answer = new int[releseSize.size()];
        for(int i = 0 ; i < answer.length; i ++){
            answer[i] = releseSize.get(i);
        }

        return answer;
    }
}
