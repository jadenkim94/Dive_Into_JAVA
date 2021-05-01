package algorithm.algo_study_2021.fifth_week;

import java.util.ArrayList;

/*
https://programmers.co.kr/learn/courses/30/lessons/12973
*/
public class Number_12973 {
    public static void main(String[] args) {
        // 모두제거 가능하면 1 , 실패시 0
        System.out.println(solution("bbaabaab"));

    }

    public static int solution(String s) {

        if(s.length() == 1 || s.length()%2 == 1){
            return 0;
        }

        ArrayList<Character> str = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(str.size() == 0 ){
                str.add(s.charAt(i)); // str 이 비어있다면 문자열의 char 추가
            } else {
                if(str.get(str.size()-1) == s.charAt(i)){
                    str.remove(str.size()-1);
                } else {
                    str.add(s.charAt(i));
                }
            }
        }


        if(str.size() == 0){
            return 1;
        } else {
            return 0;
        }
    }
}
