package algorithm.algo_study_2021.jun.forth_week;

import java.util.Arrays;

public class Number_42885 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
    }
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int max = people.length-1;
        int count = 0;

        for(int i = 0; i <= max; i++, count++){
            while (max > i && people[i] + people[max--] > limit) count++;
        }

        return count;
    }
}
