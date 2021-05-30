package algorithm.algo_study_2021.ninth_week.ninth_homework;

public class Number_12951 {
    public static void main(String[] args) {

        System.out.println(solution(" adgagd 3eagdag "));
    }
    public static String solution(String s) {
        String answer = "";
        boolean last = false;
        if(String.valueOf(s.charAt(s.length()-1)).equals(" ")){
            last = true;
        }
        String[] strings = s.split(" ");
        for(int i = 0 ; i < strings.length; i++){
            strings[i] = strings[i].toLowerCase();
            if(strings[i].equals("")){
                continue;
            }
            String first = String.valueOf(strings[i].charAt(0)).toUpperCase();
            strings[i] = strings[i].replaceFirst(String.valueOf(strings[i].charAt(0)), first);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < strings.length; i++){
            sb.append(strings[i]+ " ");
        }
        if(!last){
            sb.deleteCharAt(sb.length()-1);
        }

        answer = sb.toString();
        return answer;
    }
}
