package algorithm.algo_study_2021.first_week;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 소수찾기 lv2
 * url : https://programmers.co.kr/learn/courses/30/lessons/42839
 */

public class BruteForce_2 {
    public static int[] numberPieces;
    public static boolean[] isUsed;
    public static ArrayList<Integer> result = new ArrayList<>();
    public static HashSet<Integer> answer = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int[] numberPieces = getNumberPieces(numbers);
        isUsed = new boolean[numberPieces.length];

        for(int i = 1; i <= numberPieces.length; i++){
            permutation(numberPieces, i);
        }
        return answer.size();
    }

    public static void permutation(int[] pieces, int depth){
        numberPieces = pieces;
        if(result.size() == depth){
            int number = printResult();
            if(isPrime(number)){
                answer.add(number);
            }
            return;
        }
        for(int i = 0; i < pieces.length; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                result.add(numberPieces[i]);
                permutation(pieces, depth);
                isUsed[i] = false;
                result.remove(result.size()-1);
            }
        }
    }

    private static int printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        result.forEach(stringBuilder::append);
        return Integer.valueOf(stringBuilder.toString());
    }

    private static int[] getNumberPieces(String numbers){
        char[] chars = numbers.toCharArray();
        int[] numberPieces = new int[chars.length];
        for(int i = 0 ; i < numberPieces.length; i++){
            numberPieces[i] = chars[i] - '0';
        }
        return numberPieces;
    }

    private static Boolean isPrime(int num) {
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

