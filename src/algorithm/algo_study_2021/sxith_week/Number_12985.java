package algorithm.algo_study_2021.sxith_week;

public class Number_12985 {
    public static void main(String[] args) {
        System.out.println(solution(8,4,5));

    }

    /**
     * @param n = 참가자 수
     * @param a = a 번호
     * @param b = b 번호
     * @return  a 와 b 가 만날때 까지  필요한 대진 횟수
     */
    public static int solution(int n, int a, int b) {
        int count = 1;

        int tmp = b;
        if(a > b){
            b = a;
            a = tmp;
        }

        if(Math.abs(a-b) == 1 && a%2 ==1){
            return count;
        }

        while ( n >= 2 ){ // 2명 이상 이어야 대진 가능
            count ++;
            // 대진 진행 시 a 값 재설정
            if ( a % 2 != 0){
                a = a/2 + 1;
            } else {
                a = a/2;
            }

            // 대진 진행 시 b 값 재설정
            if( b % 2 != 0){
                b = b/2 + 1;
            } else {
                b = b/2;
            }

            // \a - b\ = 1 이라면 둘 간의 대결 성사
            if(Math.abs(a-b) == 1 && a%2 ==1){
                return count;
            } else {
                n = n/2;
            }
        }

        // 여기까지 오면 안됨
        return count;

    }
}
