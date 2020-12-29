package algorithm.programmers;
/*
https://programmers.co.kr/learn/courses/30/lessons/12926
시저 암호
문제 설명
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다.
z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
Z 를 1만큼 밀면 A

제한 조건
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.
 */
public class Level1_12926 {
    public static void main(String[] args) {
        String s = "zZ yY";
        System.out.println(solution(s, 20));

    }

    public static String solution(String s, int n) {
        String answer = "";
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < chars.length; i++){
            if(!(chars[i]==' ')){
                if(chars[i]>='a' && chars[i]<='z'){
                    int check = chars[i]+n;
                    if (check > 'z'){
                        check = 'a'-1;
                        check = check + n;
                        char valChar = (char)check;
                        stringBuilder.append(valChar);
                    } else {
                        char valChar = (char) check;
                        stringBuilder.append(valChar);
                    }
                } else if(chars[i] >= 'A' && chars[i] <= 'Z'){
                    int check = chars[i]+n;
                    if(check > 'Z'){
                        check = 'A'-1;
                        check = check + n;
                        char valChar = (char)check;
                        stringBuilder.append(valChar);
                    } else{
                        char valChar = (char)check;
                        stringBuilder.append(valChar);
                    }
                }
            } else {
                stringBuilder.append(" ");
            }
        }

        answer = stringBuilder.toString();
        return answer;
    }
}
