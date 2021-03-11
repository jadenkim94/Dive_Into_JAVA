package algorithm.backjun.brute_force;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2231
 */
public class Number_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for(int i = 1 ; i < n ; i++){
            int temp = i;
            int num = i;

            while (temp != 0){
                num += temp % 10;
                temp /= 10;
            }

            if(num == n){
                System.out.println(i);
                n = 0;
                break;
            }
        }

        if( n != 0 ){
            System.out.println(0);
        }
    }
}
