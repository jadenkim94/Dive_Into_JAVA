package algorithm.skills;
//조합 nCr
public class Combination {

    public static void main(String[] args) {
        System.out.println(combination(3,2));

    }

    public static int combination(int n, int r){
        int [][] memo = new int[n+1][r+1];
        if(n == r || r == 0){
            return 1;
        } else if(memo[n][r] > 0){
            return memo[n][r];
        } else{
            memo[n][r] = combination(n-1, r) + combination(n-1, r-1);
            return memo[n][r];
        }
    }
}
