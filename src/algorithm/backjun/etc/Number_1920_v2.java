package algorithm.backjun.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Number_1920_v2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String numbers = br.readLine();
        String[] numStr = numbers.split(" ");
        HashSet<String> nums = new HashSet<>(Arrays.asList(numStr));

        int m = Integer.parseInt(br.readLine());

        String checks = br.readLine();
        String [] inputs = checks.split(" ");

        for(int i = 0 ; i < inputs.length; i++){
            if(nums.contains(inputs[i])){
                inputs[i] = "1";
            } else {
                inputs[i] = "0";
            }
        }

        for (String input : inputs) {
            System.out.println(input);
        }








    }
}
