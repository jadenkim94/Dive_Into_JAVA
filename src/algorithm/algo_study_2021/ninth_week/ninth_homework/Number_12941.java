package algorithm.algo_study_2021.ninth_week.ninth_homework;

import java.util.Arrays;

public class Number_12941 {
    public static void main(String[] args) {
        int [] A  = {1,4,2};
        int [] B = {5,4,4};

        System.out.println(solution(A, B));
    }


    public static int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        while (i < A.length){
            answer += A[i]*B[B.length-1-i];
            i ++;
        }

        return answer;
    }
}
