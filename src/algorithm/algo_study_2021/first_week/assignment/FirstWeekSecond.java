package algorithm.algo_study_2021.first_week.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
https://programmers.co.kr/learn/courses/30/lessons/68644
 */
public class FirstWeekSecond {

    static ArrayList<Integer> elements = new ArrayList<>();
    static HashSet<Integer> sums = new HashSet<>();
    static boolean isUsed[];

    public static void main(String[] args) {
        int [] numbers = {5,0,2,7};
        int[] results = solution(numbers);
        for (int result : results) {
            System.out.print(result+ " ");
        }
    }
    public static int[] solution(int[] numbers) {
        int [] answer = {};
        isUsed = new boolean[numbers.length];
        permutation(numbers);
        List<Integer> sumList = new ArrayList<>(sums);
        answer = new int[sumList.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = sumList.get(i);
        }
        Arrays.sort(answer);


        return answer;
    }

    private static void permutation(int[] numbers) {
        if(elements.size() == 2){           // 숫자 2개를 찾으면
            int sum = 0;
            for (int number : elements) {   // 더해준다.
                sum += number;
            }
            sums.add(sum);
            return;
        } else{
            for(int i = 0; i < numbers.length; i++){
                if(!isUsed[i]){             // 사용한 수인지 체크
                    isUsed[i] = true;
                    elements.add(numbers[i]);
                    permutation(numbers);
                    isUsed[i] = false;
                    elements.remove(elements.size()-1);
                }
            }
        }
    }

}
