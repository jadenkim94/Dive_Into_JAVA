package algorithm.backjun.etc;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/1874
 */
public class Number_1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder stringBuilder = new StringBuilder();


        Stack<Integer> stack = new Stack<>();
        int count = 1;
        boolean isPossible = true;

        for(int i = 0; i < n; i++){
            int data = sc.nextInt();
            while (count <= data){
                stack.push(count);
                count++;
                stringBuilder.append("+\n");
            }
            if(stack.peek() == data){
                stack.pop();
                stringBuilder.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if(isPossible){
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println("NO");
        }

    }
}
