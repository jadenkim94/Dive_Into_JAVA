package algorithm.algo_study_2021.second_week;

public class NumberOf124World {
    public static void main(String[] args) {
        for(int i = 1; i <= 20; i++){
            System.out.println(solution(i));
        }
    }


    static String solution(int n){
        StringBuilder stringBuilder = new StringBuilder();
        translate(stringBuilder, n);
        return stringBuilder.reverse().toString();
    }

    static void translate(StringBuilder stringBuilder, int n){
        if((n-3) <= 0){
            if(n%3 == 1){
                stringBuilder.append(1);
            } else if(n%3 == 2){
                stringBuilder.append(2);
            } else if(n%3 == 0){
                stringBuilder.append(4);
            }
            return;
        } else {
            if(n%3 == 1){
                stringBuilder.append(1);
            } else if(n%3 == 2){
                stringBuilder.append(2);
            } else if(n%3 == 0){
                stringBuilder.append(4);
                n--;
            }
            translate(stringBuilder, n/3);
        }
    }


}
