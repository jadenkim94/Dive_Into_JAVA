package algorithm.algo_study_2021.jun.forth_week;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Number_17683 {

    static class Music{
        int startTime;
        int endTime;
        String title;
        String musicalNote;
        String onAirNote;
        int playTime;

        public Music(int startTime, int endTime, String title, String musicalNote, String onAirNote, int playTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.musicalNote = musicalNote;
            this.onAirNote = onAirNote;
            this.playTime = playTime;
        }
    }

    static Music[] musicList;

    public static void main(String[] args) {
        String m = "ABC";
        String [] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB",
                "13:55,14:00,WORLD,ABCDEF",
                "14:30,14:36,TEST,ABC#AB"
        };
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
            int playTime = endTime - startTime;


            // 방송된 음악의 악보
            String onAirNote = getOnAirNote(poundKeyRemovedMusicalNote, playTime);

            musicList[i] = new Music(startTime, endTime, title, musicalNote, onAirNote, playTime);
        }


        // 조건이 일치하는 음악목록
        ArrayList<Music> possibleList = new ArrayList<>();

        for (Music music : musicList) {
            if(music.onAirNote.contains(removePoundKey(m))){
                possibleList.add(music);
            }
        }

        // 조건이 일치하며 방송시간이 가장 긴 음악목록
        Queue<Music> possibleQue = new LinkedList<>();

        int longestTime = Integer.MIN_VALUE;

        for(int i = 0; i < possibleList.size(); i++){
            if(longestTime < possibleList.get(i).playTime){
                longestTime = possibleList.get(i).playTime;
                while (!possibleQue.isEmpty()){
                    possibleQue.poll();
                }
                possibleQue.add(possibleList.get(i));
            } else if ( longestTime == possibleList.get(i).playTime){
                possibleQue.add(possibleList.get(i));
            }
        }

        if(possibleQue.isEmpty()){
            return "(None)";
        } else {
            return possibleQue.peek().title;
        }

    }

    // 우물정 제거
    private static String removePoundKey(String musicalNote) {
        musicalNote = musicalNote.replace("C#", "c");
        musicalNote = musicalNote.replace("D#", "d");
        musicalNote = musicalNote.replace("F#", "f");
        musicalNote = musicalNote.replace("G#", "g");
        musicalNote = musicalNote.replace("A#", "a");
        return musicalNote;
    }

    // 결과적으로 재생되는 멜로디
    private static String getOnAirNote(String poundKeyRemovedMusicalNote, int playTime) {
        StringBuilder sb = new StringBuilder();

        StringBuilder notes = new StringBuilder();
        while (notes.length() < playTime){
            notes.append(poundKeyRemovedMusicalNote);
        }

        for(int i = 0; i < playTime; i++){
            sb.append(notes.charAt(i));
        }

        return sb.toString();
    }

    private static int convertToMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int totalMin = hour * 60 + minute;
        return totalMin;
    }
}
