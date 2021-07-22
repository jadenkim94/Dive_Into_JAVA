package algorithm.algo_study_2021.july.fourth_week;

import java.util.Arrays;

public class Number6 {
    public static void main(String[] args) {

        System.out.println(solution(new int [] {7, 0, 6, 1, 8}));

    }
    public static int solution(int[] citations) {
        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++){
            int h = citations.length-i;

            if(citations[i] >= h){
                return h;
            }
        }

        return 0;
    }
}
