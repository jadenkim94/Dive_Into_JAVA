package algorithm.backjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
https://www.acmicpc.net/problem/2798
 */
public class Number_2798 {

    static int [] cards;
    static boolean [] isUsed;
    static ArrayList<Integer> result = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine();
        String[] first = firstLine.split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        String secondLine = br.readLine();
        String[] second =  secondLine.split(" ");
        cards  = new int[second.length];

        for(int i = 0 ; i < second.length; i++){
            cards[i] = Integer.parseInt(second[i]);
        }

        isUsed = new boolean[cards.length];

        permutation(3, m);
        System.out.println(max);
    }


    public static void permutation(int depth, int maximum){
        if(result.size() == depth){
            int sum = 0;
            for(int i = 0 ; i < result.size(); i++){
                sum += result.get(i);
            }
            if( sum > max && sum <= maximum){
                max = sum;
            }
            return;
        }
        for(int i = 0; i < cards.length; i++){
            if(isUsed[i] == false){
                isUsed[i] = true;
                result.add(cards[i]);
                permutation(depth, maximum);
                isUsed[i] = false;
                result.remove(result.size()-1);
            }
        }
    }
}
