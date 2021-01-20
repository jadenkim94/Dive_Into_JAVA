package algorithm.backjun.dp;
/*
https://www.acmicpc.net/problem/1463
1로 만들기
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

구하려고 하는것은 : n 을 1로 만드는 연산횟수의 최솟값
dp[n] : n 을 1로 만드는 연산횟수의 쵯솟값
dp[n] 을 구할 수 있는 방법은 3가지다.
n % 3 == 0
dp[n] = dp[n/3] + 1
n % 2 == 0
dp[n] = dp[n/2] + 1
dp[n] = dp[n-1] + 1

dp[1] = 0;



입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
 */

public class Dp_1463 {
    public static void main(String[] args) {
        System.out.println(lowOp(10));
    }

    public static int lowOp(int x){
        int [] dp = new int[x+1];
        if( x == 1 ) {
            dp[1] = 0;
            return dp[1];
        }

        if( dp[x] > 0 )
            return dp[x];


        dp[x] = lowOp(x-1) + 1;
        if( x % 2 == 0){
            int temp = lowOp(x/2)+1;
            if(dp[x] > temp)
                dp[x] = temp;
        }
        if( x % 3 == 0){
            int temp = lowOp(x/3)+1;
            if(dp[x] > temp)
                dp[x] = temp;
        }
        return dp[x];
    }
}
