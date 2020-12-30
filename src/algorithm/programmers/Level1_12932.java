package algorithm.programmers;

import java.util.Arrays;
import java.util.List;

/*
https://programmers.co.kr/learn/courses/30/lessons/12932

자연수 뒤집어 배열로 만들기
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.

 */
public class Level1_12932 {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(long n) {
        int[] answer = {};
        String s = String.valueOf(n);
        answer = new int[s.length()];
        int cnt = 0;
        for(int i = s.length()-1; i >=0 ; i--){
            answer[cnt] = Integer.parseInt(String.valueOf(s.charAt(i)));
            cnt++;
        }
        return answer;
    }
}
