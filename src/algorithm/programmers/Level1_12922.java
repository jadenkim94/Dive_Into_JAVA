package algorithm.programmers;
/*
https://programmers.co.kr/learn/courses/30/lessons/12922
문제 설명
길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

제한 조건
n은 길이 10,000이하인 자연수입니다.
 */
public class Level1_12922 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static String solution(int n) {
        String answer = "";
        String word = "수박";
        int count = n/2;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < count; i++){
            stringBuilder.append(word);
        }
        if(n % 2 ==1){
            stringBuilder.append("수");
        }

        answer = stringBuilder.toString();

        return answer;
    }
}
