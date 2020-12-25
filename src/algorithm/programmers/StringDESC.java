package algorithm.programmers;

import java.util.Arrays;
import java.util.Collections;

/*
문제 설명
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.

  s	              return
Zbcdefg	   ->     gfedcbZ
 */
public class StringDESC  {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        Integer [] arr = new Integer[s.length()];

        for(int i = 0 ; i < s.length(); i++){
            arr[i] = s.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int[] iArr = new int[arr.length];
        for(int i = 0 ; i < iArr.length; i++){
            iArr[i] = arr[i];
        }

        char[] chars = new char[arr.length];

        for(int i = 0; i < chars.length; i++){
            chars[i] = (char)(iArr[i]+'0');
        }

        answer = new String(chars);

        return answer;
    }
}
