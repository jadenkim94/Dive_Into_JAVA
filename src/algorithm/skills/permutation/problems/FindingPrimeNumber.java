package algorithm.skills.permutation.problems;

import java.util.ArrayList;
import java.util.HashSet;

public class FindingPrimeNumber {
    /*
    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
    각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요
     */

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    public static int[] numberPieces;
    public static boolean[] isUsed;
    public static ArrayList<Integer> result = new ArrayList<>();
    public static HashSet<Integer> answer = new HashSet<>();

    public static int solution(String numbers) {
        int[] numberPieces = getNumberPieces(numbers);
        isUsed = new boolean[numberPieces.length];

        for(int i = 1; i <= numberPieces.length; i++){
            permutation(numberPieces, i);
        }
        return answer.size();
    }

    private static int[] getNumberPieces(String numbers){
        char[] chars = numbers.toCharArray();
        int[] numberPieces = new int[chars.length];
        for(int i = 0 ; i < numberPieces.length; i++){
            numberPieces[i] = chars[i] - '0';
        }
        return numberPieces;
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
