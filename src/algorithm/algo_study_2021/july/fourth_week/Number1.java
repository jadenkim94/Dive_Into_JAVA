package algorithm.algo_study_2021.july.fourth_week;

public class Number1 {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 1;
        int left = 0;
        int right = 0;

        if(a<b){
            left = a;
            right = b;
        } else {
            left = b;
            right = a;
        }

        while (true){
            if(left % 2 == 1 && Math.abs(left-right) == 1){
                break;
            }

            left = (left+1)/2;
            right = (right+1)/2;
            answer++;
        }

        return answer;

    }
}
