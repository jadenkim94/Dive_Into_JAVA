package algorithm.algo_study_2021.fifth_week;

import java.io.BufferedReader;
import java.util.Stack;

public class Number_42883 {

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4)); // 94
    }


    public static String solution(String number, int k) {
        int[] numbers = toNumbers(number);
        int cnt = number.length()-k;
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i < numbers.length; i++) {
            int num = numbers[i];
            while (!stack.isEmpty() && stack.peek() < num && k-- > 0) {
                stack.pop();
            }
            stack.push(num);
        }

        while (stack.size() != cnt) {
            stack.pop();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


    static int[] toNumbers(String number){
        char[] chars = number.toCharArray();
        int [] numbers = new int[chars.length];
        for(int i = 0; i < chars.length; i++){
            numbers[i] = chars[i]-'0';
        }
        return numbers;
    }
}
