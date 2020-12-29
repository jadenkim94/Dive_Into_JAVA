package algorithm.programmers;

import java.time.LocalDateTime;

/*
https://programmers.co.kr/learn/courses/30/lessons/12921
소수 찾기
문제 설명
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.
입출력 예
n	result
10	4
5	3
입출력 예 설명
입출력 예 #1
1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

입출력 예 #2
1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
 */
public class FindingPrimeNumber {
    public static void main(String[] args) {
        int n =  1000000;
        long start = System.currentTimeMillis();
        System.out.println(solution(n));
        System.out.println("걸린 시간 : " + (System.currentTimeMillis() - start));
        long start2 = System.currentTimeMillis();
        System.out.println(solution2(n));
        System.out.println("걸린 시간 : " + (System.currentTimeMillis() - start2));
    }

    public static int solution(int n) {
        int answer = 0;
        //1 2중 포문?
        for(int i = 2; i <= n; i++){
            boolean flag = true;
            for(int j = 2; j*j <= i; j++){
                if(i%j==0){
                    flag =false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }

    // 에라토스테네스의 체
    public static int solution2(int n) {
        int answer = 0;
        boolean [] prime = new boolean[n+1];  // 체

        for(int i = 2; i <= n; i++){         // 체 초기화 0 과 1은 소수가 아님
            prime[i] = true;
        }

        int rootN  = (int)Math.sqrt(n);     // root N

        for(int i = 2; i <= rootN; i++){    // root N 까지 돌면서
            if (prime[i]){                  // 해당 수가 소수이면
                for(int j = i; i*j <= n; j++){ // 해당 수의 배수들은 소수가 아님
                    prime[i*j] = false;
                }
            }
        }

        for(int i = 2; i<= n; i++){         // 소수의 갯수 카운트
            if(prime[i])
                answer++;
        }
        return answer;
    }
}
