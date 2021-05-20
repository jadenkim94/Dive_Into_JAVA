package algorithm.algo_study_2021.eighth_week.eighth_homework;

public class Number_77484 {
    public static void main(String[] args) {
        int [] lottos = {44, 1, 0, 0, 31, 25};
        int [] win_nums = {31, 10, 45, 1, 6, 19};

        int[] answer = solution(lottos, win_nums);

        for (int i : answer) {
            System.out.println(i);
        }
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int right = 0;
        int posibble = 0;
        for (int i : lottos) {
            if(i == 0) {
                posibble++;
                continue;
            }
            for(int j : win_nums){
                if(i == j) right++;
            }
        }

        int [] answer = new int[2];
        int high = right + posibble;
        int low = right;

        switch (high){
            case 6 : answer[0] = 1; break;
            case 5 : answer[0] = 2; break;
            case 4 : answer[0] = 3; break;
            case 3 : answer[0] = 4; break;
            case 2 : answer[0] = 5; break;
            default: answer[0] = 6; break;
        }
        switch (low){
            case 6 : answer[1] = 1; break;
            case 5 : answer[1] = 2; break;
            case 4 : answer[1] = 3; break;
            case 3 : answer[1] = 4; break;
            case 2 : answer[1] = 5; break;
            default: answer[1] = 6; break;
        }

        return answer;
    }
}
