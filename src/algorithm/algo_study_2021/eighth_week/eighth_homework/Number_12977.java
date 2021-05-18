package algorithm.algo_study_2021.eighth_week.eighth_homework;

public class Number_12977 {
    public static void main(String[] args) {
        int [] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(isPrime(nums[i] + nums[j] + nums[k])) count++;
                }
            }
        }

        return count;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i * i<= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
