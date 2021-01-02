package algorithm.programmers;
/*
[카카오 인턴] 키패드 누르기
문제 설명
스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.

                    123
                    456
                    789
                    *0#
                     c

이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand 가 매개변수로 주어질 때,
각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.



[제한사항]
numbers 배열의 크기는 1 이상 1,000 이하입니다.
numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
hand 는 "left" 또는 "right" 입니다.
"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.



[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	    "right"	"LLRLLRLLRL"
 */
public class Level1_67256 {
    public static void main(String[] args) {
        int [] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int rHand = 10; // 10 = *
        int lHand = 12; // 12 = #


        for(int num : numbers){
            // 0 입력시 11 로 생각
            int leftVal = 0;
            int rightVal = 0;
            int leftDistance = 0;
            int rightDistance = 0;
            if(num == 0){
                num = 11;
            }

            //1, 4 ,7 인 경우 무조건 L
            if(num == 1 || num == 4 || num == 7){
                answer += "L";
                lHand = num;  // 왼쪽 손가락은 해당 번호로 이동
            //3, 6, 9 인 경우 무조건 R
            } else if (num == 3 || num == 6 || num == 9){
                answer += "R";
                rHand = num; // 오른쪽 손가락은 해당 번호로 이동
            //2, 5, 8, 0(11) 인 경우 가까운쪽이 먼저이고, 거리가 같다면 오른손잡이는 오른손
            } else {

                 leftVal = Math.abs(num - lHand);
                 rightVal = Math.abs(num - rHand);

                leftDistance = getDistance(leftVal);
                rightDistance = getDistance(rightVal);


                if(leftDistance > rightDistance){
                   answer += "R";
                   rHand = num;

                } else if (leftDistance < rightDistance){
                    answer += "L";
                    lHand = num;
                } else {
                    //같은 경우
                    if(hand.equals("right")){
                        answer += "R";
                        rHand = num;
                    } else if(hand.equals("left")){
                        answer += "L";
                        lHand = num;
                    }
                }
            }
        }
        return answer;
    }

    private static int getDistance(int val) {
        int distance = 0;
        if(val == 1 ){
            distance = 1;
        } else if ( val == 2 || val == 4){
            distance = 2;
        } else if (val == 5 || val == 7){
            distance = 3;
        } else if( val == 8 || val == 10){
            distance = 4;
        } else if ( val == 3 ){
            distance = 1;
        } else if ( val == 6 ){
            distance = 2;
        } else if ( val == 9 ){
            distance = 3;
        }
        return distance;
    }
}
