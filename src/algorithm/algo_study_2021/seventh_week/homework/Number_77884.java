package algorithm.algo_study_2021.seventh_week.homework;

import java.util.ArrayList;

public class Number_77884 {

    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;
        int start = left;
        while (start <= right){
            nums.add(start);
            start++;
        }

        for(int i = 0; i < nums.size(); i++){
            int number = nums.get(i);
            // number =  13
            int count = 0;
            for(int j = 1; j <= number; j++){
                if(number % j == 0){
                    count++;
                }
            }

            // count 가 짝수면 약수가 짝수
            if(count % 2 == 0){
                answer += number;
            } else {
                answer -= number;
            }

        }

        return answer;
    }
}
