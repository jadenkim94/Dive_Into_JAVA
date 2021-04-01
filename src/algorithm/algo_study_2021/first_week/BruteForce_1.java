package algorithm.algo_study_2021.first_week;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * url : https://programmers.co.kr/learn/courses/30/lessons/42840?language=javascript
 */
public class BruteForce_1 {

    public static void main(String[] args) {
        int [] answers = {1,2,3,4,5};
        int [] answers2 = {1,3,2,4,2};
        int [] answers3 = {3,3,1,1,2};

    }

    public static int[] solution(int[] answers) {
        ArrayList<Integer> arr = new ArrayList<>();

        int [] first = {1,2,3,4,5};
        int firstCount = 0;
        int [] second = {2,1,2,3,2,4,2,5};
        int secondCount = 0;
        int [] third = {3,3,1,1,2,2,4,4,5,5};
        int thirdCount = 0;

        for(int i = 0; i < answers.length; i ++){
            if(answers[i] == first[i%5])
                firstCount++;
            if(answers[i] == second[i%8])
                secondCount++;
            if(answers[i] == third[i%10])
                thirdCount++;
        }

        if(firstCount > secondCount){
            if(firstCount > thirdCount){
                arr.add(1);
            } else if(firstCount == thirdCount){
                arr.add(1);
                arr.add(3);
            } else {
                arr.add(3);
            }
        } else if ( secondCount > firstCount){
            if(secondCount > thirdCount){
                arr.add(2);
            } else if ( secondCount == thirdCount){
                arr.add(2);
                arr.add(3);
            } else{
                arr.add(3);
            }
        } else {
            if(firstCount > thirdCount){
                arr.add(1);
                arr.add(2);
            } else if ( firstCount == thirdCount){
                arr.add(1);
                arr.add(2);
                arr.add(3);
            }
        }

        int [] answer = new int[arr.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
