package algorithm.programmers;

import java.util.ArrayList;

/*
https://programmers.co.kr/learn/courses/30/lessons/12954
문제 설명
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
제한 조건
x는 -10000000 이상, 10000000 이하인 정수입니다.
n은 1000 이하인 자연수입니다.
 */
public class Level1_12954 {
    public static void main(String[] args) {
        long[] solution = solution(-4, 2);
        for(int i = 0; i < solution.length; i++){
            System.out.println(solution[i]);
        }

    }

    public static long[] solution(int x, int n) {
        long[] answer = {};

        ArrayList<Long> arrayList = new ArrayList<>();

        int cnt = 1;
        while (cnt != (n+1)){
            arrayList.add((long) (x*cnt));
            cnt++;
        }

        answer = arrayList.stream().mapToLong(Long::longValue).toArray();

        return answer;
    }
}
