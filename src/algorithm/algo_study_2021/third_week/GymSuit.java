package algorithm.algo_study_2021.third_week;

import java.util.ArrayList;
import java.util.Collections;

/*
https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class GymSuit {
    static ArrayList<Integer> lostList = new ArrayList<>();
    static ArrayList<Integer> reserveList = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println(solution(5, new int[]{2,4}, new int[]{1,3,5}));

    }

    /**
     *
     * @param n = 전체 학생 수
     * @param lost = 체육복 도난당한 학생들 번호
     * @param reserve = 여벌 체육복이 있는 학생들 번호
     * @return = 체육수업을 들을 수 있는 학생 수
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        for(int i : lost){
            lostList.add(i);
        }
        for(int i : reserve){
            reserveList.add(i);
        }
        for(int i = 0; i < lostList.size(); i++){
            for(int j = 0; j < reserveList.size(); j++){
                if(lostList.get(i) == reserveList.get(j)){
                    lostList.remove(i);
                    reserveList.remove(j);
                    i--;
                    break;
                }
            }
        }

        Collections.sort(lostList);
        Collections.sort(reserveList);

        for(int i = 0; i < lostList.size(); i++){
            for (int j = 0; j < reserveList.size(); j++){
                if(lostList.get(i) - reserveList.get(j) == 1) {
                    lostList.remove(i);
                    reserveList.remove(j);
                    i--;
                    break;
                } else if (lostList.get(i) - reserveList.get(j) == -1){
                    lostList.remove(i);
                    reserveList.remove(j);
                    i--;
                    break;
                }
            }
        }

        answer -= lostList.size();
        return answer;
    }

}
