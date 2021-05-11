package algorithm.algo_study_2021.seventh_week.homework;

import java.util.ArrayList;

/*
https://programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Number_1845 {
    public static void main(String[] args) {
        int [] nums = {3,1,2,3};
        System.out.println(solution(nums)); // 3

    }
    public static int solution(int[] nums) {

        // 뽑아야 하는 폰켓몬 수
        int pickSize = nums.length/2;
        System.out.println(pickSize);

        ArrayList<Integer> picked = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(!picked.contains(nums[i]) && picked.size() < pickSize){
                picked.add(nums[i]);
            }
        }

        System.out.println(picked);

        return picked.size();

    }

}
