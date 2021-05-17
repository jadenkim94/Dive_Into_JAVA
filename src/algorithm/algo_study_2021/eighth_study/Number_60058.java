package algorithm.algo_study_2021.eighth_study;

public class Number_60058 {

    public static void main(String[] args) {

        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        StringBuilder stringBuilder = new StringBuilder();
        String answer = "";

        if (p.length() == 0) {
            return "";
        }

        // u, v 로 분리 -----
        int cnt = 0;
        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                index = i;
                break;
            }
        }

        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);
        // u, v 로 분리 -----



        String result = "";
        if (checkProper(u)) { // 문자열 u 가 올바른 문자열
            result = solution(v); // v 에대해 다시 수행
            stringBuilder.append(u);
            stringBuilder.append(result);
            return stringBuilder.toString();
        } else {
            stringBuilder.append("(");
            stringBuilder.append(solution(v));
            stringBuilder.append(")");
            u = u.substring(1, u.length() - 1);
            u = u.replace('(', 'a');
            u = u.replace(')', 'b');
            u = u.replace('a', ')');
            u = u.replace('b', '(');
            stringBuilder.append(u);
            return stringBuilder.toString();
        }
    }


    private static boolean checkProper(String p) {
        int count = 0;
        boolean isProper = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                isProper = false;
                break;
            }
        }

        if(count != 0){
            isProper = false;
        }

        return isProper;
    }

}
