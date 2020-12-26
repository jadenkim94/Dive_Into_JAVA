package algorithm.programmers;
/*
https://programmers.co.kr/learn/courses/30/lessons/12918

문자열 다루기 기본
문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 */
public class StringHandling {

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(solution(s));
        s = "9999";
        System.out.println(solution(s));

        char a = '0';
        int i = a -'0';
        System.out.println(i);
    }

    public static boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6){
            for(int i = 0 ; i <s.length(); i++){
                char c = s.charAt(i);
                if( c-'0' < 0 || c-'0' > 9)
                    return false;
            }
            return true;
        }
        return false;
    }

    public static boolean solution2(String s){
        if(s.length() == 4 || s.length() ==6){
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e){
                return false;
            }
        }
        return false;
    }
}
