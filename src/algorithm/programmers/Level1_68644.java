package algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
https://programmers.co.kr/learn/courses/30/lessons/68644

두 개 뽑아서 더하기
문제 설명
정수 배열 numbers가 주어집니다.
numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.
 */
public class Level1_68644 {
    public static void main(String[] args) {
        int [] numbers = {2,1,3,4,1};
        Arrays.stream(solution(numbers)).forEach(System.out::println);
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i != j){
                    int sum = numbers[i] + numbers[j];
                    set.add(sum);
                }
            }
        }
        ArrayList<Integer> sortingList = new ArrayList<>(set);

        Collections.sort(sortingList);

        answer = sortingList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

}
