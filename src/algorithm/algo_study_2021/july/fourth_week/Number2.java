package algorithm.algo_study_2021.july.fourth_week;

import java.util.ArrayList;
import java.util.Arrays;

public class Number2 {
    static class Music{
        String title;
        int startTime;
        int endTime;
        int playTime;
        String played;


        public Music(String title, int startTime, int endTime, int playTime, String played) {
            this.title = title;
            this.startTime = startTime;
            this.endTime = endTime;
            this.playTime = playTime;
            this.played = played;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "title='" + title + '\'' +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", playTime=" + playTime +
                    ", played='" + played + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));

    }

    public static String solution(String m, String[] musicinfos) {

        Music[] musics = new Music[musicinfos.length];

        int count = 0;
        for(String s : musicinfos){
            String[] split = s.split(",");
            int startTime = getStatTime(split[0]);
            int endTime = getEndTime(split[1]);
            int playTime = endTime-startTime;
            String title = split[2];
            String melody = switchMelody(split[3]);
            String played = getPlayed(melody, playTime);
            Music music = new Music(title, startTime, endTime, playTime, played);
            musics[count] = music;
            count++;
        }

        System.out.println(Arrays.toString(musics));

        // 조건일치 음악
        ArrayList<Music> acceptable = new ArrayList<>();

        int maxTime = 0;
        for(Music music : musics){
            if(music.played.contains(switchMelody(m))){
                acceptable.add(music);
                maxTime = Math.max(maxTime, music.playTime);
            }
        }

        if(acceptable.size() == 0) return "(None)";

        ArrayList<Music> finalCondition = new ArrayList<>();
        for(Music music : acceptable){
            if(music.playTime == maxTime){
                finalCondition.add(music);
            }
        }


        return finalCondition.get(0).title;
    }

    private static String switchMelody(String melody) {
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");
        melody = melody.replaceAll("A#", "a");
        return melody;
    }

    private static String getPlayed(String melody, int playTime) {
        StringBuilder played = new StringBuilder();
        while (playTime != 0){
            played.append(melody.charAt(0));
            String left = melody.substring(1);
            String add = melody.substring(0, 1);
            melody = left + add;
            playTime--;
        }
        return played.toString();
    }

    private static int getEndTime(String endTime) {
        String[] split = endTime.split(":");
        int eTime = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        return eTime;
    }

    private static int getStatTime(String startTime) {
        String[] split = startTime.split(":");
        int sTime = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        return sTime;
    }
}
