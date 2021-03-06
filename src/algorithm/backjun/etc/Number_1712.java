package algorithm.backjun.etc;

/*
https://www.acmicpc.net/problem/1712
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.split(" ");
        int fixedCost = Integer.parseInt(inputs[0]);
        int productionCost = Integer.parseInt(inputs[1]);
        int profit = Integer.parseInt(inputs[2]);


        if(productionCost >= profit){
            System.out.println(-1);
        } else {
            System.out.println(fixedCost / (profit - productionCost) + 1);
        }

    }
}
