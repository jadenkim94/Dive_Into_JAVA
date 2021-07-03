package algorithm.algo_study_2021.jun.forth_week;

public class Number_17679 {
    public static void main(String[] args) {

        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));

    }

    static Character [][] map;
    static int row;
    static int col;


    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new Character[m][n];
        row = m;
        col = n;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        while (true){
            boolean[][] check = new boolean[row][col];

            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(map[i][j] != '@'){
                        checkDelete(check, i, j);
                    }
                }
            }

            int countDelete = dropBlock(check);

            if(countDelete == 0) break;
            answer += countDelete;
        }

        return answer;
    }

    private static int dropBlock(boolean[][] check) {
        int cnt = 0;

        for(int y = 0; y < col; y++){
            for(int x = 0; x < row; x++){
                if(check[x][y] != true)
                    continue;

                cnt++;
                for(int i = x; i >= 0; i--){
                    if( i == 0 ){
                        map[i][y] = '@';
                    } else {
                        map[i][y] = map[i-1][y];
                    }
                }
            }
        }

        return cnt;

    }

    private static void checkDelete(boolean[][] check, int r, int c) {
        int [] dr = {0, 1, 1};
        int [] dc = {1, 0, 1};
        boolean flag = true;

        for(int i = 0; i < 3; i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if( !(0 <= nR && nR < row && 0 <= nC && nC < col) || map[r][c] != map[nR][nC]){
                flag = false;
                break;
            }
        }

        if(flag){
            check[r][c] = true;
            for(int i = 0; i < 3 ;i++){
                int nR = r + dr[i];
                int nC = c + dc[i];

                check[nR][nC] = true;
            }
        }

    }


}
