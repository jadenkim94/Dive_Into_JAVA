package algorithm.algo_study_2021.third_week;

/*
https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class StringCompress {
    /*
    문자열길이가 n 이라 가정
    1개 단위로 잘랐을 때 압축 사이즈
    2개 단위로 잘랐을 때 압축 사이즈
    .... n/2 단위로  잘랐을 때 압축 사이즈

    사이즈들을 비교해 가장 짧은 사이즈를 뽑으면 된다.

     */
    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        System.out.println(solution(s));

    }
    public static int solution(String s) {
        // answer = 압축하지 않았을 경우 문자열 길이
        int answer = s.length();

        // i = 문자열을 자르는 단위.
        for(int i = 1; i <= s.length()/2; i++){
            // len = i 단위로 잘랐을 때 문자열의 길이 ( 문자열이 반복되는 만큼 뺴줄것임 )
            int len = s.length();
            // pos = 문자열의 인덱스 position
            int pos = 0;
            for(; pos + i <= s.length(); ){
                // temp = 다음 문자열과 같은지 확인하기 위한 기준문자열의 인덱스
                String temp = s.substring(pos, pos+i);
                System.out.println(temp);
                pos += i;
                // count = temp 와 같은 문자열이 뒤에 존재하면 count 해줄것임
                int count = 0;
                for(; pos + i <= s.length(); ){
                    if(temp.equals(s.substring(pos, pos+i))){
                        count++;
                        pos += i;
                    } else {
                        break;
                    }
                }
                if(count > 0){
                    len -= count * i;
                    if(count < 9){
                        len += 1;
                    } else if ( count < 99){
                        len += 2;
                    } else if (count < 999){
                        len += 3;
                    } else {
                        len += 4;
                    }
                }
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }

}
