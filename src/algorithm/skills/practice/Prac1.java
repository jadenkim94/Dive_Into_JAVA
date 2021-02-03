package algorithm.skills.practice;

public class Prac1 {
    private int[][] arrGraph;

    public Prac1(int initSize){
        //그래프 초기화
        //put(int x, int y) 에서 이력되는 정점의 값은 0 이상의 정수이나 배열의 index 는 0부터 시작이므로
        //정점을 담는 인접행렬의 행과 열 size 는 1을 더하여 초기화 해둠
        this.arrGraph = new int[initSize+1][initSize+1];
    }

    public int[][] getGraph(){
        return this.arrGraph;
    }

    // 양방향 그래프 (가중치는 항상 1)
    public void put(int x, int y){
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }

    // 단방향
    public void putSingle(int x, int y){
        arrGraph[x][y] = 1;
    }

    public void printGraphToAdjarr(){
        for(int i = 0; i < arrGraph.length; i++){
            for(int j = 0; j < arrGraph[i].length; j++){
                System.out.print(" " + arrGraph[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int initSize = 6;
        Prac1 graph = new Prac1(initSize);
        graph.put(1,2);
        graph.put(1,3);
        graph.put(2,3);
        graph.put(2,4);
        graph.put(3, 4);
        graph.put(3, 5);
        graph.put(4, 5);
        graph.put(4, 6);

        graph.printGraphToAdjarr();
    }

}
