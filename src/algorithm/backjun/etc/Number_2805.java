package algorithm.backjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2805
 */
public class Number_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String[] fInputs = firstLine.split(" ");

        int n = Integer.parseInt(fInputs[0]);
        long m = Integer.parseInt(fInputs[1]);

        String secondLine = br.readLine();
        String[] sInputs = secondLine.split(" ");
        int [] trees = new int[sInputs.length];
        for(int i = 0; i < trees.length; i++){
            trees[i] = Integer.parseInt(sInputs[i]);
        }

        long max = 0;
        for(int i = 0 ; i < trees.length; i++){
            max = Math.max(trees[i], max);
        }

        // n = 나무 수, m = 필요한 나무길이, trees 나무배열

        long start = 0;
        long end = max;


        while (start<=end){
            long mid = (start + end)/2;
            long sum = 0;

            for(int tree : trees){
                if(tree > mid){
                    sum += tree - mid;
                }
            }


            if (sum >= m){
                start = mid + 1;
            } else  {
                end = mid - 1;
            }
        }

        System.out.println(end);


    }

}
