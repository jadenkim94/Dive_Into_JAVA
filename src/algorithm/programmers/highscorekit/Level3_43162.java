package algorithm.programmers.highscorekit;

import java.util.ArrayList;

/*
https://programmers.co.kr/learn/courses/30/lessons/43162

문제 설명
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computerArr[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.

3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 */
public class Level3_43162 {

    public static void main(String[] args) {
        int n = 3;
        int [][] computers ={{1,1,0},{1,1,0},{0,0,1}};

        solution(n, computers);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        Graph graph = new Graph(n);

        for(int i = 0 ; i < n; i++){
            graph.computerArr[i] = new Computer(i);
        }

        for(int i = 0 ; i < computers.length ; i++){
            for(int j = 0 ; j < computers[i].length; j++){
                if(computers[i][j] == 1){
                    graph.addEdge(i, j);   // i, j 는 컴퓨터 번호
                }
            }
        }

        for(int i = 0 ; i < n; i++){
            if(!graph.computerArr[i].checked){
                graph.dfs(i);
                answer++;
            }
        }
        return answer;
    }
}

class Computer{
    int number;
    ArrayList<Computer> adjacent;
    boolean checked;

    public Computer(int number){
        this.number = number;
        adjacent = new ArrayList<>();
        this.checked = false;
    }
}

class Graph{
    Computer[] computerArr;

    public Graph(int size){
        computerArr = new Computer[size];
    }

    public void addEdge(int c1, int c2){
        if(!computerArr[c1].adjacent.contains(computerArr[c2])){
            computerArr[c1].adjacent.add(computerArr[c2]);
        }
        if(!computerArr[c2].adjacent.contains(computerArr[c1])){
            computerArr[c2].adjacent.add(computerArr[c1]);
        }
    }

    public void dfs(int c){
        if(computerArr[c] == null){
            return;
        }
        for(int i = 0 ; i < computerArr[c].adjacent.size(); i++){
            if(!computerArr[c].adjacent.get(i).checked){
                computerArr[c].adjacent.get(i).checked = true;
                dfs(computerArr[c].adjacent.get(i).number);
            }
        }
    }

}
