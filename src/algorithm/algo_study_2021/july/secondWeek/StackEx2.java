package algorithm.algo_study_2021.july.secondWeek;

import java.util.Scanner;
import java.util.Stack;

/*
2. 괄호문자제거
설명
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.

입력
첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

출력
남은 문자만 출력한다.
 */
public class StackEx2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();

        System.out.println(solution(source));

    }

    private static String solution(String source) {
        Stack<Character> stack = new Stack<>();
        for(char c : source.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else if ( c == ')'){
                while (stack.peek() != '('){
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        Stack<Character> reverse = new Stack<>();

        while (!stack.isEmpty()){
            reverse.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!reverse.isEmpty()){
            sb.append(reverse.pop());
        }

        return sb.toString();
    }
}
