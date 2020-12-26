package algorithm.programmers;

import java.util.Arrays;
import java.util.List;

/*
https://programmers.co.kr/learn/courses/30/lessons/12916
문제 설명
대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
다르면 False 를 return 하는 solution 를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True 를 리턴합니다.
 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

예를 들어 s가 pPoooyY 면 true 를 return 하고 Pyy 라면 false 를 return 합니다.

제한사항
문자열 s의 길이 : 50 이하의 자연수
문자열 s는 알파벳으로만 이루어져 있습니다.
 */
public class NumberOfpAndy {

    public static void main(String[] args) {
        String s= "pPoooyY";
        System.out.println(solution(s));
        s = "Pyy";
        System.out.println(solution(s));
    }

    static boolean solution(String s) {

        s = s.toUpperCase();
        int pCnt = 0;
        int yCnt = 0 ;
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length; i ++){
            if(chars[i]=='P'){
                pCnt ++;
            } else if ( chars[i]=='Y')
                yCnt ++;
        }
        return (pCnt - yCnt == 0);

    }
}
