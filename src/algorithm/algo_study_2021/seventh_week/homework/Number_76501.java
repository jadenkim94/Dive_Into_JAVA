package algorithm.algo_study_2021.seventh_week.homework;

/*
https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class Number_76501 {

    public static void main(String[] args) {

        int [] abs = {4,7,12};
        boolean [] sign = {true,false,true};
        System.out.println(solution(abs, sign));


    }
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
