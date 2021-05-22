package algorithm.algo_study_2021.eighth_week.eighth_homework;

public class Number_68935 {
    public static void main(String[] args) {
        System.out.println(solution(125));
    }
    /*
    n 을 3으로 나누어 나머지가 3보다 크면
     */
    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int current = n;
        while (current > 0){
            if( current % 3 < 10){
                sb.append(current % 3);
            } else {
                sb.append((char)(current % 3 -10 + 'A') );
            }
            current /= 3;
        }


        int power = sb.toString().length()-1;

        for(int i = 0 ; i < sb.toString().length() ; ++i) {
            char num = sb.toString().charAt(i);
            if(num >= 'A' && num <= 'Z') {
                answer += (num - 55) * Math.pow(3, power--);
            } else {
                answer += (num - '0') * Math.pow(3, power--);
            }
        }
        return answer;
    }
}
