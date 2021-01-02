package algorithm.programmers;

/*
https://programmers.co.kr/learn/courses/30/lessons/12937
짝수와 홀수
문제 설명
정수 num 이 짝수일 경우 Even 을 반환하고 홀수인 경우 Odd 를 반환하는 함수, solution 을 완성해주세요.

제한 조건
num 은 int 범위의 정수입니다.
0은 짝수입니다.
 */
public class Level1_12937 {

    public static void main(String[] args) {
        int num = 3;
        System.out.println(solution(num));
    }

    public static String solution(int num) {
        if(num % 2 == 0){
            return "Even";
        }
        return "Odd";
    }
}
