package algorithm.algo_study_2021.july.secondWeek;

import java.util.Stack;

public class Crane {
    public static void main(String[] args) {

        int [][] board = new int [][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = new int [] {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));

    }

    public static int solution(int[][] board, int[] moves) {

        Stack<Integer> bucket = new Stack<>();
        int count = 0;

        for(int i : moves){
            i = i-1;
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != 0){
                    if(bucket.isEmpty()){
                        bucket.push(board[j][i]);
                    } else {
                        if(bucket.peek() == board[j][i]){
                            bucket.pop();
                            count += 2;
                        } else
                            bucket.push(board[j][i]);
                    }
                    board[j][i] = 0;
                    break;
                }
            }
        }


        return count;
    }
}
