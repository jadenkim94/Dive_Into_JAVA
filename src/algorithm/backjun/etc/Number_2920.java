package algorithm.backjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2920
 */
public class Number_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String replace = input.replace(" ", "");
        char[] chars = replace.toCharArray();

        boolean ascending = true;
        boolean desending = true;

        for(int i = 1 ; i < chars.length; i++){
            if(chars[i-1] < chars[i]){ // 뒤에있는 값이 크면 오름차순
                desending = false;
            } else if ( chars[i-1] > chars[i]){ // 뒤에있는 값이 작으면 내림차순
                ascending = false;
            }
        }

        if (!ascending && !desending){
            System.out.println("mixed");
        } else if (ascending){
            System.out.println("ascending");
        } else if (desending){
            System.out.println("descending");
        }



    }
}
