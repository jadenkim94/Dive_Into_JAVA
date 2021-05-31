package algorithm.algo_study_2021.ninth_week.ninth_homework;

import java.util.Scanner;

public class Number_1463 {
    static int [] memo;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n+1];

        memo[0] = 0;
        memo[1] = 0;

        for(int i = 2; i <= n; i++){
            memo[i] = memo[i-1]+1;
            if(i % 2 == 0){
                memo[i] = Math.min(memo[i/2]+1, memo[i]);
            }
            if(i % 3 == 0){
                memo[i] = Math.min(memo[i/3]+1, memo[i]);
            }
        }
        System.out.println(memo[n]);
    }


}
