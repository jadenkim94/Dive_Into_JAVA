package algorithm.algo_study_2021.jun.forth_week;

public class Number_12939 {
    public static void main(String[] args) {

        System.out.println(solution("1 2 3 4"));
    }

    public static String solution(String s) {

        String[] str = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < str.length; i++){
            int now = Integer.valueOf(str[i]);
            if(min > now) {
                min = now;
            }
            if(max < now){
                max = now;
            }
        }

        String answer = "";
        answer = min + " " + max;

        return answer;
    }
}
