package algorithm.algo_study_2021.july.thirdWeek;

import java.util.ArrayList;

public class Number_67257 {

    static char [] opArr;
    static boolean [] used;
    static char [] opPriority;
    static ArrayList<String> possible = new ArrayList<>();
    static ArrayList<Long> operands = new ArrayList<>();
    static ArrayList<Character> operators = new ArrayList<>();
    static long answer = 0;

    private static void dfs(int d){
        if( d == opArr.length ){
            StringBuilder sb = new StringBuilder();
            for(char c : opPriority){
                sb.append(c);
            }
            possible.add(sb.toString());
        } else {
            for(int i = 0; i < opArr.length; i++){
                if(!used[i]){
                    used[i] = true;
                    opPriority[d] = opArr[i];
                    dfs(d + 1);
                    used[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }

    public static long solution(String expression) {

        setOperators(expression);
        setOpArr(operators);
        used = new boolean[opArr.length];
        opPriority = new char[opArr.length];
        dfs(0);
        setOperands(expression);

        calc();

        return answer;
    }

    private static void calc() {
        for(int i = 0; i < possible.size(); i++){
            ArrayList<Long> copyOperands = new ArrayList<>(operands);
            ArrayList<Character> copyOperators = new ArrayList<>(operators);

            String currentPriority = possible.get(i);
            char[] chars = currentPriority.toCharArray();
            for(int j = 0; j < chars.length; j++){
                for(int k = 0; k < copyOperators.size(); k++){
                    if(chars[j] == copyOperators.get(k)){
                        copyOperators.remove(k);
                        Long res = clac2(copyOperands.remove(k), copyOperands.remove(k), chars[j]);
                        copyOperands.add(k, res);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(copyOperands.get(0)));

        }
    }

    private static Long clac2(Long lt, Long rt, char op) {
        switch (op){
            case '+' : {
                return lt + rt;
            }
            case '-' : {
                return lt - rt;
            }
            case '*' : {
                return lt * rt;
            }
        }
        return (long)0;
    }

    private static void setOpArr(ArrayList<Character> operators) {
        ArrayList<Character> chars = new ArrayList<>();
        if (operators.contains('*')) chars.add('*');
        if (operators.contains('+')) chars.add('+');
        if (operators.contains('-')) chars.add('-');

        opArr = new char[chars.size()];
        for (int i = 0; i < opArr.length; i++) {
            opArr[i] = chars.get(i);
        }

    }



    private static void setOperands(String expression) {
        String s = expression.replaceAll("\\*", " ");
        s = s.replaceAll("\\+", " ");
        s = s.replaceAll("\\-", " ");

        String[] opArr = s.split(" ");

        for(String str : opArr){
            operands.add(Long.valueOf(str));
        }

    }

    private static ArrayList<Character> setOperators(String expression) {
        for(char c : expression.toCharArray()){
            if( c == '*') operators.add('*');
            else if ( c == '+') operators.add('+');
            else if ( c == '-') operators.add('-');
        }
        return operators;
    }
}
