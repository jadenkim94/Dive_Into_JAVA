package algorithm.skills.dp;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibo(2 ));
        System.out.println(fibo_bottomUp(5));
    }

    private static int fibo(int n){
        int [] memo = new int[n+1];
        if( n <= 1){
            return n;
        } else {
            if(memo[n] == 0){
                memo[n] = fibo(n-1) +fibo(n-2);
            }
            return memo[n];
        }
    }

    private static int fibo_bottomUp(int n){
        int [] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n ; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}
