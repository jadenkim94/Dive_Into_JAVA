package algorithm.programmers.highscorekit;
/*
https://programmers.co.kr/learn/courses/30/lessons/42839
소수 찾기
문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Level2_42839 {

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    public static ArrayList<Integer> temp = new ArrayList<>();
    public static HashSet<Integer> result = new HashSet<>();
    public static boolean[] visited;

    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            permutation(numbers, i);
        }
        return result.size();
    }


    public static void permutation(String numbers, int m) {
        if (temp.size() == m) {
            StringBuilder stringBuilder = new StringBuilder();
            temp.forEach(i ->{
                stringBuilder.append(i);
            });
            int number = Integer.parseInt(stringBuilder.toString());
            if(isPrime(number)){
                result.add(number);
            }
            return;
        }

        for(int i = 0 ; i < numbers.length(); i++){
            if(visited[i] == false){
                visited[i] = true;
                temp.add(numbers.charAt(i) - '0');
                permutation(numbers, m);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static Boolean isPrime(int num) {
        if (num <= 1)
            return Boolean.FALSE;
        int max = (int) Math.sqrt(num);
        boolean isPrime = true;
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime ? Boolean.TRUE : Boolean.FALSE;
    }

}
