package algorithm.algo_study_2021.august.firstweek;

public class Number1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14,6,8,2}));
    }

    public static int solution(int [] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }

    private static int lcm(int lt, int rt) {
        return lt*rt/gcb(lt, rt);
    }

    private static int gcb(int lt, int rt) {
        while (rt != 0){
            int r = lt % rt;
            lt = rt;
            rt = r;
        }
        return lt;
    }


}
