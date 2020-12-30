package algorithm.programmers;

import java.util.Arrays;

/*
https://programmers.co.kr/learn/courses/30/lessons/12933
정수 내림차순으로 배치하기
문제 설명
함수 solution 은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
 */
public class Level1_12933 {
    public static void main(String[] args) {
        long n = 118372;
        System.out.println(solution(n));

    }

    public static long solution(long n) {
        long answer = 0;
        String str = ""+n;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String answerStr = "";
        for(int i = chars.length-1; i>=0 ; i-- ){
            answerStr += chars[i];
        }
        answer = Long.valueOf(answerStr);
        return answer;
    }
}
