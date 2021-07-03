package algorithm.algo_study_2021.jun.forth_week.inflearn;

// 해쉬 문제
/*
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.

입력
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.

출력
학급 회장으로 선택된 기호를 출력합니다.

 */


import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ClassPresident {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        String str = sc.nextLine();

        System.out.println(solution1(n, str));

        System.out.println(solution2(n, str));


    }

    private static Character solution2(int n, String str){
        HashMap<Character, Integer> hashMap = new HashMap<>();



        for(char x : str.toCharArray()){
            hashMap.put(x, hashMap.getOrDefault(x, 0)+1);
        }
        int maxVote = 0;
        Character voted = ' ';
        for(Character key : hashMap.keySet()){
            if(maxVote < hashMap.get(key)){
                maxVote = hashMap.get(key);
                voted = key;
            }
        }
        return voted;
    }

    private static Character solution1(int n, String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        Character [] candidates = {'A', 'B', 'C', 'D', 'E'};
        for (Character candidate : candidates) {
            hashMap.put(candidate, 0);
        }

        char[] chars = str.toCharArray();


        for(int i = 0; i < n; i++){
            hashMap.put(chars[i], hashMap.get(chars[i])+1);
        }

        Set<Character> key = hashMap.keySet();

        Character most = ' ';
        int mostVote = 0;
        for (Character character : key) {
            if( mostVote < hashMap.get(character)){
                mostVote = hashMap.get(character);
                most = character;
            }
        }

        return most;
    }
}
