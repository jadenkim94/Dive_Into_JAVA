package algorithm.backjun.dfs_bfs;

import java.util.*;

/*
https://www.acmicpc.net/problem/2667
 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다.

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
3
7
8
9

 */
public class Number_2667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] maps = new int[n][n];
        low = n;
        col = n;

        sc.nextLine();

        for(int i = 0 ; i  < low; i++){
            String input = sc.nextLine();
            char[] chars = input.toCharArray();
            for(int j = 0 ; j < chars.length; j++){
                maps[i][j] = chars[j] - '0';
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(maps[i][j] == 1){
                    bfs(maps, i, j);
                }
            }
        }
        System.out.println(listOfTownSize.size());
        Collections.sort(listOfTownSize);
        for(int i : listOfTownSize){
            System.out.println(i);
        }

    }

    static ArrayList<Integer> listOfTownSize = new ArrayList<>();
    static int townSize = 0;
    static int low, col;
    static int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private static void bfs(int[][] maps, int x, int y) {
        Queue<Node_1> queue = new LinkedList<>();
        queue.add(new Node_1(x, y));
        townSize ++;
        maps[x][y] = 0;
        while (!queue.isEmpty()){
            Node_1 current = queue.poll();
            for(int [] dir : dirs){
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];
                if(nx >= 0 && ny >= 0 && nx < low && ny < col && maps[nx][ny] == 1){
                    maps[nx][ny] = 0;
                    townSize++;
                    queue.add(new Node_1(nx, ny));
                }
            }
        }
        listOfTownSize.add(townSize);
        townSize = 0;
    }

}

class Node_1 {
    int x;
    int y;

    public Node_1(int x, int y){
        this.x = x;
        this.y = y;
    }
}

