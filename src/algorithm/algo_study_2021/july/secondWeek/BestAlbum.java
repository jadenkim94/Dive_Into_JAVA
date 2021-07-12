package algorithm.algo_study_2021.july.secondWeek;

/*
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

class Genre implements Comparable<Genre>{

    private String genre;
    private int playTime;

    public Genre(String genre, int playTime) {
        this.genre = genre;
        this.playTime = playTime;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlayTime() {
        return playTime;
    }

    @Override
    public int compareTo(Genre o) {
        return o.playTime - this.playTime;  // 내림차순
    }
}

class Song  {

    private String genre;
    private int genrePriority;
    private int playTime;
    private int sId;

    public Song(String genre, int genrePriority, int playTime, int sId) {
        this.genre = genre;
        this.genrePriority = genrePriority;
        this.playTime = playTime;
        this.sId = sId;
    }

    public String getGenre() {
        return genre;
    }

    public int getGenrePriority() {
        return genrePriority;
    }

    public int getPlayTime() {
        return playTime;
    }

    public int getsId() {
        return sId;
    }
}

public class BestAlbum {

    public static void main(String[] args) {

        String [] genres = {"classic", "pop", "classic", "classic", "pop"};
        int [] plays = {500, 600, 150, 800, 2500};


        int[] solution = solution(genres, plays);

        for (int i : solution) {
            System.out.println(i);
        }


    }

    public static int[] solution(String[] genres, int[] plays) {

        // 장르별 재생횟수
        HashMap<String, Integer> genrePlayTime = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            genrePlayTime.put(genre, genrePlayTime.getOrDefault(genre, 0)+plays[i]);
        }

        // 장르 우선순위큐 생성
        PriorityQueue<Genre> genrePq = new PriorityQueue<>();
        Set<String> keys = genrePlayTime.keySet();
        for(String key : keys){
            genrePq.add(new Genre(key, genrePlayTime.get(key)));
        }

        // 장르 우선순위 HashMap
        HashMap<String, Integer> genrePriorityMap = new HashMap<>();
        int p = 0;
        while (!genrePq.isEmpty()){
            genrePriorityMap.put(genrePq.poll().getGenre(), p++);
        }

        ArrayList<Song> songs = new ArrayList<>();
        for(int i = 0; i < genres.length; i++){
            Song song = new Song(genres[i], genrePriorityMap.get(genres[i]), plays[i], i);
            songs.add(song);
        }

        Collections.sort(songs, (o1, o2) -> {
            // 장르 우선순위 오름차순
            if(o1.getGenrePriority() < o2.getGenrePriority()){
                return -1;
            } else if (o1.getGenrePriority() > o2.getGenrePriority()){
                return 1;
            } else {
                // 장르 우선순위가 같으면 재생된 노래 횟수 내림차순
                if(o1.getPlayTime() < o2.getPlayTime()){
                    return 1;
                } else if (o1.getPlayTime() > o2.getPlayTime()){
                    return -1;
                } else {
                    // sid 오름차순
                    if(o1.getsId() < o2.getsId()){
                        return -1;
                    } else if(o1.getsId() > o2.getsId())
                        return 1;
                }
            }
            return 0;
        });

        HashMap<String, Integer> maxTwo = new HashMap<>();

        ArrayList<Integer> arr = new ArrayList<>();

        for (Song song : songs) {
            if(maxTwo.getOrDefault(song.getGenre(), 0) == 0){
                maxTwo.put(song.getGenre(), 1);
                arr.add(song.getsId());
            } else {
                if(maxTwo.get(song.getGenre()) < 2){
                    maxTwo.put(song.getGenre(), maxTwo.get(song.getGenre())+1);
                    arr.add(song.getsId());
                }
            }
        }

        int [] answer = new int[arr.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
