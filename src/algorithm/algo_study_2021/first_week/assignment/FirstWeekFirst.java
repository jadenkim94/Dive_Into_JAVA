package algorithm.algo_study_2021.first_week.assignment;

import java.util.Stack;

/*
https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class FirstWeekFirst {
    public static void main(String[] args) {
        int [][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int [] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));  // 4
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> collection = new Stack<>();
        int count = 0;

        for(int i = 0; i < moves.length; i++){
            // i = 1, 5, 3, ...
            for(int j = 0; j < board.length; j++){
                // j =  0, 1, 2, 3, 4
                int doll = board[j][moves[i] - 1];
                if(doll != 0){ // 인형이 있는 경우
                    board[j][moves[i]-1] = 0;
                    if(collection.isEmpty()){ // 인형바구니가 비었다면
                        collection.add(doll); // 인형을 넣어준다
                        break;
                    } else {                  // 비어있지 않다면
                        if(collection.peek() == doll){ // 인형바구니 가장 위에 있는 인형과 비교하여
                            collection.pop();          // 같다면 제거
                            count += 2;                // 제거된 인형 카운팅
                            break;
                        } else {                       // 다르다면
                            collection.add(doll);      // 인형바구니에 추가
                            break;
                        }
                    }
                }
            }
        }


        return count;
    }
}
