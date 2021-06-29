package algorithm.algo_study_2021.jun.forth_week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class City implements Comparable<City>{
    private int cityNum;
    private int cost;

    public City(int cityNum, int cost) {
        this.cityNum = cityNum;
        this.cost = cost;
    }

    @Override
    public int compareTo(City c) {
        return this.cost - c.cost;
    }

    public int getCityNum() {
        return cityNum;
    }

    public void setCityNum(int cityNum) {
        this.cityNum = cityNum;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
public class Number_12978 {

    static List<List<City>> graph = new ArrayList<>();
    static int [] d;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    public static int solution(int N, int[][] road, int K) {
        d = new int[N+1];
        Arrays.fill(d, INF);
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] r : road){
            int startCity = r[0];
            int endCity = r[1];
            int distance = r[2];

            graph.get(startCity).add(new City(endCity, distance));
            graph.get(endCity).add(new City(startCity, distance));
        }

        dijkstra();

        int count = 0;
        for(int i = 1; i <= N; i++){
            if(d[i] <= K){
                count++;
            }
        }
        return count;

    }

    private static void dijkstra() {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(1, 0));
        d[1] = 0;

        while (!pq.isEmpty()){
            City city = pq.poll();
            int nNum = city.getCityNum();
            int nCost = city.getCost();

            if(d[nNum] < nCost) continue;

            List<City> cities = graph.get(nNum);
            for (City c : cities) {
                int cost  = c.getCost() + nCost;

                if(cost <  d[c.getCityNum()]){
                    d[c.getCityNum()] = cost;
                    pq.offer(new City(c.getCityNum(), cost));
                }
            }
        }

    }
}
