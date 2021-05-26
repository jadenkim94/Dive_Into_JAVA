package algorithm.algo_study_2021.ninth_week.ninth_homework;

import java.util.ArrayList;
import java.util.Collections;


public class Number_17677 {
    public static void main(String[] args) {
        System.out.println(solution("E=M*C^2", "e=m*c^2"));

    }

    public static int solution(String str1, String str2) {
        double answer = 0;

        // 모두 대문자 변경
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 문자열 집합으로 변경
        ArrayList<String> stringSet1 = toStringSet(str1);
        ArrayList<String> stringSet2 = toStringSet(str2);

        // 잘못된 문자열 집합 제거
        stringSet1 = ignoreException(stringSet1);
        stringSet2 = ignoreException(stringSet2);

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();

        Collections.sort(stringSet1);
        Collections.sort(stringSet2);


        for(String s : stringSet1){
            if(stringSet2.remove(s)){
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : stringSet2){
            union.add(s);
        }

        if(union.size() == 0){
            return 65536;
        } else {
            return (int) ((double)intersection.size()/(double)union.size()*65536);
        }
    }

    private static ArrayList<String> ignoreException(ArrayList<String> stringSet) {
        ArrayList<String> ignoredStringArray = new ArrayList<>();
        for(int i = 0; i < stringSet.size(); i++){
            String s = stringSet.get(i);
            boolean isOkay = true;
            for(int j = 0; j < s.length(); j++){
                if( s.charAt(j) < 'A' ||  s.charAt(j) > 'Z') {
                    isOkay = false;
                }
            }
            if(isOkay){
                ignoredStringArray.add(s);
            }
        }
        return ignoredStringArray;
    }


    private static ArrayList<String> toStringSet(String str){
        ArrayList<String> strSet = new ArrayList<>();
        for(int i = 0; i < str.length()-1; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(i));
            sb.append(str.charAt(i+1));
            strSet.add(sb.toString());
        }
        return strSet;
    }




}
