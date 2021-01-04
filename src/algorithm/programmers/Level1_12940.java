package algorithm.programmers;

import java.util.Arrays;

/*
https://programmers.co.kr/learn/courses/30/lessons/12940
최대공약수와 최소공배수
문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수,
solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.


제한 사항
두 수는 1이상 1000000이하의 자연수입니다.
입출력 예
n	m	return
3	12	[3, 12]
2	5	[1, 10]
입출력 예 설명
입출력 예 #1
위의 설명과 같습니다.

입출력 예 #2
자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
 */
public class Level1_12940 {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        Arrays.stream(solution(n, m)).forEach(System.out::println);
    }

    /*
         유클리드 호제법
            큰 수를 작은수로 나눈 나머지를 구한다.
            나눴던 수와 나머지로 나머지를 구한다.
            반복..
            나머지가 0 이 되었을 때 마지막에 나누는 수로 사용된 값이 최대공약수 이다.


            최소공배수
            두 수 A, B를 곱한뒤 최대 공약수로 나눈 값을 최소 공배수로 출력한다.

4)  만약 R이 0이 아니라면 A값은 B로, B 값은 R로 변경한뒤 3번 과정을 반복한다.
     */

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        // 같은 수 일경우 최대공약수와 최소공배수 모두 일치
        if (n == m){
            answer[0] = n;
            answer[1] = n;
            return answer;
        }
        int gcd = getGCD(Math.max(n, m), Math.min(n, m));
        answer[0] = gcd;
        answer[1] = (n * m) / gcd;

        return answer;
    }

    public static int getGCD(int big, int small){
        if(big % small == 0) // 큰 값을 작은 값으로 나눈 나머지가 0 이라면
            return small;    // 작은 값이 최대공약수 이다.
        return getGCD(small, big%small); // 0이 아니라면 나누는 값을 나머지로 나눈다.
    }
}
