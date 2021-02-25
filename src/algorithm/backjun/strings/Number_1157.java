package algorithm.backjun.strings;

import java.util.Scanner;

/*
https://www.acmicpc.net/problem/1157
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */
public class Number_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.toUpperCase();
        int [] alpha = new int[26];


        for(int i = 0 ; i  < s.length(); i++){
            alpha[alphabatIndex(s.charAt(i))]++;
        }

        int max = 0;
        int index = 0;
        for(int i = 0; i < alpha.length; i++){
            if ( max < alpha[i] ){
                max = alpha[i];
                index = i;
            }
        }

        int moreThan = 0;
        for(int i = 0; i < alpha.length; i++){
            if(alpha[i] == max){
                moreThan ++;
            }
            if(moreThan >=2 ){
                System.out.println("?");
                break;
            }
        }

        if (moreThan == 1){
            System.out.println((char)(index + 65));
        }

    }
    private static int alphabatIndex(char c){
        switch (c){
            case 'A' :
                return 0;
            case  'B' :
                return 1;
            case 'C' :
                return 2;
            case 'D' :
                return 3;
            case 'E' :
                return 4;
            case 'F' :
                return 5;
            case 'G' :
                return 6;
            case 'H' :
                return 7;
            case 'I':
                return 8;
            case 'J':
                return 9;
            case 'K':
                return 10;
            case 'L':
                return 11;
            case 'M':
                return 12;
            case 'N':
                return 13;
            case 'O':
                return 14;
            case 'P':
                return 15;
            case 'Q':
                return 16;
            case 'R':
                return 17;
            case 'S':
                return 18;
            case 'T':
                return 19;
            case 'U':
                return 20;
            case 'V':
                return 21;
            case 'W':
                return 22;
            case 'X':
                return 23;
            case 'Y':
                return 24;
            case 'Z':
                return 25;
        }
        return -1;
    }
}
