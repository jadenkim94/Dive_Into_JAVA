package algorithm.backjun.etc;

import java.util.Scanner;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/5397
1
a><><b
 */
public class Number_5397 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        for(int i = 0 ; i < testCase; i++){
            char[] input = sc.nextLine().toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            Stack<Character> result = new Stack<>();
            for(int j = 0; j < input.length; j++){
                switch (input[j]) {
                    case '<' :
                        if(!left.isEmpty()){
                            right.push(left.pop());
                        }
                        break;
                    case '>' :
                        if(!right.isEmpty()){
                            left.push(right.pop());
                        }
                        break;
                    case '-' :
                        if(!left.isEmpty()){
                            left.pop();
                        }
                        break;
                    default:
                        if(input[j]!='<'&&input[j]!='>'&&input[j]!='-'){
                            left.push(input[j]);
                        }
                        break;
                }
            }
            while (!left.isEmpty()){
                result.add(left.pop());
            }
            while (!result.isEmpty()){
                stringBuilder.append(result.pop());

            }
            while (!right.isEmpty()){
                stringBuilder.append(right.pop());
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
