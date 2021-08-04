package algorithm.algo_study_2021.august.firstweek;

public class Number2 {

    static int count = 0;
    static int deleted = 0;
    public static void main(String[] args) {

        solution("110010101001");


    }

    public static int[] solution(String s) {

        while (!s.equals("1")){
            String deleteZeroStr = deleteZero(s);
            String bin = convertToBinary(deleteZeroStr);
            s = bin;
        }

        int [] answer = new int[]{count, deleted};


        return answer;
    }

    private static String convertToBinary(String deleteZeroStr) {
        String binary = Integer.toBinaryString(deleteZeroStr.length());

        count++;
        return binary;
    }

    private static String deleteZero(String s) {
        String result = s.replaceAll("0", "");
        deleted += s.length() - result.length();
        return result;
    }


}
