package algorithm.algo_study_2021.jun.forth_week;

import java.util.ArrayList;
import java.util.Stack;

public class Number_17683 {

    static class Music{
        int startTime;
        int endTime;
        String title;
        String musicalNote;
        int repeat;
        String onAirNote;
        int playTime;

        public Music(int startTime, int endTime, String title, String musicalNote, int repeat, String onAirNote, int playTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.musicalNote = musicalNote;
            this.repeat = repeat;
            this.onAirNote = onAirNote;
            this.playTime = playTime;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", title='" + title + '\'' +
                    ", musicalNote='" + musicalNote + '\'' +
                    ", repeat=" + repeat +
                    ", onAirNote='" + onAirNote + '\'' +
                    ", playTime=" + playTime +
                    '}';
        }
    }

    static Music[] musicList;

    public static void main(String[] args) {
        String m = "ABC";
        String [] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));

    }

    public static String solution(String m, String[] musicinfos) {

        musicList = new Music[musicinfos.length];

        for(int i = 0; i < musicinfos.length; i++){
            String[] split = musicinfos[i].split(",");

            // 방송 시작 시간
            int startTime = convertToMinute(split[0]);
            // 방송 종료 시간
            int endTime = convertToMinute(split[1]);
            // 제목
            String title = split[2];
            // 악보
            String musicalNote = split[3];
            // # 을 치환한 악보
            String poundKeyRemovedMusicalNote = removePoundKey(musicalNote);
            // 음악의 연주 시간
            int musicTime = poundKeyRemovedMusicalNote.length();
            // 방송된 연주 시간
            int playTime = getPlayTime(startTime, endTime, poundKeyRemovedMusicalNote);
            // 악보 반복 횟수
            int repeat = getRepeat(startTime, endTime, musicTime, playTime);

            // 방송된 음악의 악보
            String onAirNote = getOnAirNote(poundKeyRemovedMusicalNote, repeat, playTime);

            musicList[i] = new Music(startTime, endTime, title, musicalNote, repeat, onAirNote, playTime);
        }


        // 조건이 일치하는 음악목록
        ArrayList<Music> possibleList = new ArrayList<>();

        for (Music music : musicList) {
            System.out.println(music);
            if(music.onAirNote.contains(removePoundKey(m))){
                possibleList.add(music);
            }
        }

        // 조건이 일치하며 방송시간이 가장 긴 음악목록
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

    private static int getPlayTime(int startTime, int endTime, String poundKeyRemovedMusicalNote) {
        if( (endTime - startTime) < poundKeyRemovedMusicalNote.length() ) return endTime-startTime;
        else return poundKeyRemovedMusicalNote.length();
    }

    // 우물정 제거
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

    // 결과적으로 재생되는 멜로디
    private static String getOnAirNote(String poundKeyRemovedMusicalNote, int repeat, int playTime) {
        StringBuilder sb = new StringBuilder();

        if(playTime < poundKeyRemovedMusicalNote.length() && repeat == 0){
            char[] chars = poundKeyRemovedMusicalNote.toCharArray();
            for(int i = 0; i < playTime; i++){
                sb.append(chars[i]);
            }
            return sb.toString();
        }

        if (repeat == 0) return poundKeyRemovedMusicalNote;

        for(int i = 0; i < repeat; i++){
            sb.append(poundKeyRemovedMusicalNote);
        }
        return sb.toString();
    }

    // 반복횟수
    private static int getRepeat(int startTime, int endTime, int musicTime, int playTime){
        if(musicTime < playTime) return 0;
        else return (endTime-startTime)/musicTime;
    }

    private static int convertToMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int totalMin = hour * 60 + minute;
        return totalMin;
    }
}
