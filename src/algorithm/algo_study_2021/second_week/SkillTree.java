package algorithm.algo_study_2021.second_week;

import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {
    public static void main(String[] args) {
        String [] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution("CBD", skill_trees));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;


        for(int i = 0; i < skill_trees.length; i++){
            char[] skills = skill_trees[i].toCharArray();
            char[] chars = skill.toCharArray();
            Queue<Character> queue = new LinkedList<>();
            for(int j = 0; j < skills.length; j++){
                for(int k = 0; k < chars.length; k++){
                    if(skills[j] == chars[k]){
                        queue.add(skills[j]);
                    }
                }
            }
            boolean isOkay = true;
            int k = 0;
            while (!queue.isEmpty()){
                if(queue.poll() != chars[k]){
                    isOkay = false;
                    break;
                }
                k++;
            }

            if(isOkay){
                answer++;
            }
        }

        return answer;
    }
}
