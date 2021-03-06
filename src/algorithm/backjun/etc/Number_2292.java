package algorithm.backjun.etc;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/2292
 */
public class Number_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int maxOfLevel = 1;
        int increasSize = 6;
        int level = 1;

        while (true){
            if( n <= maxOfLevel){
                break;
            }

            maxOfLevel += increasSize;
            increasSize += 6;
            level++;
        }

        System.out.println(level);
    }
}
