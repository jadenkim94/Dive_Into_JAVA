package algorithm.algo_study_2021.jun.forth_week;

import java.util.ArrayList;
import java.util.Stack;

public class Number_17683 {

    static class Music{
        int startTime;
        int endTime;
        String title;
        String lime;
        int repeat;
        String totalLime;
        int playTime;

        public Music(int startTime, int endTime, String title, String lime, int repeat, String totalLime, int playTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.lime = lime;
            this.repeat = repeat;
            this.totalLime = totalLime;
            this.playTime = playTime;
        }
    }

    static Music[] musicList;

    public static void main(String[] args) {
        String m = "ABC";
        String [] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));

    }

    public static String solution(String m, String[] musicinfos) {
        String answer = "";

        musicList = new Music[musicinfos.length];
        for(int i = 0; i < musicinfos.length; i++){
            String[] split = musicinfos[i].split(",");

            int startTime = convertToMinute(split[0]);
            int endTime = convertToMinute(split[1]);
            String title = split[2];
            String lime = split[3];
            String removedLime = removePoundKey(lime);
            int playTime = removedLime.length();
            int repeat = getRepeat(startTime, endTime, playTime);
            String totalLime = getTotalLime(removedLime, repeat, endTime-startTime);
            musicList[i] = new Music(startTime, endTime, title, lime, repeat, totalLime, playTime);
        }


        ArrayList<Music> possibleList = new ArrayList<>();

        for (Music music : musicList) {
            if(music.totalLime.contains(removePoundKey(m))){
                possibleList.add(music);
            }
        }

        Stack<Music> possibleStack = new Stack<>();


        int longestTime = Integer.MIN_VALUE;

        for(int i = 0; i < possibleList.size(); i++){
            if(longestTime < possibleList.get(i).playTime){
                longestTime = possibleList.get(i).playTime;
                while (!possibleStack.isEmpty()){
                    possibleStack.pop();
                }
                possibleStack.add(possibleList.get(i));
            } else if ( longestTime == possibleList.get(i).playTime){
                possibleStack.add(possibleList.get(i));
            }
        }

        if(possibleStack.isEmpty()){
            return "(None)";
        } else {
            return possibleStack.pop().title;
        }

    }

    private static String removePoundKey(String lime) {
        char[] chars = lime.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '#'){
                if(chars[i-1] == 'C'){
                    sb.deleteCharAt(sb.length()-1);
                    sb.append('X');
                } else if (chars[i-1] == 'D'){
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("Y");
                } else if (chars[i-1] == 'F'){
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("Z");
                } else if (chars[i-1] == 'G') {
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("N");
                } else if(chars[i-1] == 'A'){
                    sb.deleteCharAt(sb.length()-1);
                    sb.append("M");
                }
            } else sb.append(chars[i]);
        }
        return sb.toString();
    }

    private static String getTotalLime(String lime, int repeat, int playTime) {
        StringBuilder sb = new StringBuilder();
        if(playTime > lime.length() && repeat == 0){
            char[] chars = lime.toCharArray();
            for(int i = 0; i < playTime; i++){
                sb.append(chars[i]);
            }
            return sb.toString();
        }

        if (repeat == 0) return lime;

        for(int i = 0; i < repeat; i++){
            sb.append(lime);
        }
        return sb.toString();
    }

    private static int getRepeat(int startTime, int endTime, int playTime){
        return (endTime-startTime)/playTime;
    }

    private static int convertToMinute(String time) {
        String[] split1 = time.split(":");
        int hour = Integer.parseInt(split1[0]);
        int minute = Integer.parseInt(split1[1]);
        int totalMin = hour * 60 + minute;
        return totalMin;
    }
}
